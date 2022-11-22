package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static final String RETRY = "R";

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printStart();

        try {
            int size = getBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            game(bridge);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
        }
    }

    public void game(List<String> bridge) {
        Result result = new Result(bridge);
        BridgeGame bridgeGame = new BridgeGame(result);

        do {
            if (process(result, bridgeGame)) {   // 성공한 경우
                outputView.printResult(result, bridgeGame.getCount());
                break;
            }
            bridgeGame.retry();
        }while (isRetry(getCommand()));
    }

    private boolean process(Result result, BridgeGame bridgeGame) {
        do {
            String place = inputView.readMoving().getPlace();
            bridgeGame.move(place);
            outputView.printMap(result);
            if (result.hasFail()) {  // 입력한 칸이 이동할 수 없는 경우
                return false;
            }
        } while (!result.isSameLength()); // 정답과 입력한 이동칸의 수가 같은 경우

        return true;
    }

    private boolean isRetry(String command) {
        return command.equals(RETRY);
    }

    private String getCommand() {
        return inputView.readGameCommand().getCommand();
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize().getBridgeSize();
    }
}
