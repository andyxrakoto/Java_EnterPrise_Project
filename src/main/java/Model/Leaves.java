package Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Leave {
        private int id;
        private int employeeId;
        private Date startDate;
        private Date endDate;
        private String leaveReason;
        private String leaveStatus;
}
