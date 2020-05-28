package com.competition.controller.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.common.ControllerResponse;
import com.competition.jpa.model.history.LoginHistory;
import com.competition.service.history.LoginHistoryService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/historys/logins")
public class LoginHistoryController {
	
	@Autowired
	private LoginHistoryService loginHistoryService;
	
	@GetMapping("/{username}")
	public <T extends Object> T seLoginHistoryByUserName(String username) throws Exception {
		ControllerResponse<List<LoginHistory>> res = new ControllerResponse<>();
		
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Login History By User Name :) ");
			res.setResult(loginHistoryService.seLoginHistoryByUserName(username));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("")
	public <T extends Object> T seLoginHistorys() throws Exception{
		ControllerResponse<List<LoginHistory>> res = new ControllerResponse<>();
		
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Login History List :) ");
			res.setResult(loginHistoryService.seLoginHistorys());
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/{idx}")
	public <T extends Object> T seLoginHistory(String idx) throws Exception {
		ControllerResponse<LoginHistory> res = new ControllerResponse<>();
		
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Login History :) ");
			res.setResult(loginHistoryService.seLoginHistory(idx));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PostMapping("")
	public <T extends Object> T inLoginHistory(LoginHistory history) throws Exception {
		ControllerResponse<LoginHistory> res = new ControllerResponse<>();
		
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Insert Login History :) ");
			res.setResult(loginHistoryService.upLoginHistory(history));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PutMapping("/{idx}")
	public <T extends Object> T upLoginHistory(LoginHistory history) throws Exception {
		ControllerResponse<LoginHistory> res = new ControllerResponse<>();
		
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Update Login History :) ");
			res.setResult(loginHistoryService.upLoginHistory(history));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		
		return (T) res;
	}
}
