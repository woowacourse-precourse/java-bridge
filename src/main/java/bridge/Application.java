package bridge;

import bridge.mediator.ConcreteControllerMediator;
import bridge.mediator.ControllerMediator;
import bridge.mediator.ViewMediator;
import bridge.view.ErrorView;

public class Application {

    public static void main(String[] args) {
        try {
            ViewMediator concreteMediator = new ConcreteControllerMediator();
            concreteMediator.start();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
        }
    }
}
