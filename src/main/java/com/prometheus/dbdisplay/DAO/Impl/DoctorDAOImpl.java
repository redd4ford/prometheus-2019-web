package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.DoctorDAO;
import com.prometheus.dbdisplay.domain.Doctor;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;

public class DoctorDAOImpl implements DoctorDAO {
  @Override
  public void addDoctor(Doctor doctor) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(doctor);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error while inserting", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
  }

  @Override
  public void updateDoctor(int doctorId, Doctor doctor) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(doctor);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error while inserting", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
  }

  @Override
  public Doctor getDoctorById(int doctorId) throws SQLException {
    Session session = null;
    Doctor doctor = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      doctor = (Doctor) session.load(Doctor.class, doctorId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return doctor;
  }

  @Override
  public Collection getAllDoctors() throws SQLException {
    Session session = null;
    List doctors = new ArrayList<Doctor>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      doctors = session.createCriteria(Doctor.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return doctors;
  }


  @Override
  public void deleteDoctor(Doctor doctor) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(doctor);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error while deleting", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
  }

}
