package dao;

import entity.Kafedra;

import java.sql.SQLException;
import java.util.List;

public interface KafedraDao {
    //create
    void add(Kafedra kafedra) throws SQLException;

    //read
    List<Kafedra> getAll() throws SQLException;

    Kafedra getById(Long id) throws SQLException;

    //update
    void update(Kafedra kafedra) throws SQLException;

    //delete
    void remove(Kafedra kafedra) throws SQLException;
}
