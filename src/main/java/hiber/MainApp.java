package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("Max", "Mitchal", "user1@mail.ru", new Car("BMW", "X6")));
      userService.add(new User("Dan", "Jenrix", "user2@mail.ru", new Car("Marcedes", "GLC350")));
      userService.add(new User("Alex", "Kovachich", "user3r@mail.ru"));
      userService.add(new User("Tom", "Ronaldinio", "user4@mail.ru"));
      userService.add(new User("Son", "HenMin", "user5@mail.ru", new Car("Volvo", "S60")));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println("User found by model and series: " + userService.getUserByModelAndSeries("1", "1"));
     //userService.deleteAllUsers();
      context.close();
   }
}



