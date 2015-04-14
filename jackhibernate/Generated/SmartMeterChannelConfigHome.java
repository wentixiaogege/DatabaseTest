// default package
// Generated Apr 14, 2015 2:13:19 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class SmartMeterChannelConfig.
 * @see .SmartMeterChannelConfig
 * @author Hibernate Tools
 */
public class SmartMeterChannelConfigHome {

	private static final Log log = LogFactory
			.getLog(SmartMeterChannelConfigHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SmartMeterChannelConfig transientInstance) {
		log.debug("persisting SmartMeterChannelConfig instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SmartMeterChannelConfig instance) {
		log.debug("attaching dirty SmartMeterChannelConfig instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SmartMeterChannelConfig instance) {
		log.debug("attaching clean SmartMeterChannelConfig instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SmartMeterChannelConfig persistentInstance) {
		log.debug("deleting SmartMeterChannelConfig instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SmartMeterChannelConfig merge(
			SmartMeterChannelConfig detachedInstance) {
		log.debug("merging SmartMeterChannelConfig instance");
		try {
			SmartMeterChannelConfig result = (SmartMeterChannelConfig) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SmartMeterChannelConfig findById(java.lang.Integer id) {
		log.debug("getting SmartMeterChannelConfig instance with id: " + id);
		try {
			SmartMeterChannelConfig instance = (SmartMeterChannelConfig) sessionFactory
					.getCurrentSession().get("SmartMeterChannelConfig", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SmartMeterChannelConfig instance) {
		log.debug("finding SmartMeterChannelConfig instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("SmartMeterChannelConfig")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
