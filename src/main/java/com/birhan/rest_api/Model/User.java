package com.birhan.rest_api.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @Column(name ="email_addres", nullable = false)
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createAt;

    @Column(name = "create_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = false)
    @LastModifiedBy
    private String updateBy;

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    @Override
    public  String toString(){
        return "User{" + "id=" + id  + ", firstName= ' " + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email= '" + email + '\'' +
                ", updateAt' " + updateBy + '\'' +
                ",createdAt ' " + createAt + '\'' +
                ", createdBy ' " + createdBy + '\'' +
                '}';

    }

}
