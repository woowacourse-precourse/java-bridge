package bridge.step;

import bridge.view.output.OutputView;

public class WelcomeStep implements Step {

    private final OutputView outputView;

    public WelcomeStep(OutputView outputView) {
        this.outputView = outputView;
    }


    @Override
    public void doStep() {
        outputView.printWelcomeMessage();
    }
    
}
