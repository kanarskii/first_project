package mobelLoadStrategy;

import model.impl.Model;
import model.ModelType;

import java.util.List;

public interface LoadStrategy {

    List<String> load(ModelType type);


}
