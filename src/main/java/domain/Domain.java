package domain;

import businesslogic.HibernateUtil;
import entity.*;
import service.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static  void main(String [] args) throws SQLException {
        ClassRoomService classRoomService = new ClassRoomService();
        CurrentLessonService currentLessonService = new CurrentLessonService();
        DirectionService directionService = new DirectionService();
        DisciplineService disciplineService = new DisciplineService();
        FacultyService facultyService = new FacultyService();
        KafedraService kafedraService = new KafedraService();
        LecturerService lecturerService = new LecturerService();
        LessonService lessonService = new LessonService();
        StudGroupService studGroupService = new StudGroupService();


        Faculty faculty = new Faculty();
        faculty.setFacultyName("КСФ");

        Kafedra kafedra = new Kafedra();
        kafedra.setKafedraName("КТК");
        kafedra.setFaculty(faculty);

        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecture(001);
        lecturer.setFio("Рублев И.С.");
        lecturer.setPosition("Старший преподаватель");
        lecturer.setKafedra(kafedra);

        Discipline discipline = new Discipline();
        discipline.setDisciplineName("ОБД");
        discipline.setLecturer(lecturer);

        Direction direction = new Direction();
        direction.setDirectionName("Компьютерные науки");
        direction.setFaculty(faculty);


        StudGroup studGroup = new StudGroup();
        studGroup.setCourse(3);
        studGroup.setGroupNum(2);
        studGroup.setStudCount(18);
        studGroup.setDirection(direction);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        Lesson lesson = new Lesson();
        lesson.setLessonNum(1);
        lesson.setLessonStart("08:30");
        lesson.setDate(new java.sql.Date(calendar.getTime().getTime()));

        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassRoomNum(201);
        classRoom.setKorpus("Лабораторный корпус");
        classRoom.setPlaceCount(65);

        CurrentLesson currentLesson = new CurrentLesson();
        currentLesson.setLesson(lesson);
        currentLesson.setClassRoom(classRoom);
        currentLesson.setDiscipline(discipline);

        Set<Kafedra> kafedras = new HashSet<Kafedra>();
        kafedras.add(kafedra);
        faculty.setKafedras(kafedras);

        Set<Direction> directions = new HashSet<Direction>();
        directions.add(direction);
        faculty.setDirection(directions);

        Set<Lecturer> lecturers = new HashSet<Lecturer>();
        lecturers.add(lecturer);
        kafedra.setLecturers(lecturers);

        Set<Discipline> disciplines = new HashSet<Discipline>();
        disciplines.add(discipline);
        lecturer.setDiscipline(disciplines);

       /* Set<CurrentLesson> currentLessons = new HashSet<CurrentLesson>();
        currentLessons.add(currentLesson);
        studGroup.setCurrentLessons(currentLessons);*/

        Set<StudGroup> studGroups = new HashSet<StudGroup>();
        studGroups.add(studGroup);
        currentLesson.setStudGroup(studGroups);




        facultyService.add(faculty);
        kafedraService.add(kafedra);
        lecturerService.add(lecturer);
        disciplineService.add(discipline);
        directionService.add(direction);
        studGroupService.add(studGroup);
        lessonService.add(lesson);
        classRoomService.add(classRoom);
        currentLessonService.add(currentLesson);

        System.out.println(currentLessonService.getAll());

        HibernateUtil.shutdown();
    }
}
