package blog.com.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Data
@ToString(exclude = {"id", "password"}, includeFieldNames = true)
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
private Long woo;
    @Column(name = "password")
    private String password;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "update_by_email")
    private boolean updateByEmail;

}
