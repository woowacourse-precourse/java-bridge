package bridge.domain;

import bridge.view.InputView;

public class JudgeDestination {
    private InputView inputView = new InputView();
    private final String QUIT="Q";
    private final Boolean GAME_OVER=false;
    private final Boolean RESTART=true;
    public boolean judgeRestartOrOver() {
        String destination = inputView.readGameCommand();
        if(destination.equals(QUIT)){
            return GAME_OVER;
        }
        return RESTART;
    }


}
