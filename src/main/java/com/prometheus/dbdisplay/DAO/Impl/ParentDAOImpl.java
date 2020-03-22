package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.ParentDAO;
import com.prometheus.dbdisplay.domain.Doctor;
import com.prometheus.dbdisplay.domain.Kid;
import com.prometheus.dbdisplay.domain.Parent;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ParentDAOImpl implements ParentDAO {

  @Override
  public void addParent(Parent parent) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction = session.beginTransaction();
      session.save(parent);
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
  public void updateParent(int parentId, Parent parent) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(parent);
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
  public Parent getParentById(int parentId) throws SQLException {
    Session session = null;
    Parent parent = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      parent = (Parent) session.load(Parent.class, parentId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return parent;
  }

  @Override
  public Collection getAllParents() throws SQLException {
    Session session = null;
    List parents = new ArrayList<Parent>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      parents = session.createCriteria(Doctor.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return parents;
  }


  @Override
  public void deleteParent(Parent parent) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(parent);
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
  public Collection getParentsByKid(Kid kid) throws SQLException {
    Session session = null;
    List parents;
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      int kidId = kid.getKidId();
      Query query = session.createQuery(
                " select parent "
                   + " from Parent parent INNER JOIN parent.kids kid"
                   + " where kid.kidId = :kidId "
      )
          .setInteger("kidId", kidId);
      parents = (List<Parent>) query.list();
      session.getTransaction().commit();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return parents;
  }

}
