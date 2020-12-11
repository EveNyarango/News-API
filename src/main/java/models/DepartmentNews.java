package models;

import java.util.Objects;

public class DepartmentNews {
    private int id;
    private String departmentName;
    private String title;
    private String news;
    private String author;

    public DepartmentNews(String departmentName, String title, String news, String author) {
        this.departmentName = departmentName;
        this.title = title;
        this.news = news;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentNews)) return false;
        DepartmentNews that = (DepartmentNews) o;
        return getId() == that.getId() &&
                Objects.equals(getDepartmentName(), that.getDepartmentName()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getNews(), that.getNews()) &&
                Objects.equals(getAuthor(), that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartmentName(), getTitle(), getNews(), getAuthor());
    }
}

