package service;

import model.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static service.Sorting.natural;
import static service.Sorting.quick;

import static service.Search.binarySearch;
/**
 * Сервис класс сортировки, поиска
 * @version 1.0
 */
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
    /**
     * Метод быстрой сортировки
     * @see Sorting#quick(List, int, int, Comparator)
     */
    public void quickSorting(Comparator  comparator) {
        quick(models, 0, (models.size() - 1), comparator);
        sorted = true;
    }
    /**
     * Метод дополнительной сортировки
     * классы с четными значениями будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах
     * @see Sorting#natural(List, Comparator)
     */
    public <T> void naturalSorting(Comparator comparator) {
        natural(models, comparator);
        sorted = false;
    }
    /**
     * Метод бинарного поиска
     * работает исключительно после быстрой сортировки
     * @see Search#binarySearch(List, Object, Comparator)
     */
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
