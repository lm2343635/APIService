package com.xwkj.api.service;

import java.util.List;

import com.xwkj.api.bean.WechaterBean;

public interface WechaterManager {
	
	/**
	 * 通过公众号添加微信用户入库
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	int addByOfficialAccount(String appid, String appsecret);
	
	/**
	 * @return
	 */
	List<WechaterBean> search();

	/**
	 * @param limit
	 * @return
	 */
	List<WechaterBean> random(int limit);
}
