package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.KidDAO;
import com.prometheus.dbdisplay.domain.Kid;
import com.prometheus.dbdisplay.domain.Parent;
import com.prometheus.dbdisplay.domain.Program;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class KidDAOImpl implements KidDAO {

  @Override
  public void addKid(Kid kid) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(kid);
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
  public void updateKid(int kidId, Kid kid) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(kid);
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
  public Kid getKidById(int kidId) throws SQLException {
    Session session = null;
    Kid kid = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      kid = (Kid) session.load(Kid.class, kidId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
              "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return kid;
  }

  @Override
  public Collection getAllKids() throws SQLException {
    Session session = null;
    List kids = new ArrayList<Kid>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      kids = session.createCriteria(Kid.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return kids;
  }

  @Override
  public void deleteKid(Kid kid) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(kid);
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
  public Collection getKidsByParent(Parent parent) throws SQLException {
    Session session = null;
    List kids;
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      int parentId = parent.getParentId();
      Query query = session.createQuery(
          " select kid "
          + " from Kid kid INNER JOIN kid.parents parent"
          + " where parent.parentId = :parentId "
      )

          .setInteger("parentId", parentId);
      kids = (List<Kid>) query.list();
      session.getTransaction().commit();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return kids;
  }

  @Override
  public Collection getKidsByProgram(Program program) throws SQLException {
    Session session = null;
    List kids;
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      int programId = program.getProgramId();
      Query query = session.createQuery("from Kid where programId = :programId")
                           .setInteger("programId", programId);
      kids = (List<Kid>) query.list();
      session.getTransaction().commit();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return kids;
  }

}

