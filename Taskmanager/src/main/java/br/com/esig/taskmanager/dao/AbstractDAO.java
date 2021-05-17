package br.com.esig.taskmanager.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.esig.taskmanager.util.HibernateUtil;

public class AbstractDAO<T> {

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public void save(T type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(type);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public List<T> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(classe);
			query.from(classe);
			List<T> result = session.createQuery(query).getResultList();

			return result;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> search(Integer id, String titulo, String descricao, String responsavel, Integer situacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			StringBuilder query = new StringBuilder();
			query.append("FROM Task t WHERE 1=1");
			if (id != null)
				query.append(" AND t.id = " + id);
			if (!titulo.isEmpty())
				query.append(" AND t.titulo like :titulo" );
			if (!descricao.isEmpty())
				query.append(" AND t.descricao like :descricao");
			if (!responsavel.isEmpty())
				query.append(" AND t.responsavel like :responsavel");
			if (situacao != null) {
				query.append(" AND t.emAndamento = " + situacao);
			}
			Query select = session.createQuery(query.toString());
			if(!titulo.isEmpty())
				select.setParameter("titulo", "%"+ titulo + "%");
			if(!descricao.isEmpty())
				select.setParameter("descricao", "%"+ descricao +"%");
			if(!responsavel.isEmpty())
				select.setParameter("responsavel", responsavel);

			return select.getResultList();

		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}

	}

	public void delete(T type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(type);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void update(T type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(type);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void merge(T type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(type);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
