package com.web.youneeds.dto;

import java.util.Date;

public class OrderDto {
	private int order_id;
	private String order_name;
	private int order_pay;
	private Date order_date;
	private String order_phone;
	private String order_email;
	private String order_addr;
	private String imp_uid;
	private int p_id;
	private int m_uid;
	
	//join용 필드
	private ProjectDto projectDto;
	private MemberDto memberDto;
	
	public OrderDto() {
		super();
	}
	
	

	public OrderDto(String order_name, int order_pay, String order_phone, String order_email, String order_addr, String imp_uid,
			int p_id, int m_uid) {
		super();
		this.order_name = order_name;
		this.order_pay = order_pay;
		this.order_phone = order_phone;
		this.order_email = order_email;
		this.order_addr = order_addr;
		this.imp_uid = imp_uid;
		this.p_id = p_id;
		this.m_uid = m_uid;
	}



	public int getOrder_id() {
		return order_id;
	}



	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}



	public String getOrder_name() {
		return order_name;
	}



	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}



	public int getOrder_pay() {
		return order_pay;
	}



	public void setOrder_pay(int order_pay) {
		this.order_pay = order_pay;
	}



	public Date getOrder_date() {
		return order_date;
	}



	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}



	public String getOrder_phone() {
		return order_phone;
	}



	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}



	public String getOrder_email() {
		return order_email;
	}



	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}



	public String getOrder_addr() {
		return order_addr;
	}



	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}



	public String getImp_uid() {
		return imp_uid;
	}



	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}



	public int getP_id() {
		return p_id;
	}



	public void setP_id(int p_id) {
		this.p_id = p_id;
	}



	public int getM_uid() {
		return m_uid;
	}



	public void setM_uid(int m_uid) {
		this.m_uid = m_uid;
	}



	public ProjectDto getProjectDto() {
		return projectDto;
	}



	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}



	public MemberDto getMemberDto() {
		return memberDto;
	}



	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}



	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", order_name=" + order_name + ", order_pay=" + order_pay
				+ ", order_date=" + order_date + ", order_phone=" + order_phone + ", order_email=" + order_email
				+ ", order_addr=" + order_addr + ", imp_uid=" + imp_uid + ", p_id=" + p_id + ", m_uid=" + m_uid
				+ ", projectDto=" + projectDto + ", memberDto=" + memberDto + "]";
	}


	
	
	
	
	
	
}
