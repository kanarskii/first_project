package service;

import mobelLoadStrategy.LoadStrategy;
import mobelLoadStrategy.StrategyType;
import mobelLoadStrategy.impl.FileStrategy;
import mobelLoadStrategy.impl.UserStrategy;
import model.Model;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private final List<Model> modelList = new ArrayList<>();

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
    public List<Model> searchModel(String str) {
        return List.of();
    }
}
