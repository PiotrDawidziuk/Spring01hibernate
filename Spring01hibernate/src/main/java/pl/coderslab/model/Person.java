package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "personDetails")
    private PersonDetails personDetails;

    String login;
    String password;
    String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Person() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
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

    @Override
    public String toString() {
        return ""+login+" "+password+" "+email;
    }
}
