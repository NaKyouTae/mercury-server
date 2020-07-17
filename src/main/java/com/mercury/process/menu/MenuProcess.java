package com.mercury.process.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.mercury.jpa.model.menu.Menu;
import com.mercury.jpa.repository.menu.MenuRepository;

@Component
@SuppressWarnings("unchecked")
public class MenuProcess {
	private static final Logger LOGGER = LogManager.getLogger(MenuProcess.class);
	public MenuProcess() {
		LOGGER.info("Menu Construct Test");
	}

	@Autowired
	private MenuRepository menuRepository;

	public <T extends Object> T getList() throws Exception {
		return (T) menuRepository.findAll(Sort.by(Sort.Direction.ASC, "menuOrder"));
	}
	public <T extends Object> T getListByLevelIsNull() throws Exception {
		return(T) menuRepository.findByParentIsNull();
	}
	public <T extends Object> T getListByLevel(String pidx) throws Exception {
		return(T) menuRepository.findByParent(pidx, Sort.by(Sort.Direction.ASC, "menuOrder"));
	}
	public <T extends Object> T seMenu(String idx) throws Exception {
		return (T) menuRepository.findByIdx(idx);
	}
	public <T extends Object> T inMenu(Menu dto) throws Exception {
		return (T) menuRepository.save(dto);
	}

	public <T extends Object> T upMenu(Menu dto) throws Exception {
		return (T) menuRepository.save(dto);
	}

	public void deMenu(Menu dto) throws Exception {
		menuRepository.delete(dto);
	}
	
}