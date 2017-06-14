package com.sopra.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.controller.DataAccessController;
import com.sopra.model.Partie;
import com.sopra.model.Score;

@RestController
@CrossOrigin
@RequestMapping("/score")
public class ScoreRestController extends DataAccessController {
	
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Score>> getAll() {
		return new ResponseEntity<List<Score>>(this.scoreDAO.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Score> add(@RequestBody Score score) {
		score = this.scoreDAO.save(score);
		
		return new ResponseEntity<Score>(score, HttpStatus.OK);
	}
	

}
