package dao;

import entity.Lecturer;

import java.sql.SQLException;
import java.util.List;

public interface LecturerDao {
    //create
    void add(Lecturer lecturer) throws SQLException;

    //read
    List<Lecturer> getAll() throws SQLException;

    Lecturer getById(Long id) throws SQLException;

    //update
    void update(Lecturer lecturer) throws SQLException;

    //delete
    void remove(Lecturer lecturer) throws SQLException;
}
