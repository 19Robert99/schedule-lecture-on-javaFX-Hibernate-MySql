package service;

import businesslogic.SessionUtil;
import dao.DirectionDao;
import entity.Direction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class DirectionService extends SessionUtil implements DirectionDao {
    public void add(Direction direction) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(direction);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Direction> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Direction";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Direction.class);
        List<Direction> directionList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return directionList;
    }

    public Direction getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Direction WHERE idDirection = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Direction.class);
        query.setParameter("id", id);

        Direction direction = (Direction) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return direction;
    }

    public void update(Direction direction) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(direction);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Direction direction) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(direction);

        //close session with a transaction
        closeTransactionSession();
    }
}
