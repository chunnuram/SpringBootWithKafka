package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
	public KafkaProducer kafkaProducer;
	
	//http:localhost:8080/api/v1/kafka/publish?message=hello word
	@GetMapping("/publish")
	public ResponseEntity<String> produce(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body("message send to the Topic !");
	}
}
