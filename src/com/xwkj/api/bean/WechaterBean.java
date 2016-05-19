package com.xwkj.api.bean;

import org.apache.commons.codec.binary.Base64;

import com.xwkj.api.domain.Wechater;

public class WechaterBean {
	private String openid;
	private String nickname;
	private int sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private int subscribe_time;
	private String remark;
	private int groupid;
	
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
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
	public int getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(int subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	public WechaterBean(Wechater wechater) {
		super();
		this.openid = wechater.getOpenid();
		this.nickname = new String(Base64.decodeBase64(wechater.getNickname()));
		this.sex = wechater.getSex();
		this.language = wechater.getLanguage();
		this.city = wechater.getCity();
		this.province = wechater.getProvince();
		this.country = wechater.getCountry();
		this.headimgurl = wechater.getHeadimgurl();
		this.subscribe_time = wechater.getSubscribe_time();
		this.remark = wechater.getRemark();
		this.groupid = wechater.getGroupid();
	}
	
}
