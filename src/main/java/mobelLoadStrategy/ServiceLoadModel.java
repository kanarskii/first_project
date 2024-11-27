package mobelLoadStrategy;

import mobelLoadStrategy.impl.FileStrategy;
import mobelLoadStrategy.impl.RandomStrategy;
import mobelLoadStrategy.impl.UserStrategy;
import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

import java.util.ArrayList;
import java.util.List;

public class ServiceLoadModel {

    public List<Model> loadModel (StrategyType strategy, ModelType type){
        LoadStrategy load = null;
        switch (strategy) {
            case FILE -> load = new FileStrategy();
            case USER -> load = new UserStrategy();
            case RANDOM -> load = new RandomStrategy();
        }

        List<String> list = load.load(type);


        if (list.isEmpty()) return null;
        return create(type, list);
    }

    private List<Model> create (ModelType model, List<String> list) {

        List<Model> models = new ArrayList<>();
        switch (model) {
            case BUS -> {
                for (String line:list)
                { String[] split =line.split(";");
                    models.add(
                            Bus.builder()
                                    .number(split[0])
                                    .model(split[1])
                                    .mileage(Integer.parseInt(split[2]))
                                    .build()
                    );
                }
            }
            case STUDENT -> {
                for (String line:list)
                { String[] split =line.split(";");
                    models.add(
                            Student.builder()
                                    .group(split[0])
                                    .gpa(Double.parseDouble(split[1]))
                                    .number(Integer.parseInt(split[2]))
                                    .build()
                    );
                }
            }
            case USER -> {
                for (String line:list)
                { String[] split =line.split(";");
                    models.add(
                            User.builder()
                                    .name(split[0])
                                    .pass(split[1])
                                    .email(split[2])
                                    .build()
                    );
                }
            }
        }
        return models;
    }
}
