package service;

import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static service.Sort.quickSort;
import static service.Search.binarySearch;

public class Service {

    private List<Model> models = new ArrayList<>();
    private boolean sorted = false;

    public boolean isSorted() {
        return sorted;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> list) {
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

    public void sort() {
        quickSort(models, 0, (models.size() - 1));
        sorted = true;
    }

    public Model searchModel(ModelType model, String str) {
        int index;
        switch (model) {
            case BUS -> {
                Bus bus = Bus.builder().number(str).build();
                index = binarySearch(models,bus, Comparator.comparing(Bus::getModel));
                if (index<0) break;
                return models.get(index);
            }
            case STUDENT -> {
                Student student = Student.builder().number(Integer.parseInt(str)).build();
                index = binarySearch(models,student, Comparator.comparingInt(Student::getNumber));
                if (index<0) break;
                return models.get(index);
            }
            case USER -> {
                User user = User.builder().name(str).build();
                index = binarySearch(models,user, Comparator.comparing(User::getName));
                if (index<0) break;
                return models.get(index);
            }
        }
        return null;
    }

    public boolean empty(){
        return !models.isEmpty();
    }
}
