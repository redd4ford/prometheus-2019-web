package com.prometheus.dbdisplay.model;

import com.prometheus.dbdisplay.DAO.*;
import com.prometheus.dbdisplay.DAO.Impl.*;

public class Clinic {

  private static DoctorDAO doctorDAO = null;
  private static ParentDAO parentDAO = null;
  private static KidDAO kidDAO = null;
  private static ProgramDAO programDAO = null;
  private static TaskDAO taskDAO = null;
  private static Clinic instance = null;

  synchronized public static Clinic getInstance() {
    if (instance == null) {
      instance = new Clinic();
    }

    return instance;
  }

  synchronized public DoctorDAO getDoctorDAO() {
    if (doctorDAO == null) {
      doctorDAO = new DoctorDAOImpl();
    }

    return doctorDAO;
  }

  synchronized public ParentDAO getParentDAO() {
    if (parentDAO == null) {
      parentDAO = new ParentDAOImpl();
    }

    return parentDAO;
  }

  synchronized public KidDAO getKidDAO() {
    if (kidDAO == null) {
      kidDAO = new KidDAOImpl();
    }

    return kidDAO;
  }

  synchronized public ProgramDAO getTaskDAO() {
    if (programDAO == null) {
      programDAO = new ProgramDAOImpl();
    }

    return programDAO;
  }

  synchronized public TaskDAO getProgramDAO() {
    if (taskDAO == null) {
      taskDAO = new TaskDAOImpl();
    }

    return taskDAO;
  }

}
