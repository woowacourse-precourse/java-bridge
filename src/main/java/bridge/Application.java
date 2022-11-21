package bridge;

import bridge.mediator.ConcreteMediator;
import bridge.view.ErrorView;

public class Application {

    public static void main(String[] args) {
        try {
            ConcreteMediator concreteMediator = new ConcreteMediator();
            concreteMediator.start();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
        }
    }
}
