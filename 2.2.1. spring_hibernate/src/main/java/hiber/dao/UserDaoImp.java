package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public List<User> listUsers() {

      try (Session session = sessionFactory.openSession()){
         return session.createQuery("from User", User.class).getResultList();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public List<User> getOwner(String model, int series) {

      try (Session session = sessionFactory.openSession()){
         return session.createQuery("from User user where user.car.model = :model and user.car.series = :series", User.class)
                 .setParameter("model", model)
                 .setParameter("series", series)
                 .getResultList();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}
