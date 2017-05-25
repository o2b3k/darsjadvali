package kg.ksucta.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kg.ksucta.domain.Message;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by o2b3k on 4/22/17.
 */
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "time")
    private String time;

    @Column(name = "name")
    private String name;

    @Column(name = "room")
    private String room;

    @Column(name = "day")
    private String day;

    @Column(name = "active")
    private Integer active;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "comment")
    @JsonBackReference
    private Set<Message> comment;

    public Subject(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Set<Message> getComment() {
        return comment;
    }

    public void setComment(Set<Message> comment) {
        this.comment = comment;
    }
}
