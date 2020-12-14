package dao;

import models.DepartmentNews;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao {
    private Sql2o sql2o;

    public Sql2oDepartmentNewsDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(DepartmentNews departmentNews) {
        try (Connection con = sql2o.open()){
            String sql = "INSERT INTO news (title, news, author, departmentId) VALUES (:title, :news, :author, :departmentId)";
            int id = (int) con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);

        }

    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        String sql = "SELECT * FROM news";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public DepartmentNews getDepartmentNewsById(int id) {
        String sql = "SELECT * FROM news WHERE id=:id";
        try (Connection conn = sql2o.open()){
            return   conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

}
