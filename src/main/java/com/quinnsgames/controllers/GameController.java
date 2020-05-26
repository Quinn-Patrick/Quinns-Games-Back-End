package com.quinnsgames.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnsgames.models.GamePanel;
import com.quinnsgames.repositories.IGameDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/game")
public class GameController {
	
	@Autowired
	private IGameDAO gdao;
	
	@GetMapping("/all")
	public ResponseEntity<List<GamePanel>> getPanels() {
		List<GamePanel> gpList = new ArrayList<>();
		gpList = gdao.findAll();
		
		if(gpList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(gpList);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(gpList);
		}
	}
	
	@PostMapping
	public ResponseEntity<GamePanel> addPanel(@RequestBody GamePanel gp){
		gdao.save(gp);
		return ResponseEntity.status(HttpStatus.CREATED).body(gp);
	}
}

