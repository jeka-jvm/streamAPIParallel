package org.example;

import org.example.student.Student;
import org.example.student.StudentHelper;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        // Создание списка студентов
        List<Student> students = StudentHelper.createStudents();

        //Вычисление среднего балла по студентам
        Map<String, Double> averageGrades = StudentHelper.calculateAverageGrades(students);

        //Вывод среднего балла по студентам
        StudentHelper.printAverageGrades(averageGrades);
    }
}