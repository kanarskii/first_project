package mobelLoadStrategy;

import model.impl.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface LoadStrategy {

    List<Model> load(List<Model> objects) throws IOException, ClassNotFoundException;
}
