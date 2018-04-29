package service;

import businesslogic.SessionUtil;
import dao.ClassRoomDao;
import entity.ClassRoom;
import entity.CurrentLesson;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ClassRoomService extends SessionUtil implements ClassRoomDao {

    public void add(ClassRoom classRoom) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<ClassRoom> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ClassRoom";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);
        List<ClassRoom> classRoomList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return classRoomList;
    }

    public ClassRoom getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ClassRoom WHERE ClassRoomNum = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ClassRoom.class);
        query.setParameter("id", id);

        ClassRoom classRoom = (ClassRoom) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return classRoom;
    }

    public void update(ClassRoom classRoom) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(ClassRoom classRoom) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }
}
