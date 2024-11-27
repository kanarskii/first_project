package service;

import mobelLoadStrategy.LoadStrategy;
import mobelLoadStrategy.StrategyType;
import mobelLoadStrategy.impl.FileStrategy;
import mobelLoadStrategy.impl.RandomStrategy;
import mobelLoadStrategy.impl.UserStrategy;
import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static service.Sort.quickSort;

public class ServiceImpl implements Service {

    private final List<Model> modelList = new ArrayList<>();

    public List<Model> getModelList() {
        return modelList;
    }

    @Override
    public List<Model> loadModels(StrategyType strategy, ModelType type) {

        System.out.println(strategy + " " + type);
        LoadStrategy load = null;
        switch (strategy) {
            case FILE -> load = new FileStrategy();

            case USER -> load = new UserStrategy();

            case RANDOM -> load = new RandomStrategy();
        }


        load.load(type).forEach(System.out::println);

            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(1).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(2).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(3).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(15382).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(30).build());
        // тут должна быть валидация которая обрабатывает List<String> и возвращает List<Model>
        // валидация применяется вне зависимости от того какой стратегией мы воспользовались
        // по хорошему в валидации должен быть метод isExp возвращающий список не валидных значений

        if (!isEmpty()) {
        quickSort(modelList, 0, (modelList.size() - 1));
        }
        return modelList;
    }

    @Override
    public Model searchModel(ModelType model, String str) {
        int index;
        switch (model) {
            case BUS -> {
                Bus bus = Bus.builder().number(str).build();
                index = Search.binarySearch(modelList,bus, Comparator.comparing(Bus::getModel));
                if (index<0) break;
                return modelList.get(index);
            }
            case STUDENT -> {
                Student student = Student.builder().number(Integer.parseInt(str)).build();
                index = Search.binarySearch(modelList,student, Comparator.comparingInt(Student::getNumber));
                if (index<0) break;
                return modelList.get(index);
            }
            case USER -> {
                User user = User.builder().name(str).build();
                index = Search.binarySearch(modelList,user, Comparator.comparing(User::getName));
                if (index<0) break;
                return modelList.get(index);
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return modelList.isEmpty();
    }
}
