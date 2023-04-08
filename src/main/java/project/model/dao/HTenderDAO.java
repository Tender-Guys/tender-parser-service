package project.model.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.model.response.Initiator;
import project.model.response.Site;
import project.model.response.Tender;
import project.util.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class HTenderDAO implements ITenderDAO<Tender> {

    @Override
    public Optional<Tender> getTenderByID(String id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Tender.class, id));
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Tender> getAll() {
        return null;
    }

    @Override
    public void save(Tender tender) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(tender);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tender tender) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.merge(tender);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Tender tender) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.remove(tender);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
