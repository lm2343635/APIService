package com.xwkj.api.dao;

import com.xwkj.api.domain.AutoVisiting;

public interface AutoVisitingDao {
	AutoVisiting get(String avid);
	String save(AutoVisiting autoVisiting);
	void update(AutoVisiting autoVisiting);
	void delete(AutoVisiting autoVisiting);
}
