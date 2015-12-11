package com.xwkj.api.domain;

import java.io.Serializable;

public class AutoVisiting implements Serializable {

	private static final long serialVersionUID = 1L;

	private String avid;
	private String url;
	private int frequency;
	
	public String getAvid() {
		return avid;
	}
	public String getUrl() {
		return url;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setAvid(String avid) {
		this.avid = avid;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
