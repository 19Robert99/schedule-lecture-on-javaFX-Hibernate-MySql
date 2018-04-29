package dao;

import entity.Direction;

import java.sql.SQLException;
import java.util.List;

public interface DirectionDao {
    //create
    void add(Direction direction) throws SQLException;

    //read
    List<Direction> getAll() throws SQLException;

    Direction getById(Long id) throws SQLException;

    //update
    void update(Direction direction) throws SQLException;

    //delete
    void remove(Direction direction) throws SQLException;
}
