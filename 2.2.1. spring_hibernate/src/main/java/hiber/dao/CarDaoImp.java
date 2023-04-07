package hiber.dao;

import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().persist(car);
    }

    @Override
    public List<Car> listCars() {

        try (Session session = sessionFactory.openSession()){
            return session.createQuery("from Car", Car.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
