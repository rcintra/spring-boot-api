package com.rcintra.springbootapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorHandler {
	
	private Integer status;
	private LocalDateTime dateTime;
	private String title;
	private List<Field> fields;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	public static class Field {
		private String name;
		private String msg;
		
		public Field(String name, String msg) {
			this.name = name;
			this.msg = msg;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
	}
}
