package bridge;

import bridge.mediator.ConcreteControllerMediator;
import bridge.mediator.ViewMediator;

public class Application {

    public static void main(String[] args) {
        ViewMediator concreteMediator = new ConcreteControllerMediator();
        concreteMediator.start();
    }
}
