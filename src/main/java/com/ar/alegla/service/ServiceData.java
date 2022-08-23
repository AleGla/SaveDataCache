package com.ar.alegla.service;

import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ar.alegla.model.Request;

@Service
public class ServiceData {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceData.class);
		
	
	public void putData(Request r, ArrayList<Request> req) {			
						
		r.setId(UUID.randomUUID().toString());
		r.setCreatedTime(System.currentTimeMillis());
		req.add(r);		
		
		log.info("Person was added");
		
	}
	
	
	public Request isDataSaved(String id, ArrayList<Request> dataList) {
						
		for(Request request: dataList) {
			if(request.getId().equals(id)) {
				return request;
			}
		}		
		
		return null;
	}
	
	
	
	public Request isDataExpired(Request request, ArrayList<Request> dataList) {
		
		if(System.currentTimeMillis() - request.getCreatedTime() > 120000) {
			if(dataList.isEmpty() == false) {
				for(Request r: dataList) {
					if(request.getId().equals(r.getId())) {
						dataList.remove(r);
						log.info("The Data been expired");
						break;
					}
				}
			}
				return null;
		}
		
			return request;
	}
		
	
	
	
	
	
}
