package fr.eni.enienchere.bll;


import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.Category;
import fr.eni.enienchere.dal.dao.CategoryDAO;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class CategoryManager {


    private CategoryDAO categoryDAO;

    /**
     * Constructor
     * @throws BLLException
     */
    public CategoryManager() throws BLLException {
        categoryDAO = DAOFactory.getCategoryDAO();
    }

    /**
     * insert catagory in bdd
     * @param category
     * @throws BLLException
     */
    public void insertCategory(Category category) throws BLLException {
        try {
            categoryDAO.insert(category);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    /**
     * select all category in bdd
     * @return
     * @throws BLLException
     */
    public List<Category> selectAllCategory() throws  BLLException {
        try {
            return (List<Category>) categoryDAO.selectAll();
        } catch (DALException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * select one category in bdd
     * @param id
     * @return
     * @throws BLLException
     */
    public Category selectCategoryById(long id) throws BLLException {
        try  {
            return (Category) categoryDAO.selectById(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * update category in bdd
     * @param category
     * @throws BLLException
     */
    public  void updateCategory(Category category) throws BLLException {
        try {
            categoryDAO.update(category);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete category
     * @param id
     * @throws BLLException
     */
    public void deleteCategory(long id) throws BLLException {
        try {
            categoryDAO.delete(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

}
