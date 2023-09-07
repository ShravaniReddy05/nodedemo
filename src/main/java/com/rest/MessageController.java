package com.rest;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Message;

@RestController
@CrossOrigin(origins="*")
public class MessageController {
	ArrayList<Message> messagelist=new ArrayList();
	public MessageController()
	{
		messagelist.add(new Message(1,"329842421","4219972345","Hello!"));
		messagelist.add(new Message(2,"219684064","75421093","Hi, How are you?"));
	}
		@GetMapping("/getAllMessages")
		public ResponseEntity<?> getMessages()
		{
			return new ResponseEntity(messagelist,HttpStatus.OK);
		}
		
		
		@PostMapping("/saveAMessage")
		public String addMessage(@RequestBody Message message)
		{
			messagelist.add(message);
			return "Message added";
		}
	
}
