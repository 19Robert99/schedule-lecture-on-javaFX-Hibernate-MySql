package service;

import businesslogic.SessionUtil;
import dao.KafedraDao;
import entity.Kafedra;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class KafedraService extends SessionUtil implements KafedraDao {
    public void add(Kafedra kafedra) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Kafedra> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Kafedra";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Kafedra.class);
        List<Kafedra> kafedraList= query.list();

        //close session with a transaction
        closeTransactionSession();

        return kafedraList;
    }

    public Kafedra getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Kafedra WHERE idKafedra = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Kafedra.class);
        query.setParameter("id", id);

        Kafedra kafedra = (Kafedra) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return kafedra;
    }

    public void update(Kafedra kafedra) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Kafedra kafedra) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }
}
