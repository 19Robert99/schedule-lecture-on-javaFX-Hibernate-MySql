package dao;

import entity.CurrentLesson;

import java.sql.SQLException;
import java.util.List;

public interface CurrentLessonDao {
    //create
    void add(CurrentLesson currentLesson) throws SQLException;

    //read
    List<CurrentLesson> getAll() throws SQLException;

    CurrentLesson getById(Long id) throws SQLException;

    //update
    void update(CurrentLesson currentLesson) throws SQLException;

    //delete
    void remove(CurrentLesson currentLesson) throws SQLException;
}
