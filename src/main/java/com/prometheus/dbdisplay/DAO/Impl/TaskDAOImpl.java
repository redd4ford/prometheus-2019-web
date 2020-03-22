package com.prometheus.dbdisplay.DAO.Impl;

import com.prometheus.dbdisplay.DAO.TaskDAO;
import com.prometheus.dbdisplay.domain.Program;
import com.prometheus.dbdisplay.domain.Task;
import com.prometheus.dbdisplay.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TaskDAOImpl implements TaskDAO {
  @Override
  public void addTask(Task task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(task);
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
  public void updateTask(int taskId, Task task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(task);
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
  public Task getTaskById(int taskId) throws SQLException {
    Session session = null;
    Task task = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      task = (Task) session.load(Task.class, taskId);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'findById'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return task;
  }

  @Override
  public Collection getAllTasks() throws SQLException {
    Session session = null;
    List tasks = new ArrayList<Task>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      tasks = session.createCriteria(Task.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(),
            "Error 'getAll'", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return tasks;
  }

  @Override
  public void deleteTask(Task task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(task);
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
  public Collection getTasksByProgram(Program program) throws SQLException {
    Session session = null;
    List tasks;
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      int programId = program.getProgramId();
      Query query = session.createQuery(
              "from Task where programId = :programId").setInteger("programId", programId);
      tasks = (List<Task>) query.list();
      session.getTransaction().commit();
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return tasks;
  }

}


