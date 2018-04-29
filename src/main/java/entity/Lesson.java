package entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Lesson")
public class Lesson {
    @Id
    @Column(name = "idLesson")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLesson;
    @Column(name = "LessonNum", nullable = false)
    private long lessonNum;
    @Column(name = "LessonStart", nullable = false)
    private String lessonStart;
    @Column(name = "Date", nullable = false)
    private Date date;

    //@OneToOne(mappedBy = "lesson")
    //private CurrentLesson currentLesson;

    public Lesson() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(long idLesson) {
        this.idLesson = idLesson;
    }

    public long getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(long lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getLessonStart() {
        return lessonStart;
    }

    public void setLessonStart(String lessonStart) {
        this.lessonStart = lessonStart;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "idLesson=" + idLesson +
                ", lessonNum=" + lessonNum +
                ", lessonStart='" + lessonStart + '\'' +
                ", date=" + date +
                '}';
    }
}
