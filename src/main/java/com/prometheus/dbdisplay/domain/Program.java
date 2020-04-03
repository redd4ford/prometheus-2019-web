package com.prometheus.dbdisplay.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля
// (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову
// таблицю та/або нове поле!

// анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько
// підняв при запуску.
@Entity
public class Program {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним
  // новим об'єктом)
  private int programId;
  @Column
  private String programType;
  @Column
  private Integer dailyProgress;
  @Column
  private String comment;
  @ManyToOne
  @JoinColumn(name="doctorId")
  private Doctor doctor;
  @OneToMany(mappedBy = "program")
  private List<Task> tasks = new ArrayList<>();
  @OneToMany(mappedBy = "program")
  private List<Kid> kids = new ArrayList<>();

  // чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз
  public Program() {
  }

  // конструктор нового об'єкта
  public Program(String programType, Integer dailyProgress, String comment) {
    this.programType = programType;
    this.dailyProgress = dailyProgress;
    this.comment = comment;
  }

  // методи присвоєння і доступу до даних

  public void setProgramId(int programId) {
    this.programId = programId;
  }

  public int getProgramId() {
    return programId;
  }

  public void setProgramType(String programType) {
    this.programType = programType;
  }

  public String getProgramType() {
    return programType;
  }

  public void setDailyProgress(Integer dailyProgress) {
    this.dailyProgress = dailyProgress;
  }

  public Integer getDailyProgress() {
    return dailyProgress;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }

}

