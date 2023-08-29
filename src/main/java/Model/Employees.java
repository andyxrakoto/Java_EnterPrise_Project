package Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
        private int id;
        private String lastName;
        private String firstName;
        private Date dateOfBirth;
        private String address;
        private String phoneNumber;
        private String emailAddress;
        private Date hireDate;
        private String jobTitle;
        private Float salary;
        private int departmentId;

}
