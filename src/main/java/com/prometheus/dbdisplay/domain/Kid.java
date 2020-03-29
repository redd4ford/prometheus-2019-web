package com.prometheus.dbdisplay.domain;

import java.text.ParseException;
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
public class Kid {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним
  // новим об'єктом)
  private Integer kidId;
  @Column
  private String name;
  @Column
  private String gender;
  @Column
  private String diagnose;
  @Column
  private String country;
  @Column
  private String city;
  @Column
  private String dateOfBirth;
  @Column
  private Integer weight;
  @Column
  private Integer height;
  @Column
  private String bloodType;
  @ManyToOne
  @JoinColumn(name="programId")
  private Program program;
  @ManyToMany
  @JoinTable(
          name = "kidParent",
          joinColumns = { @JoinColumn(name = "kidId") },
          inverseJoinColumns = { @JoinColumn(name = "parentId") }
  )
  private Set<Parent> parents = new HashSet<Parent>();

  // чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз
  public Kid() {

  }

  // створення об'єкта
  public Kid(String name, String gender, String diagnose, String country, String city,
             String dateOfBirth, Integer weight, Integer height, String bloodType)
        throws ParseException {
    this.name = name;
    this.gender = gender;
    this.diagnose = diagnose;
    this.country = country;
    this.city = city;
    this.dateOfBirth = dateOfBirth;
    this.weight = weight;
    this.height = height;
    this.bloodType = bloodType;
  }

  // методи присвоєння і доступу до даних

  public void setKidId(Integer id) {
    this.kidId = id;
  }

  public Integer getKidId() {
    return kidId;
  }

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

  public void setDiagnose(String diagnose) {
    this.diagnose = diagnose;
  }

  public String getDiagnose() {
    return diagnose;
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

  public void setDateOfBirth(String dateOfBirth)  {
    this.dateOfBirth = dateOfBirth;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getHeight() {
    return height;
  }

  public void setBloodType(String bloodType) {
    this.bloodType = bloodType;
  }

  public String getBloodType() {
    return bloodType;
  }



}
