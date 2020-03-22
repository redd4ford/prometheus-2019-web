package com.prometheus.dbdisplay.DAO;

import com.prometheus.dbdisplay.domain.Doctor;
import java.sql.SQLException;
import java.util.Collection;

public interface DoctorDAO {

  void addDoctor(Doctor doctor) throws SQLException;

  void updateDoctor(int doctorId, Doctor doctor) throws SQLException;

  Doctor getDoctorById(int doctorId) throws SQLException;

  Collection getAllDoctors() throws SQLException;

  void deleteDoctor(Doctor doctor) throws SQLException;

}

