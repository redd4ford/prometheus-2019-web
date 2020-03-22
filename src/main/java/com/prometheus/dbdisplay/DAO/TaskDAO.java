package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Program;
import com.prometheus.dbdisplay.domain.Task;
import java.sql.SQLException;
import java.util.Collection;

public interface TaskDAO {
  void addTask(Task program) throws SQLException;

  void updateTask(int taskId, Task task) throws SQLException;

  Task getTaskById(int taskId) throws SQLException;

  Collection getAllTasks() throws SQLException;

  void deleteTask(Task task) throws SQLException;

  Collection getTasksByProgram(Program program) throws SQLException;

}