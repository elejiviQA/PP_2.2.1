package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {

      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService =
              context.getBean(UserService.class);

      CarService carService =
              context.getBean(CarService.class);

      carService.add(new Car("Lada1", 1));
      carService.add(new Car("Lada2", 10));
      carService.add(new Car("Lada3", 11));
      carService.add(new Car("Lada4", 100));

      List<Car> cars = carService.listCars();

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", cars.get(2))); // Lada3
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", cars.get(3))); // Lada4
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", cars.get(0))); // Lada1
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", cars.get(1))); // Lada2

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getOwner("Lada3", 11));

      context.close();

   }
}
