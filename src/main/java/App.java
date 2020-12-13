import com.google.gson.Gson;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUsersDao;
import models.DepartmentNews;
import models.Departments;
import models.GeneralNews;
import models.Users;
import org.sql2o.Sql2o;
import static spark.Spark.*;

import org.sql2o.Connection;

public class App {

    public static void main (String[] args) {
        Sql2oDepartmentsDao     DepartmentsDao;
        Sql2oDepartmentNewsDao DepartmentNewsDao;
        Sql2oGeneralNewsDao GeneralNewsDao;
        Sql2oUsersDao UsersDao;
        Connection conn;
        Gson gson = new Gson();

//        String connectionString = "jdbc:h2:~/NewsAPI.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString =  ("jdbc:postgresql://localhost:5432/departments");

        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Nya2rango@");

DepartmentsDao = new Sql2oDepartmentsDao(sql2o);
DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
 GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
 UsersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();

//        CREATE
        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            DepartmentsDao.add(departments);
            res.status(201);
            return gson.toJson(departments);
        });

        post("/departments/:departmentId/departmentnews/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentsId"));
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            departmentNews.setDepartmentId(departmentId);
            DepartmentNewsDao.add(departmentNews);
            res.status(201);
            return gson.toJson(departmentNews);

        });

        post("/generalNews/new", "application/json", (req, res) -> {
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);
            GeneralNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });


        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            UsersDao.add(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

//        Read
        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(UsersDao.getAllUser());//send it back to be displayed
        });

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(DepartmentsDao.getAllDepartments());//send it back to be displayed
        });


    }
}
