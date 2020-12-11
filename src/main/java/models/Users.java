package models;

import java.util.Objects;

public class Users {
    private int id;
    private String username;
    private String userPosition;
    private String userRole;
    private String departmentName;

    public Users(String username, String userPosition, String userRole, String departmentName) {
        this.username = username;
        this.userPosition = userPosition;
        this.userRole = userRole;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() &&
                Objects.equals(getUsername(), users.getUsername()) &&
                Objects.equals(getUserPosition(), users.getUserPosition()) &&
                Objects.equals(getUserRole(), users.getUserRole()) &&
                Objects.equals(getDepartmentName(), users.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getUserPosition(), getUserRole(), getDepartmentName());
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
