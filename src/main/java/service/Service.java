package service;

import model.Model;

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
            this.models.add(model);
        }
        sorted = false;
    }

    public void addModels(List<Model> list) {
        for (Model model:list) {
            models.add(model);
        }
        sorted = false;
    }

    public void quickSorting(Comparator  comparator) {
        quick(models, 0, (models.size() - 1), comparator);
        sorted = true;
    }

    public <T> void naturalSorting(Comparator comparator) {
        natural(models, comparator);
        sorted = false;
    }

    public  Model searchModel(Model model, Comparator  comparator) {
        var index = -1;
        index = binarySearch(models, model, comparator);
        if (index<0) return null;
        return models.get(index);
    }

    public boolean empty(){
        return !models.isEmpty();
    }
}
