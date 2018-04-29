package entity;

import javax.persistence.*;

@Entity
@Table(name = "ClassRoom")
public class ClassRoom {

    @Id
    @Column(name = "ClassRoomNum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classRoomNum;
    @Column(name = "Korpus", nullable = false)
    private String korpus;
    @Column(name = "PlaceCount", nullable = false)
    private long placeCount;

    //@OneToOne(mappedBy = "classRoom")
    //private CurrentLesson currentLesson;

    public ClassRoom() {
    }

    public long getClassRoomNum() {
        return classRoomNum;
    }

    public void setClassRoomNum(long classRoomNum) {
        this.classRoomNum = classRoomNum;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public long getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(long placeCount) {
        this.placeCount = placeCount;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomNum=" + classRoomNum +
                ", korpus='" + korpus + '\'' +
                ", placeCount=" + placeCount +
                '}';
    }
}
