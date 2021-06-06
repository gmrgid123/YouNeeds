package com.web.youneeds.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.web.youneeds.dto.ProjectTitleImgDto;

@Service
public class EditorImgUploadService {
	
	
	public ProjectTitleImgDto titleImgUpload(HttpServletRequest request, MultipartFile file) {
		
		String originName=""; String storedName=""; String uploadPath=""; int fileSize=0;
		UUID uuid = UUID.randomUUID();
		OutputStream out = null;
		
		if(file != null) {
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						originName = file.getOriginalFilename();
						byte[] bytes = file.getBytes();
						fileSize = file.getBytes().length;
						uploadPath = request.getServletContext().getRealPath("/uploadImg/projectTitle");
						
						
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						storedName = uuid + "_" + originName;
						out = new FileOutputStream(new File(uploadPath+"/"+storedName));
						out.write(bytes);
						out.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		}
		
		return new ProjectTitleImgDto(originName, storedName, uploadPath, fileSize);
	}
	

	public void ImgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload, String path) {
		JsonObject json = new JsonObject();
		OutputStream out = null;
		PrintWriter printWriter = null;
		//랜덤 문자 생성
		UUID uuid = UUID.randomUUID();
		
		if(upload != null) {
			if(upload.getSize() > 0 && StringUtils.isNotBlank(upload.getName())) {
				if(upload.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						String originName = upload.getOriginalFilename();
						byte[] bytes = upload.getBytes();
						String uploadPath = request.getServletContext().getRealPath( path );
						
						
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						String storedName = uuid + "_" + originName;
						out = new FileOutputStream(new File(uploadPath+"/"+storedName));
						out.write(bytes);
						out.flush();
						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + path +"/" + storedName;
						
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", storedName);
						json.addProperty("url", fileUrl);
						
						printWriter.println(json);
						printWriter.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						
						try {
							out.close();
							printWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
}
