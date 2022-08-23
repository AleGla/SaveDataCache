package com.ar.alegla.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ar.alegla.model.Message;
import com.ar.alegla.model.Request;
import com.ar.alegla.service.ServiceData;

@RestController
public class Controller {

	@Autowired
	private ArrayList<Request> dataList;
	
	@Autowired
	private ServiceData serviceData;
	
	
	@PostMapping(
			value = "/data/save",
			headers = "Accept=application/json",
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<String> saveData(@RequestBody Request request){
		
		serviceData.putData(request, dataList);
		
		JSONObject json = new JSONObject();
		json.put("id", request.getId());
		json.put("message", "To get the Data through from ID");
				
		return new ResponseEntity<>(json.toString(), HttpStatus.OK);
		
	}
	
	
	@GetMapping(
			value = "/data/get/{id}",
			produces = "application/json")
	public ResponseEntity<String> getData(@PathVariable String id){
		
		Request request = serviceData.isDataSaved(id, dataList);
		
		if(request == null) return new ResponseEntity<>(new JSONObject(new Message("The Data wasn't found")).toString(), HttpStatus.NOT_FOUND);
		
		request = serviceData.isDataExpired(request, dataList);
				
		if(request == null) return new ResponseEntity<>(new JSONObject(new Message("The Data been expired")).toString(), HttpStatus.NOT_FOUND);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", request.getRequestData().getName());
		map.put("lastname", request.getRequestData().getLastname());
		map.put("age", request.getRequestData().getAge());
		map.put("nationality", request.getRequestData().getNationality());
		JSONObject json = new JSONObject();
		json.put("data", map);
	
		
		return new ResponseEntity<>(json.toString(), HttpStatus.OK);
		
	}
	
	
	
}
