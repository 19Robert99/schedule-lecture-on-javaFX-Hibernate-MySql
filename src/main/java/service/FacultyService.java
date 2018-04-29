package service;

import businesslogic.SessionUtil;
import dao.FacultyDao;
import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class FacultyService extends SessionUtil implements FacultyDao {
    public void add(Faculty faculty) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(faculty);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Faculty> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Faculty";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Faculty.class);
        List<Faculty> facultyList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return facultyList;
    }

    public Faculty getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Faculty WHERE idFaculty = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Faculty.class);
        query.setParameter("id", id);

        Faculty faculty = (Faculty) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return faculty;
    }

    public void update(Faculty faculty) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(faculty);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Faculty faculty) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(faculty);

        //close session with a transaction
        closeTransactionSession();
    }
}
