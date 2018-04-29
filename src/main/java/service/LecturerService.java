package service;

import businesslogic.SessionUtil;
import dao.LecturerDao;
import entity.Lecturer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class LecturerService extends SessionUtil implements LecturerDao {
    public void add(Lecturer lecturer) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Lecturer> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lecturer";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        List<Lecturer> lecturerList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return lecturerList;
    }

    public Lecturer getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lecturer WHERE idLecture = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("id", id);

        Lecturer lecturer = (Lecturer) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return lecturer;
    }

    public void update(Lecturer lecturer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Lecturer lecturer) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }
}
