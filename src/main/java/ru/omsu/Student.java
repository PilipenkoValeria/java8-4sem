package ru.omsu;

import java.util.Objects;

public class Student extends Human implements Executable {
    private String university;

    public Student(String surname, String name, String patronymic, int age, String university) {
        super(surname, name, patronymic, age);
        if (university == null || university.length() < 1) {
            throw new IllegalArgumentException("Ошибка! Получены неверные данные");
        }
        this.university = university;
    }

    public Student(Student student) {
        super(student.getSurname(), student.getName(), student.getPatronymic(), student.getAge());
        if (university == null || university.length() < 1) {
            throw new IllegalArgumentException("Ошибка! Получены неверные данные");
        }
        this.university = student.getUniversity();
    }

    @Override
    public String toString() {
        return "Student{" +
                "university='" + university + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return university.equals(student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void execute() {

    }
}