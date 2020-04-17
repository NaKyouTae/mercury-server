package com.competition.controller.love;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.common.ControllerResponse;
import com.competition.jpa.model.Love;
import com.competition.jpa.model.Menu;
import com.competition.service.love.LoveService;
import com.competition.vo.menu.MenuVO;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service")
public class LoveController {

	@Autowired
	private LoveService loveService;
	
	@GetMapping("/loves")
	public <T extends Object> T seLove(String idx) throws Exception {
		ControllerResponse<List<MenuVO>> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Love History :) "); 
			res.setResult(loveService.seLove(idx));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PostMapping("/loves")
	public <T extends Object> T inLove(@RequestBody Love love) throws Exception {
		ControllerResponse<Menu> res = new ControllerResponse<Menu>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Insert Love :) "); 
			res.setResult(loveService.inLove(love));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@DeleteMapping("/loves/{idx}")
	public <T extends Object> T deLove(@RequestBody Love love) throws Exception{
		ControllerResponse<Boolean> res = new ControllerResponse<Boolean>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Delete Love :) "); 
			res.setResult(loveService.deLove(love));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
}