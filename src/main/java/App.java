import com.google.gson.Gson;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUsersDao;
import org.sql2o.Sql2o;

import java.sql.Connection;

public class App {

    public static void main (String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oUsersDao usersDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/NewsAPI.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Nya2rango@");



    }
}
