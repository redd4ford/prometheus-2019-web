package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.AdminDAO;
import com.prometheus.dbdisplay.domain.Admin;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;

public class AdminDAOImpl implements AdminDAO {

  @Override
  public void addAdmin(Admin admin) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(admin);
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
  public void updateAdmin(int adminId, Admin admin) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(admin);
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
  public Admin getAdminById(int adminId) throws SQLException {
    Session session = null;
    Admin admin = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      admin = (Admin) session.load(Admin.class, adminId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return admin;
  }

  @Override
  public Collection getAllAdmins() throws SQLException {
    Session session = null;
    List admins = new ArrayList<Admin>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      admins = session.createCriteria(Admin.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return admins;
  }

  @Override
  public void deleteAdmin(Admin admin) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(admin);
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
