package com.yash.ytms.dto;

import com.yash.ytms.model.TrainingRequestForm;

public class TRFGetByIdResponse {

	private int status;
	private String msg;
	private TrainingRequestForm form;
	public TRFGetByIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TRFGetByIdResponse(int status, String msg, TrainingRequestForm form) {
		super();
		this.status = status;
		this.msg = msg;
		this.form = form;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public TrainingRequestForm getForm() {
		return form;
	}
	public void setForm(TrainingRequestForm form) {
		this.form = form;
	}
	@Override
	public String toString() {
		return "TRFGetByIdResponse [status=" + status + ", msg=" + msg + ", form=" + form + "]";
	}
	
	
}
