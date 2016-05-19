package com.xwkj.api.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.xwkj.api.dao.WechaterDao;
import com.xwkj.api.domain.Wechater;
import com.xwkj.common.hibernate3.support.PageHibernateDaoSupport;
import com.xwkj.common.util.MathTool;

public class WechaterDaoHibernate extends PageHibernateDaoSupport<Wechater> implements WechaterDao {

	public WechaterDaoHibernate() {
		super();
		setClass(Wechater.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Wechater getByOpenId(String openid) {
		String hql="from Wechater where openid=?";
		List<Wechater> wechaters= getHibernateTemplate().find(hql, openid);
		if(wechaters.size()==0) {
			return null;
		}
		return wechaters.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wechater> randomGet(int count) {
		String hql="from Wechater";
		int all=getCount();
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Wechater>>() {
			@Override
			public List<Wechater> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(count<all) {
					query.setFirstResult(MathTool.getRandom(all-count));
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}
	
	public int getCount() {
		String hql="select count(*) from Wechater";
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				return (long)query.uniqueResult();
			}
		}).intValue();
	}
}
