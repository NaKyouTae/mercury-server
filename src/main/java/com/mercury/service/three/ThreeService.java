package com.mercury.service.three;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.jpa.model.three.Three;
import com.mercury.jpa.model.word.Word;
import com.mercury.process.three.ThreeProcess;
import com.mercury.service.word.WordService;
import com.mercury.util.DateUtil;

@Service
@SuppressWarnings("unchecked")
public class ThreeService {
	
	@Autowired
	private ThreeProcess threeProcess;
	
	@Autowired
	private WordService weekWordService;
	
	public <T extends Object> T getTotalPoint(String userIdx) throws Exception {
		try {
			return (T) threeProcess.getTotalPoint(userIdx);
		} catch (Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T getPopular() throws Exception {
		return (T) threeProcess.getPopular();
	}
	
	public <T extends Object> T getList() throws Exception {
		return (T) threeProcess.getList();
	}

	public <T extends Object> T seByUser(String userIdx) throws Exception {
		return (T) threeProcess.seByUser(userIdx);
	}
	
	public <T extends Object> T seThreeByIdx(String idx) throws Exception {
		try {
			return (T) threeProcess.seThreeByIdx(idx);
		} catch (Exception e) {
			 e.printStackTrace();
			return (T) e;
		}
	}
	
	public <T extends Object> T seByWord() throws Exception {
		return (T) threeProcess.seByWord();
	}
	
	public <T extends Object> T inThree(Three three) throws Exception {
		Word word = weekWordService.getWeekWords("THREE");
		
		three.setIdx(UUID.randomUUID().toString().replace("-", ""));
		three.setInsertDate(DateUtil.now());
		three.setWordIdx(word.getIdx());
		three.setWord(word.getWord());
		
		return (T) threeProcess.inThree(three);
	}
	
	public <T extends Object> T upThree(Three three) throws Exception {
		three.setUpdateDate(DateUtil.now());
		return (T) threeProcess.upThree(three);
	}
	
	public <T extends Object> T deThree(Three three) throws Exception {
		try {
			threeProcess.deThree(three);
			return (T) Boolean.TRUE;
		}catch(Exception e) {
			return (T) e;
		}
	}
	
	public <T extends Object> T deThreeAllEntities(List<Three> threes) throws Exception {
		try {
			return (T) threeProcess.deThreeAllEntities(threes); 
		}catch(Exception e) {
			return (T) e;
		}
	}
}