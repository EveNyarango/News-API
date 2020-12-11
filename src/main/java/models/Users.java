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

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                username.equals(users.username) &&
                userPosition.equals(users.userPosition) &&
                userRole.equals(users.userRole) &&
                departmentName.equals(users.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, userPosition, userRole, departmentName);
    }
}
