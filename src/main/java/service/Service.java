package service;

import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static service.Sorting.natural;
import static service.Sorting.quick;

import static service.Search.binarySearch;

public class Service {

    private  List<Model> models = new ArrayList<>();
    private boolean sorted = false;

    public boolean isSorted() {
        return sorted;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> list) {
        models = new ArrayList<>();
        for (Model model:list) {
            models.add(model);
        }
        sorted = false;
    }

    public void addModels(List<Model> list) {
        for (Model model:list) {
            models.add(model);
        }
        sorted = false;
    }

    public void quickSorting() {
        quick(models, 0, (models.size() - 1));
        sorted = true;
    }

    public void naturalSorting() {
        natural(models);
        sorted = false;
    }

    public Model searchModel(ModelType model, String str) {
        int index = -1;
        switch (model) {
            case BUS -> {
                Bus bus = Bus.builder().number(str).build();
                index = binarySearch(models,bus, Comparator.comparing(Bus::getModel));
            }
            case STUDENT -> {
                Student student = Student.builder().number(Integer.parseInt(str)).build();
                index = binarySearch(models,student, Comparator.comparingInt(Student::getNumber));
            }
            case USER -> {
                User user = User.builder().name(str).build();
                index = binarySearch(models,user, Comparator.comparing(User::getName));
            }
        }
        if (index<0) return null;
        return models.get(index);
    }

    public boolean empty(){
        return !models.isEmpty();
    }
}
