package App.DAO;

import App.DAO.IDAO.UserDAO;
import App.Entities.UserEntity;
import org.hibernate.Session;

import javax.persistence.Query;

public class UserDAOImpl implements UserDAO {
    @Override
    public UserEntity getUserByLogin(String login) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UserEntity where login = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0, login);
            UserEntity res = (UserEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
