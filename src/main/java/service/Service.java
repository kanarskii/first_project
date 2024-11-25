package service;

import mobelLoadStrategy.StrategyType;
import model.Model;

import java.util.List;

public interface Service {

    List<Model> loadModels(StrategyType strategy);

    List<Model> searchModel(String str);
}
