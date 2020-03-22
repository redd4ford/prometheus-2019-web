package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Kid;
import com.prometheus.dbdisplay.domain.Parent;
import com.prometheus.dbdisplay.domain.Program;
import java.sql.SQLException;
import java.util.Collection;

public interface KidDAO {

  void addKid(Kid kid) throws SQLException;

  void updateKid(int kidId, Kid kid) throws SQLException;

  Kid getKidById(int kidId) throws SQLException;

  Collection getAllKids() throws SQLException;

  void deleteKid(Kid kid) throws SQLException;

  Collection getKidsByParent(Parent parent) throws SQLException;

  Collection getKidsByProgram(Program program) throws SQLException;


}