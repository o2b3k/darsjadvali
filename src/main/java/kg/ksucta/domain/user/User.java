package kg.ksucta.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kg.ksucta.domain.Message;
import kg.ksucta.domain.embeddable.Dates;
import org.hibernate.validator.constraints.Email;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "email")
    private String email;

    @Embedded
    private Dates dates;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<UserRole> roles;

    @OneToMany(mappedBy = "message")
    @JsonBackReference
    private Set<Message> messages;

    public User() { }

    public User(Long id, String username, String password, List<UserRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

}
