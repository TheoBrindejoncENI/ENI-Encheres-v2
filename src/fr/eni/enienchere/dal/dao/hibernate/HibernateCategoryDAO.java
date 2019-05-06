package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.bo.Category;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.CategoryDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class HibernateCategoryDAO implements CategoryDAO {

    @Override
    public void insert(Category category) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public List<Category> selectAll() throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Category ");
        List<Category> categories = q.getResultList();
        return categories;
    }

    @Override
    public List<Category> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Category WHERE idCategory=" + id);
        List<Category> categories = q.getResultList();
        return categories;
    }

    @Override
    public void update(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Category category = (Category) session.get(Category.class, id);
        session.beginTransaction();
        session.saveOrUpdate(category);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Category category = (Category) session.get(Category.class, id);
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
    }
}
