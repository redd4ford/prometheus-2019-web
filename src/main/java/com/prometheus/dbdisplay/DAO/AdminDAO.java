package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Admin;
import java.sql.SQLException;
import java.util.Collection;

public interface AdminDAO {
  void addAdmin(Admin admin) throws SQLException;

  void updateAdmin(int adminId, Admin admin) throws SQLException;

  Admin getAdminById(int adminId) throws SQLException;

  Collection getAllAdmins() throws SQLException;

  void deleteAdmin(Admin admin) throws SQLException;

}

