package com.prometheus.dbdisplay.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля
// (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову
// таблицю та/або нове поле!

// анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько
// підняв при запуску.@Entity

public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним
  // новим об'єктом)
  private Integer doctorId;
  // userAccess = 1;
  // хз чи потрібно воно нам тепер, якщо ми відмовилися від таблиці Users, тобто Doctor тепер
  // не наслідує від Users, бо його просто не існує. але якщо що, то залежно від параметра
  // user_access, який наслідувався від Users, мав відрізнятися рівень доступу до функціоналу сайту.
  @Column
  private String name;
  @Column
  private String gender;
  @Column
  private String organization;
  @Column
  private String specialty;
  @Column
  private String country;
  @Column
  private String city;
  @Column
  private String dateOfBirth;
  @Column
  private String email;
  @Column
  private String phoneNumber;
  @Column
  private String password;
  @Column
  private int userAccess;
  @OneToMany(mappedBy = "doctor")
  private List<Program> programs = new ArrayList<Program>();

  // чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз
  public Doctor() {

  }

  // конструктор нового об'єкта
  public Doctor(String name, String password, String gender, String dateOfBirth,
                String organization, String specialty, String country, String city, String email,
                String phoneNumber) throws ParseException {
    this.name = name;
    this.gender = gender;
    this.organization = organization;
    this.specialty = specialty;
    this.country = country;
    this.city = city;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  // методи присвоєння і доступу до даних

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getOrganization() {
    return organization;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getSpecialty() {
    return specialty;
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDoctorId(Integer doctorId) {
    this.doctorId = doctorId;
  }

  public Integer getDoctorId() {
    return doctorId;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public int getUserAccess() {
    return userAccess;
  }

  public void setUserAccess(int userAccess) {
    this.userAccess = userAccess;
  }

}