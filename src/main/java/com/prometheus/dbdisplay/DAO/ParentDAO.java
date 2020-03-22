package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Kid;
import com.prometheus.dbdisplay.domain.Parent;
import java.sql.SQLException;
import java.util.Collection;

public interface ParentDAO {

  void addParent(Parent parent) throws SQLException;

  void updateParent(int parentId, Parent parent) throws SQLException;

  Parent getParentById(int parentId) throws SQLException;

  Collection getAllParents() throws SQLException;

  void deleteParent(Parent parent) throws SQLException;

  Collection getParentsByKid(Kid kid) throws SQLException;

}

