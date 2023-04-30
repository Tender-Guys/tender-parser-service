package project.model.dao;

import project.model.response.Tender;
import java.util.List;

/**
 * @author Mykola Lisnyi
 */
public interface ITenderDAO {
    Tender getByID(Integer id);
    List<Tender> getAll();
    Tender findTender(Tender tender);
    Boolean add(Tender tender);
    Boolean addAll(List<Tender> tenderList);
    void update(Tender tender);
    void updateById(Integer id, Tender tender);
    Boolean remove(Tender tender);
    Tender removeById(Integer id);
    void removeAll();
}