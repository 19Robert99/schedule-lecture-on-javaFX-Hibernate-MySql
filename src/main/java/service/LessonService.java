package service;

import businesslogic.SessionUtil;
import dao.LessonDao;
import entity.Lesson;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class LessonService extends SessionUtil implements LessonDao {
    public void add(Lesson lesson) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(lesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Lesson> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lesson";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lesson.class);
        List<Lesson> lessonList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return lessonList;
    }

    public Lesson getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lesson WHERE idLesson = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lesson.class);
        query.setParameter("id", id);

        Lesson lesson = (Lesson) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return lesson;
    }

    public void update(Lesson lesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(lesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Lesson lesson) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(lesson);

        //close session with a transaction
        closeTransactionSession();
    }
}
