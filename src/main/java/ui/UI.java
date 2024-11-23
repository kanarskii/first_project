package ui;

import model.impl.Model;

import java.util.List;

public interface UI {

    boolean load();

    List<Model> search(String str);

    void closed();
}
