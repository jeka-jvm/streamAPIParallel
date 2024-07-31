package org.example.student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StudentHelper {

    public static List<Student> createStudents() {
        return Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );
    }

    public static Map<String, Double> calculateAverageGrades(List<Student> students) {
        return students.parallelStream()
                       .flatMap(student -> student.getGrades()
                                                  .entrySet()
                                                  .stream())
                       .collect(Collectors.groupingBy(
                               Map.Entry::getKey,
                               Collectors.averagingInt(Map.Entry::getValue)
                       ));
    }

    public static void printAverageGrades(Map<String, Double> averageGrades) {
        System.out.println("Средние оценки по предметам:");
        averageGrades.forEach((subject, averageGrade) -> System.out.println(subject + ": " + averageGrade));
    }
}
