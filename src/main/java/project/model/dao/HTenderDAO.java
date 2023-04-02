package project.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import project.model.response.Tender;
import project.util.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class HTenderDAO implements ITenderDAO<Tender> {

    @Override
    public Optional<Tender> getByID(String id) {
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

    }

    @Override
    public void update(Tender tender, String[] params) {

    }

    @Override
    public void remove(Tender tender) {

    }
}
