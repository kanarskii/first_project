package ui;

import model.Model;

import java.util.List;

public interface UI {

    boolean load();

    List<Model> search(String str);

    void closed();
}
