package com.yevgen.model;

import com.yevgen.util.Constants;
import com.yevgen.util.annotations.Login;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
//    @NotEmpty
    @Login
    @Size(min = Constants.MIN_LOGIN_LENGTH, max = 50)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login")
    private String login;

//    @NotEmpty
    @Size(min = Constants.MIN_PASSWORD_LENGTH, max = 50)
    @Column(name = "password")
    private String password;

//    @NotEmpty
    @Size(min = Constants.MIN_FIRST_NAME_LENGTH, max = 50)
    @Column(name = "fio")
    private String fio;

    @Column(name = "enabled")
    private Boolean enabled = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRoles> userRoles = new HashSet<UserRoles>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Contact> userContacts = new HashSet<Contact>(0);

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Contact> getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(Set<Contact> userContacts) {
        this.userContacts = userContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!fio.equals(user.fio)) return false;
        if (!enabled.equals(user.enabled)) return false;
        if (!userRoles.equals(user.userRoles)) return false;
        return userContacts.equals(user.userContacts);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + fio.hashCode();
        result = 31 * result + enabled.hashCode();
        result = 31 * result + userRoles.hashCode();
        result = 31 * result + userContacts.hashCode();
        return result;
    }
}
