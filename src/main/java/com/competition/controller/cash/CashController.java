package com.competition.controller.cash;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.common.ControllerResponse;
import com.competition.jpa.model.cash.Cash;
import com.competition.service.cash.CashService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/cashs")
public class CashController {
	
	@Autowired
	private CashService cashService;
	
	@GetMapping("")
	public <T extends Object> T seCashByUserName(String userName) throws Exception{
		ControllerResponse<List<Cash>> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Cash List :) ");
			res.setResult(cashService.seCashByUserName(userName));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/{idx}")
	public <T extends Object> T seCash(String idx) throws Exception{
		ControllerResponse<Cash> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Cash :) ");
			res.setResult(cashService.seCash(idx));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@PostMapping("")
	public <T extends Object> T inCash(Cash cash) throws Exception{
		ControllerResponse<Cash> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Insert Cash :) ");
			res.setResult(cashService.inCash(cash));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@PutMapping("/{idx}")
	public <T extends Object> T upCash(Cash cash) throws Exception{
		ControllerResponse<Cash> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Update Cash :) ");
			res.setResult(cashService.upCash(cash));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
	
	@DeleteMapping("/{idx}")
	public <T extends Object> T deCash(Cash cash) throws Exception{
		ControllerResponse<Boolean> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Delete Cash :) ");
			res.setResult(cashService.deCash(cash));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage());
			res.setResult(null);
		}
		return (T) res;
	}
}