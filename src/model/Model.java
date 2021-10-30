package model;

import controller.Controller;
import view.View;

public interface Model {
    View getView();
    Controller getController();
    void setView(View view);
    void setController(Controller controller);
}
