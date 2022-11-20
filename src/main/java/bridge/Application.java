package bridge;


import bridge.step.Step;
import bridge.step.StepFactory;
import bridge.step.StepFactoryType;
import bridge.step.StepLauncher;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        StepLauncher stepLauncher = new StepLauncher(new ArrayList<>());
        Step init = StepFactory.makeStep(StepFactoryType.INIT);
        Step game = StepFactory.makeStep(StepFactoryType.GAME);

        stepLauncher.addStep(init);
        stepLauncher.addStep(game);

        stepLauncher.run();
    }
}
