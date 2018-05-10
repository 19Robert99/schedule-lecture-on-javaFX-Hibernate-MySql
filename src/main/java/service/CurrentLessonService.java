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

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //close session with a transaction
        closeTransactionSession();
        for (CurrentLesson obj : CurrentLessonList){

            System.out.println("2: "+obj.getDiscipline().getLecturer().getFio());
            System.out.println("2: "+obj.getDiscipline().getDisciplineName());
            System.out.println("2: "+obj.getClassRoom().getClassRoomNum());
            System.out.println("2: "+obj.getLesson().getDayOfTheWeek());
            System.out.println("2: "+obj.getLesson().getLessonNum());
            System.out.println("2: "+obj.getLesson().getStart());
            System.out.println("2: "+obj.getLesson().getEnd());
            System.out.println("2: "+obj.getStudGroup().getDirection().getFaculty().getFacultyName());
            System.out.println("2: "+obj.getStudGroup().getDirection().getDirectionName());
            System.out.println("2: "+obj.getStudGroup().getCourse());
            System.out.println("2: "+obj.getStudGroup().getGroupNum());
        }

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
        System.out.println("2//////: "+currentLesson.getClassRoom().toString());
            System.out.println("2: "+currentLesson.getDiscipline().getLecturer().getFio());
            System.out.println("2: "+currentLesson.getDiscipline().getDisciplineName());
            System.out.println("2: "+currentLesson.getClassRoom().getClassRoomNum());
            System.out.println("2: "+currentLesson.getLesson().getDayOfTheWeek());
            System.out.println("2: "+currentLesson.getLesson().getLessonNum());
            System.out.println("2: "+currentLesson.getLesson().getStart());
            System.out.println("2: "+currentLesson.getLesson().getEnd());
            System.out.println("2: "+currentLesson.getStudGroup().getDirection().getFaculty().getFacultyName());
            System.out.println("2: "+currentLesson.getStudGroup().getDirection().getDirectionName());
            System.out.println("2: "+currentLesson.getStudGroup().getCourse());
            System.out.println("2: "+currentLesson.getStudGroup().getGroupNum());


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
