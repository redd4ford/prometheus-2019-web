package com.prometheus.dbdisplay.domain;

import javax.persistence.*;

//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля
// (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову
// таблицю та/або нове поле!

// анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько
// підняв при запуску.
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним
  // новим об'єктом)
  private int taskId;
  @Column
  private String taskText;
  @Column
  private Boolean status;
  @Column
  private String comment;
  @ManyToOne
  @JoinColumn(name="programId")
  private Program program;

  // чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз
  public Task() {
  }

  // конструктор нового об'єкта
  public Task(String taskText, Boolean status, String comment) {
    this.taskText = taskText;
    this.status = status;
    this.comment = comment;
  }

  // методи присвоєння і доступу до даних

  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }

  public int getTaskId() {
    return taskId;
  }

  public void setTaskText(String taskText) {
    this.taskText = taskText;
  }

  public String getTaskText() {
    return taskText;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public boolean getStatus() { return status; }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }

}

