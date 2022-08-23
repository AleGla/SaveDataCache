package com.ar.alegla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Request {

	private String id;
	
	private long createdTime;
	
	private Data requestData;
	
	

	public Request(String id, long createdTime, Data requestData) {
		super();
		this.id = id;
		this.createdTime = createdTime;
		this.requestData = requestData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public Data getRequestData() {
		return requestData;
	}

	public void setRequestData(Data requestData) {
		this.requestData = requestData;
	}

	
	
	
	
	
}
