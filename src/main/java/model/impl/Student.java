package model.impl;

import model.Model;

public class Student implements Model {
    private final String group;
    private final Double gpa;
    private final Integer number;

    public Student(String group, Double gpa, Integer number) {
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

    public static StudentBuilder builder (){
        return new StudentBuilder();
    }

    public static class StudentBuilder{
        private String group;
        private Double gpa;
        private Integer number;

        public StudentBuilder group(String group){
            this.group=group;
            return this;
        }
        public StudentBuilder gpa (Double gpa){
            this.gpa=gpa;
            return this;
        }
        public StudentBuilder number (Integer number){
            this.number=number;
            return this;
        }

        public Student build(){
            return new Student(group, gpa, number);
        }
    }
}
