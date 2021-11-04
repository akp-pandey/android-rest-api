package com.example.rest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection ="User")
public class User {

    @Id
    private String id;
    @NotNull(message = "firstName cannot be null")
    private String firstName;
    @NotNull(message = "lastName cannot be null")
    private String lastName;
    @NotNull(message = "emailId cannot be null")
    private String emailId;
    @NotNull(message = "password cannot be null")
    @Size(min = 8,message = "Password should be of 8 or more than 8 character")
    private String password;
    private String confirmPassword;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public User(@NotNull(message = "firstName cannot be null") String firstName,
            @NotNull(message = "lastName cannot be null") String lastName,
            @NotNull(message = "emailId cannot be null") String emailId,
            @NotNull(message = "password cannot be null") @Size(min = 8, message = "Password should be of 8 or more than 8 character") String password,
            String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    
}
