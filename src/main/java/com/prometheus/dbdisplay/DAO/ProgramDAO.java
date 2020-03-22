package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Doctor;
import com.prometheus.dbdisplay.domain.Program;
import java.sql.SQLException;
import java.util.Collection;

public interface ProgramDAO {
  void addProgram(Program program) throws SQLException;

  void updateProgram(int programId, Program program) throws SQLException;

  Program getProgramById(int programId) throws SQLException;

  Collection getAllPrograms() throws SQLException;

  void deleteProgram(Program program) throws SQLException;

  Collection getProgramsByDoctor(Doctor doctor) throws SQLException;

}
