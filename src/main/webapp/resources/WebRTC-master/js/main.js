'use strict';

//매개변수 설정
var isChannelReady = false;
var isInitiator = false;
var isStarted = false;
var localStream;
var pc;
var remoteStream;
var turnReady;

//public trun & stun 서버 사용(https://gist.github.com/yetithefoot/7592580 오류시 리스트 참조해서 변경하면 됨)
var pcConfig = {
  'iceServers': [{
    'urls': 'stun:stun.l.google.com:19302'
  }]
};

// 오디오 비디오 설정
var sdpConstraints = {
  offerToReceiveAudio: true,
  offerToReceiveVideo: true
};

// room 이름 설정
var room = 'foo';

var socket = io.connect();

if (room !== '') {
  socket.emit('create or join', room);
  console.log('채팅방 생성 및 참여, room');
}

socket.on('created', function(room) {
  console.log('채팅방 생성 ' + room);
  isInitiator = true;
});

socket.on('full', function(room) {
  console.log('방 이름(' + room + ')이 꽉 찼습니다.');
});

socket.on('join', function (room){
  console.log('다른 피어의 채팅방 참여 ' + room);
  console.log('현재 피어는 ' + room + '의 창작자 입니다.');
  isChannelReady = true;
});

socket.on('joined', function(room) {
  console.log('참여중인 방: ' + room);
  isChannelReady = true;
});

socket.on('log', function(array) {
  console.log.apply(console, array);
});


function sendMessage(message) {
  console.log('클라이언트가 전송한 메시지: ', message);
  socket.emit('message', message);
}

// 클라이언트에게 메시지 전송
socket.on('message', function(message) {
  console.log('클라이언트가 받은 메시지:', message);
  if (message === 'got user media') {
    maybeStart();
  } else if (message.type === 'offer') {
    if (!isInitiator && !isStarted) {
      maybeStart();
    }
    pc.setRemoteDescription(new RTCSessionDescription(message));
    doAnswer();
  } else if (message.type === 'answer' && isStarted) {
    pc.setRemoteDescription(new RTCSessionDescription(message));
  } else if (message.type === 'candidate' && isStarted) {
    var candidate = new RTCIceCandidate({
      sdpMLineIndex: message.label,
      candidate: message.candidate
    });
    pc.addIceCandidate(candidate);
  } else if (message === 'bye' && isStarted) {
    handleRemoteHangup();
  }
});

//미디어 설정(되려나)
  const mediaOption = {
    audio: true,
    video: {
      mandatory: {
        maxWidth: 160,
        maxHeight: 120,
        maxFrameRate: 5,
      },
      optional: [
        { googNoiseReduction: true },
        { facingMode: 'user' },
      ],
    },
  };
  

var localVideo = document.querySelector('#localVideo');
var remoteVideo = document.querySelector('#remoteVideo');

navigator.mediaDevices.getUserMedia(mediaOption)
.then(gotStream)
.catch(function(e) {
  alert('getUserMedia() 에러: ' + e.name);
});

function gotStream(stream) {
  console.log('Adding local stream.');
  localStream = stream;
  localVideo.srcObject = stream;
  sendMessage('got user media');
  if (isInitiator) {
    maybeStart();
  }
}

var constraints = {
  video: true
};

console.log('Getting user media with constraints', constraints);

if (location.hostname !== 'localhost') {
  requestTurn(
    'https://computeengineondemand.appspot.com/turn?username=41784574&key=4080218913'
  );
}

function maybeStart() {
  console.log('>>>>>>> maybeStart() ', isStarted, localStream, isChannelReady);
  if (!isStarted && typeof localStream !== 'undefined' && isChannelReady) {
    console.log('>>>>>> creating peer connection');
    createPeerConnection();
    pc.addStream(localStream);
    isStarted = true;
    console.log('isInitiator', isInitiator);
    if (isInitiator) {
      doCall();
    }
  }
}

window.onbeforeunload = function() {
  sendMessage('bye');
};


function createPeerConnection() {
  try {
    pc = new RTCPeerConnection(null);
    pc.onicecandidate = handleIceCandidate;
    pc.onaddstream = handleRemoteStreamAdded;
    pc.onremovestream = handleRemoteStreamRemoved;
    console.log('RTCPeerConnnection 생성');
  } catch (e) {
    console.log('PeerConnection 생성 실패: ' + e.message);
    alert(' RTCPeerConnection 객체 생성 실패');
    return;
  }
}

function handleIceCandidate(event) {
  console.log('icecandidate 이벤트 발생: ', event);
  if (event.candidate) {
    sendMessage({
      type: 'candidate',
      label: event.candidate.sdpMLineIndex,
      id: event.candidate.sdpMid,
      candidate: event.candidate.candidate
    });
  } else {
    console.log('candidates 끝');
  }
}

function handleCreateOfferError(event) {
  console.log('createOffer() 에러: ', event);
}

function doCall() {
  console.log('peer에게 참여 제안');
  pc.createOffer(setLocalAndSendMessage, handleCreateOfferError);
}

function doAnswer() {
  console.log('peer에게 참여 수락');
  pc.createAnswer().then(
    setLocalAndSendMessage,
    onCreateSessionDescriptionError
  );
}

function setLocalAndSendMessage(sessionDescription) {
  pc.setLocalDescription(sessionDescription);
  console.log('setLocalAndSendMessage에서 보낸 메세지', sessionDescription);
  sendMessage(sessionDescription);
}

function onCreateSessionDescriptionError(error) {
  trace('세션 기술 생성 실패: ' + error.toString());
}

function requestTurn(turnURL) {
  var turnExists = false;
  for (var i in pcConfig.iceServers) {
    if (pcConfig.iceServers[i].urls.substr(0, 5) === 'turn:') {
      turnExists = true;
      turnReady = true;
      break;
    }
  }
  if (!turnExists) {
    console.log('Getting TURN server from ', turnURL);
    // TURN server 생성 실패. computeengineondemand.appspot.com으로 우회
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        var turnServer = JSON.parse(xhr.responseText);
        console.log('Got TURN server: ', turnServer);
        pcConfig.iceServers.push({
          'urls': 'turn:' + turnServer.username + '@' + turnServer.turn,
          'credential': turnServer.password
        });
        turnReady = true;
      }
    };
    xhr.open('GET', turnURL, true);
    xhr.send();
  }
}

function handleRemoteStreamAdded(event) {
  console.log('Remote stream 추가');
  remoteStream = event.stream;
  remoteVideo.srcObject = remoteStream;

  remoteVideo.classList.add("remoteVideoInChatting");
  localVideo.classList.add("localVideoInChatting");
}

function handleRemoteStreamRemoved(event) {
  console.log('Remote stream 제거 이벤트: ', event);
}

function hangup() {
  console.log('연결 종료');
  stop();
  sendMessage('종료');
}

function handleRemoteHangup() {
  remoteVideo.classList.remove("remoteVideoInChatting");
  localVideo.classList.remove("localVideoInChatting");
	
  console.log('세션 종료');
  stop();
  isInitiator = false;
}

function stop() {
  isStarted = false;
  pc.close();
  pc = null;
}
