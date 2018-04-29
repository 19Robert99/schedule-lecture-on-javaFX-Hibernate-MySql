package dao;

import entity.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonDao {
    //create
    void add(Lesson lesson) throws SQLException;

    //read
    List<Lesson> getAll() throws SQLException;

    Lesson getById(Long id) throws SQLException;

    //update
    void update(Lesson lesson) throws SQLException;

    //delete
    void remove(Lesson lesson) throws SQLException;
}
