package model.impl;

import model.Model;

import java.util.Objects;

/**
 * Класс студент со свойствами <b>group</b>, <b>gpa</b> и <b>number</b>.
 * @autor Виктор Дробышевский
 * @version 1.0
 */
public class Student  extends Model {
    /** Поле номер группы*/
    private final String group;
    /** Поле средний балл*/
    private final Double gpa;
    /** Поле номер зачетной книжки*/
    private final Integer number;

    /** Конструктор - создание нового объекта класса Student
     * @param group номер группы
     * @param gpa средний балл
     * @param number номер зачетной книжки
     */
    private Student(String group, Double gpa, Integer number) {
        this.group = group;
        this.gpa = gpa;
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public Double getGpa() {
        return gpa;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Студент из группы " + group + " с средним балом " + gpa + " номером зачётной книги " + number;
    }

    @Override
    public int compareTo(Model o) {
        return this.number.compareTo(((Student) o).getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group) && Objects.equals(gpa, student.gpa) && Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, gpa, number);
    }

    /**
     * Создание объекта Student по паттерну Builder
     * @see Student
     * @return StudentBuilder
     */
    public static StudentBuilder builder (){
        return new StudentBuilder();
    }

    public static class StudentBuilder{
        private String group;
        private Double gpa;
        private Integer number;

        /**
         * Задаёт группу студенту
         * @see Student
         * @param group строка
         * @return StudentBuilder
         */
        public StudentBuilder group(String group){
            this.group=group;
            return this;
        }
        /**
         * Задаёт средний балл студенту
         * @see Student
         * @param gpa число с плавабщей точкой
         * @return StudentBuilder
         */
        public StudentBuilder gpa (Double gpa){
            this.gpa=gpa;
            return this;
        }
        /**
         * Задаёт номер зачетной книжки студента
         * @see Student
         * @param number целое число
         * @return StudentBuilder
         */
        public StudentBuilder number (Integer number){
            this.number=number;
            return this;
        }
        /** Отправа на создание нового объекта класса Student
         * @see Student#Student(String, Double, Integer)
         * @return Student
         */
        public Student build(){
            return new Student(group, gpa, number);
        }
    }
}
