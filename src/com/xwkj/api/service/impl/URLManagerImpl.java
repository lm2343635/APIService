package com.xwkj.api.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.xwkj.api.service.URLManager;

public class URLManagerImpl implements URLManager {

	@Override
	public String encode(String enc, String url) {
		try {
			return URLEncoder.encode(url, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
