package com.xwkj.api.dao;

import java.util.List;

import com.xwkj.api.domain.Wechater;
import com.xwkj.common.hibernate3.support.CrudDao;

public interface WechaterDao extends CrudDao<Wechater> {
	
	/**
	 * @param openid
	 * @return
	 */
	Wechater getByOpenId(String openid);
	
	/**
	 * @param count
	 * @return
	 */
	List<Wechater> randomGet(int count);
}
