package bridge.domain;

import bridge.util.Validate;
import bridge.view.InputView;
import bridge.view.OutputView;

public class RestartProcess {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private final String QUIT="Q";
    private final Boolean GAME_OVER=false;
    private final Boolean RESTART=true;
    Validate validate = new Validate();
    public boolean restart(int idx, int bridgeSize) {
        String destination = inputView.readGameCommand();
        if(destination.equals(QUIT)){
            return GAME_OVER;
        }
        return RESTART;
    }
}
