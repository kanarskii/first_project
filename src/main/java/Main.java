import ui.UI;
import ui.UI_impl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI_impl();

        ui.runner();
        ui.close();
    }
}
