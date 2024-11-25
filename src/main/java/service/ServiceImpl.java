package service;

import mobelLoadStrategy.LoadStrategy;
import mobelLoadStrategy.StrategyType;
import mobelLoadStrategy.impl.FileStrategy;
import mobelLoadStrategy.impl.UserStrategy;
import model.Model;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceImpl implements Service {

    private final List<Model> modelList = new ArrayList<>();
    private Comparator comparator;

    public List<Model> getModelList() {
        return modelList;
    }

    @Override
    public List<Model> loadModels(StrategyType strategy) {
        LoadStrategy load;
        switch (strategy) {
            case FILE -> {
                load =new FileStrategy();

            }
            case USER -> {
                load =new UserStrategy();

            }
        }
        return modelList;
    }

    @Override
    public Model searchModel(String str) {
        //ToDo Возможно вынести выше. И использовать этот компоратор и для сортировки
        if(!modelList.isEmpty()) {
            var tmp = modelList.get(0);
            Model obj = null;
            if (tmp instanceof Student) {
                comparator = Comparator.comparingInt(Student::getNumber);
                obj = Student.builder().number(Integer.parseInt(str)).build();
            } else if (tmp instanceof User) {
                comparator = Comparator.comparing(User::getEmail);
                obj = User.builder().email(str).build();
            } else if (tmp instanceof Bus) {
                comparator = Comparator.comparing(Bus::getNumber);
                obj = Bus.builder().number(str).build();
            }
            var resSearch = Search.binarySearch(modelList, obj, comparator);
            if (resSearch >= 0) {
                return modelList.get(resSearch);
            }
        }
        return null; //ToDo куда пойдет результат поиска
    }
}
