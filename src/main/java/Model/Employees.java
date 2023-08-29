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
        private int Id;
        private String LastName;
        private String FirstName;
        private Date DateOfBirth;
        private String Address;
        private String PhoneNumber;
        private String EmailAddress;
        private Date HireDate;
        private String JobTitle;
        private Float Salary;
        private int DepartmentId;

}
