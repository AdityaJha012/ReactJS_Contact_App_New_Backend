package com.contact.app.Models;

import java.sql.Timestamp;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @GenericGenerator(name = "user_sequence", strategy = "com.contact.app.Models.UserIdGenerator")
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String companyName;
    private String jobTitle;
    private String officeAddress;
    private String annualIncome;
    private String emailId;
    private String mobileNo;
    private String address;
    private String remarks;
    private String validFlag;
    private String createdBy;
    private Timestamp creationDate;
    private String updatedBy;
    private Timestamp updationDate;
}
