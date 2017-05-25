package kg.ksucta.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kg.ksucta.domain.embeddable.Dates;
import kg.ksucta.domain.model.Subject;
import kg.ksucta.domain.user.User;

import javax.persistence.*;

/**
 * Created by o2b3k on 5/23/17.
 */
@Entity
@Table(name = "message")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @Embedded
    private Dates dates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    @JsonManagedReference
    private Subject comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public User getMessage() {
        return message;
    }

    public void setMessage(User message) {
        this.message = message;
    }

    public Subject getComment() {
        return comment;
    }

    public void setComment(Subject comment) {
        this.comment = comment;
    }
}
