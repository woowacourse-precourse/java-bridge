package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;
import static bridge.controller.InputController.getGameCommand;
import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.die;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.model.GameCommand;
import bridge.model.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private static boolean success;
    private static GameCommand command;
    private Diagram diagram;
    private int attempts;
    private BridgeGame bridgeGame;

    public GameController() {
        this.attempts = 0;
        this.success = false;
        this.command = GameCommand.RETRY;
    }

    public void play() {

        // 브릿지 생성
        outputView.printStartGame();
        Bridge bridge = createBridge();

        initialize(bridge);
        attempt(bridge);
        outputView.printResult(diagram, success, attempts);
    }

    private void attempt(Bridge bridge) {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            Status status = bridgeGame.move(index);
            if (bridge.survivedToTheLast(index)) {
                success = true;
            }
            if (!die(status)) {
                continue;
            }
            if (die(status)) {
                GameCommand gameCommand = getGameCommand();
                if (selectedRetry(gameCommand)) {
                    initialize(bridge);
                    attempt(bridge);
                }
                if (!selectedRetry(gameCommand)) {
                    command = GameCommand.QUIT;
                }
            }
            if (success || command == GameCommand.QUIT) {
                break;
            }
        }
    }

    private void initialize(Bridge bridge) {
        // 다이어그램 초기화, index 초기화, 시도 횟수 증가
        attempts++;
        diagram = new Diagram();
        bridgeGame = new BridgeGame(bridge, diagram);
    }

    private static Bridge createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));
        return bridge;
    }

}
