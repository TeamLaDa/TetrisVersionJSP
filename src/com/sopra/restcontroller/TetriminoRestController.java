package com.sopra.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.controller.DataAccessController;
import com.sopra.model.Tetrimino;


@RestController
@CrossOrigin
@RequestMapping("/tetrimino")
public class TetriminoRestController extends DataAccessController {

	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Tetrimino>> getAll() {
		return new ResponseEntity<List<Tetrimino>>(this.tetriminosDao.findAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Tetrimino> get(@PathVariable String id) {
		return new ResponseEntity<Tetrimino>(this.tetriminosDao.find(id), HttpStatus.OK);
	}
}
