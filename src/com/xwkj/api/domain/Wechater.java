package com.xwkj.api.domain;

import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONObject;

public class Wechater implements Serializable {

	private static final long serialVersionUID = 8590646650329441934L;
	
	private String wid;
	private String openid;
	private String nickname;
	private Integer sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private Integer subscribe_time;
	private String remark;
	private Integer groupid;
	
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Integer getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Integer subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getGroupid() {
		return groupid;
	}
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	
	public Wechater() {
		super();
	}
	
	public Wechater(JSONObject userInfo) {
		super();
		this.openid = userInfo.getString("openid");
		if(userInfo.getInt("subscribe")==1) {
			this.nickname = new String(Base64.encodeBase64(userInfo.getString("nickname").getBytes()));  
			this.sex = userInfo.getInt("sex");
			this.language = userInfo.getString("language");
			this.city = userInfo.getString("city");
			this.province = userInfo.getString("province");
			this.country = userInfo.getString("country");
			this.headimgurl = userInfo.getString("headimgurl");
			this.subscribe_time = userInfo.getInt("subscribe_time");
			this.remark = userInfo.getString("remark");
			this.groupid = userInfo.getInt("groupid");
		}
	}
	
	public void update(JSONObject userInfo) {
		if(userInfo.getInt("subscribe")==1) {
			this.nickname =  new String(Base64.encodeBase64(userInfo.getString("nickname").getBytes()));  
			this.sex = userInfo.getInt("sex");
			this.language = userInfo.getString("language");
			this.city = userInfo.getString("city");
			this.province = userInfo.getString("province");;
			this.country = userInfo.getString("country");;
			this.headimgurl = userInfo.getString("headimgurl");;
			this.subscribe_time = userInfo.getInt("subscribe_time");
			this.remark = userInfo.getString("remark");;
			this.groupid = userInfo.getInt("groupid");
		}
	}
}
