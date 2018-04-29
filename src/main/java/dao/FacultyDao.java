package dao;

import entity.Faculty;

import java.sql.SQLException;
import java.util.List;

public interface FacultyDao {
    //create
    void add(Faculty faculty) throws SQLException;

    //read
    List<Faculty> getAll() throws SQLException;

    Faculty getById(Long id) throws SQLException;

    //update
    void update(Faculty faculty) throws SQLException;

    //delete
    void remove(Faculty faculty) throws SQLException;
}
