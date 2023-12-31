package Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class connection {
    private static  Connection connection;

    public connection(){
        try{
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/enterprise",
                    "postgres",
                    "andinirina"
            );
            System.out.println("Connection Authorized");
        } catch (SQLException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    @Bean
    public Connection getConnection() {
        if (connection == null) {
            new connection();
        }
        return connection;
    }
}
