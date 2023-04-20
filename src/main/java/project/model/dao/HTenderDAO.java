package project.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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

            Site existingSite = (Site) session.byNaturalId(Site.class)
                    .using("url", tender.getSite().getUrl())
                    .load();
            if (existingSite != null)
                tender.setSite(existingSite);

            Initiator existingInit = (Initiator) session.byNaturalId(Initiator.class)
                    .using("name", tender.getInitiator().getName())
                    .load();
            if (existingInit != null)
                tender.setInitiator(existingInit);

            Tender existingTender = (Tender) session.byNaturalId(Tender.class)
                    .using("url", tender.getUrl())
                    .load();
            if (existingTender == null) {
                session.getTransaction().begin();
                session.persist(tender);
                session.getTransaction().commit();
            }
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
            session.getTransaction().begin();
            session.remove(tender);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
