package service;

import mobelLoadStrategy.StrategyType;
import model.Model;
import model.ModelType;

import java.util.List;

public interface Service {

    List<Model> loadModels(StrategyType strategy, ModelType type);

    List<Model> searchModel(String str);

    boolean isEmpty();
}
