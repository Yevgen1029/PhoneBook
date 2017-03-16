package com.yevgen.model;

import com.yevgen.util.Constants;
import com.yevgen.util.annotations.Phone;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user_contacts")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long contactId;


//    @NotEmpty
    @Size(min = Constants.MIN_FIRST_NAME_LENGTH, max = 50, message = Constants.FIRST_NAME_LENGTH_ERROR)
    @Column(name = "first_name", nullable = false)
    private String firstName;


//    @NotEmpty
    @Size(min = Constants.MIN_LAST_NAME_LENGTH, max = 50, message = Constants.LAST_NAME_LENGTH_ERROR)
    @Column(name = "second_name", nullable = false)
    private String secondName;

//    @NotEmpty
    @Size(min = Constants.MIN_PATRONYMIC_LENGTH, max = 50, message = Constants.PATRONYMIC_LENGTH_ERROR)
    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @NotEmpty(message = "This field can not be empty")
    @Phone(message = Constants.PHONE_NUMBER_FORMAT_ERROR)
    @Column(name = "mobile_phone_number", nullable = false)
    private String mobilePhoneNumber;

    @Phone(message = Constants.PHONE_NUMBER_FORMAT_ERROR)
    @Column(name = "home_phone_number", nullable = true)
    private String homePhoneNumber;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "address", nullable = true)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login", nullable = false)
    private User user;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactId != contact.contactId) return false;
        if (!firstName.equals(contact.firstName)) return false;
        if (!secondName.equals(contact.secondName)) return false;
        if (!patronymic.equals(contact.patronymic)) return false;
        if (!mobilePhoneNumber.equals(contact.mobilePhoneNumber)) return false;
        if (homePhoneNumber != null ? !homePhoneNumber.equals(contact.homePhoneNumber) : contact.homePhoneNumber != null)
            return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        return address != null ? address.equals(contact.address) : contact.address == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (contactId ^ (contactId >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + mobilePhoneNumber.hashCode();
        result = 31 * result + (homePhoneNumber != null ? homePhoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
