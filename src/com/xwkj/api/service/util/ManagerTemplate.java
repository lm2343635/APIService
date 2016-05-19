package com.xwkj.api.service.util;

import com.xwkj.api.dao.AutoVisitingDao;
import com.xwkj.api.dao.WechaterDao;

public class ManagerTemplate {
	
	protected AutoVisitingDao autoVisitingDao;
	protected WechaterDao wechaterDao;
	
	public AutoVisitingDao getAutoVisitingDao() {
		return autoVisitingDao;
	}
	public void setAutoVisitingDao(AutoVisitingDao autoVisitingDao) {
		this.autoVisitingDao = autoVisitingDao;
	}
	public WechaterDao getWechaterDao() {
		return wechaterDao;
	}
	public void setWechaterDao(WechaterDao wechaterDao) {
		this.wechaterDao = wechaterDao;
	}
	
}
