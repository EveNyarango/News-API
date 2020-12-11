package dao;

import models.GeneralNews;

public class Sql2oGeneralNewsDao {
    public void add(GeneralNews generalNews) {
        String sql = "INSERT INTO news (title, news, author, departmentId) VALUES (:title, :news, :author, :departmentId)";
    }
}
