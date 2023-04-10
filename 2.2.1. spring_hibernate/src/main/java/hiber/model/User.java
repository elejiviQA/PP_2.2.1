package hiber.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne
   @JoinColumn(name = "car_id")
   private Car car;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public String toString() {
      StringBuilder userToString = new StringBuilder();
      userToString
              .append("\nUSER: \n")
              .append("-> ID = ").append(id).append("\n")
              .append("-> First name = ").append(firstName).append("\n")
              .append("-> Last name = ").append(lastName).append("\n")
              .append("-> E-mail = ").append(email).append("\n")
              .append("-> Car model = ").append(car.getModel()).append("\n")
              .append("-> Car series = ").append(car.getSeries()).append("\n");
      return String.valueOf(userToString);
   }
}
