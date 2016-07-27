package com.xwkj.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xwkj.api.bean.WechaterBean;
import com.xwkj.api.domain.Wechater;
import com.xwkj.api.service.WechaterManager;
import com.xwkj.api.service.util.ManagerTemplate;
import com.xwkj.common.util.HttpRequestUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WechaterManagerImpl extends ManagerTemplate implements WechaterManager {

	@Override
	public int addByOfficialAccount(String appid, String appsecret) {
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
		JSONObject result=JSONObject.fromObject(HttpRequestUtil.httpRequest(url));
		if(result.get("access_token")==null) {
			return 0;
		}
		String token=result.getString("access_token");
		url="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+token;
		result=JSONObject.fromObject(HttpRequestUtil.httpRequest(url));
		if(result.get("errcode")!=null) {
			System.out.println("Get openids error: "+result.getString("errmsg"));
			return 0;
		}
		int count=result.getInt("count");
		JSONArray openids=result.getJSONObject("data").getJSONArray("openid");
		JSONArray userArray=new JSONArray();
		for(int i=0; i<openids.size(); i++) {
			JSONObject user=new JSONObject();
			user.put("openid", openids.get(i));
			user.put("lang", "zh-CN");
			userArray.add(user);
			//每到100个人读取用户写入数据库
			if(i%100==0) {
				saveUserInfo(userArray, token);
				userArray=new JSONArray();
			}
		}
		saveUserInfo(userArray, token);
		return count;
	}

	private void saveUserInfo(JSONArray userArray, String token) {
		JSONObject userList=new JSONObject();
		userList.put("user_list", userArray);
		String url="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token="+token+"&lang=zh_CN";
		JSONArray userInfoList=JSONArray.fromObject(JSONObject.fromObject(HttpRequestUtil.postJson(url, userList.toString())).get("user_info_list"));
		for(int i=0; i<userInfoList.size(); i++) {
			JSONObject userInfo=userInfoList.getJSONObject(i);
			Wechater wechater=wechaterDao.getByOpenId(userInfo.getString("openid"));
			if(wechater==null) {
				wechater=new Wechater(userInfo);
				wechaterDao.save(wechater);
			} else {
				wechater.update(userInfo);
				wechaterDao.update(wechater);
			}
		}
	}

	@Override
	public List<WechaterBean> search() {
	
		return null;
	}

	@Override
	public List<WechaterBean> random(int limit) {
		List<WechaterBean> wechaters=new ArrayList<>();
		for(Wechater wechater: wechaterDao.randomGet(limit)) {
			wechaters.add(new WechaterBean(wechater));
		}
		return wechaters;
	}
}
