package service;

import model.impl.Model;

import java.util.List;

public interface Service {

    List<Model> loadModels();

    List<Model> searchModel(String str);
}
