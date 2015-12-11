package com.xwkj.api.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xwkj.api.dao.AutoVisitingDao;
import com.xwkj.api.domain.AutoVisiting;

public class AutoVisitingDaoHibernate extends HibernateDaoSupport implements AutoVisitingDao {

	@Override
	public AutoVisiting get(String avid) {
		return getHibernateTemplate().get(AutoVisiting.class, avid);
	}

	@Override
	public String save(AutoVisiting autoVisiting) {
		return (String)getHibernateTemplate().save(autoVisiting);
	}

	@Override
	public void update(AutoVisiting autoVisiting) {
		getHibernateTemplate().update(autoVisiting);
	}

	@Override
	public void delete(AutoVisiting autoVisiting) {
		getHibernateTemplate().delete(autoVisiting);
	}

}
