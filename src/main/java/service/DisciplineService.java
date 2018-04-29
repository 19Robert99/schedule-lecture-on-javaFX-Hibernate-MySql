package service;

import businesslogic.SessionUtil;
import dao.DisciplineDao;
import entity.Discipline;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class DisciplineService extends SessionUtil implements DisciplineDao {
    public void add(Discipline discipline) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(discipline);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Discipline> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Discipline";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Discipline.class);
        List<Discipline> disciplineList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return disciplineList;
    }

    public Discipline getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Discipline WHERE idDiscipline = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Discipline.class);
        query.setParameter("id", id);

        Discipline discipline = (Discipline) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return discipline;
    }

    public void update(Discipline discipline) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(discipline);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Discipline discipline) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(discipline);

        //close session with a transaction
        closeTransactionSession();
    }
}
