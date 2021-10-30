package view;

import controller.Controller;
import model.Model;

public interface View {
    Model getModel();
    Controller getController();
    void setModel(Model model);
    void setController(Controller controller);
}
