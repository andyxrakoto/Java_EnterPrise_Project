package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Department {
        private int id;
        private String departmentName;
        private String description;
}
