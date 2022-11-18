package bridge.view;

import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public interface ViewContainer {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
}
