package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameRun {
    private static final String FAIL_COMMAND_RETRY = "R";
    private static final String FAIL_COMMAND_QUIT = "Q";

    private final InputView inputView;
    private final OutputView outputView;


    public BridgeGameRun(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameRun() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    private boolean isRetry() {
        String failCommand = inputView.readGameCommand();
        if (failCommand.equals(FAIL_COMMAND_RETRY)){
            return true;
        }
        return false;
    }
}
