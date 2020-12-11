package dao;

import models.Departments;

import java.util.List;

public interface DepartmentsDao {

//Create
void add(Departments department);

//Read
List<Departments> getAllDepartments();

}
