package service;

import businesslogic.SessionUtil;
import dao.CurrentLessonDao;
import entity.CurrentLesson;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.sql.SQLException;

public class CurrentLessonService extends SessionUtil implements CurrentLessonDao {

    public void add(CurrentLesson currentLesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(currentLesson);

        closeTransactionSession();
    }

    public List<CurrentLesson> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM (currentlessons \n" +
                "INNER JOIN studgroup ON currentlessons.idStudGroup = studgroup.idStudGroup)\n" +
                "INNER JOIN direction ON studgroup.idDirection = direction.idDirection\n" +
                "WHERE direction.idFaculty = 1\n";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);
        List<CurrentLesson> CurrentLessonList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return CurrentLessonList;
    }

    public CurrentLesson getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons WHERE idCurLes = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);
        query.setParameter("id", id);

        CurrentLesson currentLesson = (CurrentLesson) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return currentLesson;
    }

    public void update(CurrentLesson currentLesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(currentLesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(CurrentLesson currentLesson) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(currentLesson);

        //close session with a transaction
        closeTransactionSession();
    }
}
