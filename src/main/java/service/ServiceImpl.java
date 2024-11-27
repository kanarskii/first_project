package service;

import mobelLoadStrategy.LoadStrategy;
import mobelLoadStrategy.StrategyType;
import mobelLoadStrategy.impl.FileStrategy;
import mobelLoadStrategy.impl.RandomStrategy;
import mobelLoadStrategy.impl.UserStrategy;
import model.impl.Model;
import model.ModelType;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private final List<Model> modelList = new ArrayList<>();

    public List<Model> getModelList() {
        return modelList;
    }

    @Override
    public List<Model> loadModels(StrategyType strategy, ModelType type) {
        LoadStrategy load = null;
        switch (strategy) {
            case FILE -> load = new FileStrategy();

            case USER -> load = new UserStrategy();

            case RANDOM -> load = new RandomStrategy();
        }

        load.load(type).forEach(System.out::println);

        // тут должна быть валидация которая обрабатывает List<String> и возвращает List<Model>
        // валидация применяется вне зависимости от того какой стратегией мы воспользовались
        // по хорошему в валидации должен быть метод isExp возвращающий список не валидных значений


        // а тут сортировка

        return modelList;
    }

    @Override
    public List<Model> searchModel(String str) {

        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return modelList.isEmpty();
    }
}
