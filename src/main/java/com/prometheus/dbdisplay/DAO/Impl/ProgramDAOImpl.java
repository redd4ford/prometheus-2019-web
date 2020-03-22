package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.ProgramDAO;
import com.prometheus.dbdisplay.domain.Doctor;
import com.prometheus.dbdisplay.domain.Program;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProgramDAOImpl implements ProgramDAO {
  @Override
  public void addProgram(Program program) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(program);
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
  public void updateProgram(int programId, Program program) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(program);
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
  public Program getProgramById(int programId) throws SQLException {
    Session session = null;
    Program program = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      program = (Program) session.load(Program.class, programId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return program;
  }

  @Override
  public Collection getAllPrograms() throws SQLException {
    Session session = null;
    List programs = new ArrayList<Program>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      programs = session.createCriteria(Program.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return programs;
  }

  @Override
  public void deleteProgram(Program program) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(program);
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

  @Override
  public Collection getProgramsByDoctor(Doctor doctor) throws SQLException {
    Session session = null;
    List programs;
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      int doctorId = doctor.getDoctorId();
      Query query = session.createQuery(
                 "from Program where doctorId = :doctorId").setInteger("doctorId", doctorId);
      programs = (List<Program>) query.list();
      session.getTransaction().commit();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return programs;
  }
}
