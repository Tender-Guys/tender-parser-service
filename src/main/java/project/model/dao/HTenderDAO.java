package project.model.dao;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import project.model.response.Site;
import project.model.response.Initiator;
import project.model.response.Tender;
import project.util.HibernateSessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;

@Component
public class HTenderDAO implements ITenderDAO {

    @Override
    public Tender getByID(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Tender.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new Tender();
    }

    @Override
    public List<Tender> getAll() {
        List<Tender> tenderList = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Tender> cq = session.getCriteriaBuilder()
                                              .createQuery(Tender.class);
            Root<Tender> rootEntry = cq.from(Tender.class);
            CriteriaQuery<Tender> all = cq.select(rootEntry);
            tenderList = session.createQuery(all)
                                .getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return tenderList;
    }

    @Override
    public Tender findTender(Tender tender) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Tender existingTender = (Tender) session.byNaturalId(Tender.class)
                    .using("url", tender.getUrl())
                    .load();
            if (existingTender != null) {
                tender = existingTender;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return tender;
    }

    @Override
    public Boolean add(Tender tender) {
        Boolean isAdded = false;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Site existingSite = (Site) session.byNaturalId(Site.class)
                    .using("url", tender.getSite().getUrl())
                    .load();
            if (existingSite != null) {
                tender.setSite(existingSite);
            }
            Initiator existingInit = (Initiator) session.byNaturalId(Initiator.class)
                    .using("name", tender.getInitiator().getName())
                    .load();
            if (existingInit != null) {
                tender.setInitiator(existingInit);
            }
            Tender existingTender = (Tender) session.byNaturalId(Tender.class)
                    .using("url", tender.getUrl())
                    .load();
            if (existingTender == null) {
                session.getTransaction().begin();
                session.persist(tender);
                session.getTransaction().commit();
                isAdded = true;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public Boolean addAll(List<Tender> tenderList) {
        Boolean isAdded = false;
        for (Tender tender : tenderList) {
            isAdded |= add(tender);
        }
        return isAdded;
    }

    @Override
    public void update(Tender tender) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.merge(tender);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(Integer id, Tender tender) {
        tender.setId(id);
        update(tender);
    }

    @Override
    public Boolean remove(Tender tender) {
        if (getByID(tender.getId()) == null) {
            return false;
        }
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.remove(tender);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Tender removeById(Integer id) {
        Tender tender = getByID(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            if (tender != null) {
                session.remove(tender);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return tender;
    }

    @Override
    public void removeAll() {
        for (Tender tender : getAll()) {
            remove(tender);
        }
    }
}