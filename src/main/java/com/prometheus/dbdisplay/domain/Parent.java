package com.prometheus.dbdisplay.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля
// (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову
// таблицю та/або нове поле!

// анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько
// підняв при запуску.
@Entity
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним
  // новим об'єктом)
  private Integer parentId;
  // userAccess = 2;
  // хз чи потрібно воно нам тепер, якщо ми відмовилися від таблиці Users, тобто Doctor тепер
  // не наслідує від Users, бо його просто не існує. але якщо що, то залежно від параметра
  // user_access, який наслідувався від Users, мав відрізнятися рівень доступу до функціоналу сайту.
  @Column
  private String password;
  @Column
  private String username;
  @Column
  private String country;
  @Column
  private String city;
  @Column
  private String email;
  @Column
  private String phoneNumber;
  @Column
  private int userAccess;
  @ManyToMany(mappedBy = "parents")
  private Set<Kid> kids = new HashSet<Kid>();

  // чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз
  public Parent() {
  }

  public Parent(String username, String password, String country, String city, String email,
                String phoneNumber) {
    this.username = username;
    this.password = password;
    this.country = country;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // методи присвоєння і доступу до даних

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountry() {
    return country;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getUserAccess() {
    return userAccess;
  }

  public void setUserAccess(int userAccess) {
    this.userAccess = userAccess;
  }

}
