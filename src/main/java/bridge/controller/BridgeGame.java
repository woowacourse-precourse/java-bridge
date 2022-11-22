package bridge.controller;

import bridge.service.BridgeGenerateService;
import bridge.domain.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int bridgeSize;
    private static int position;
    private static boolean onMovableCompartment = true;
    private static List<String> bridge;

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGenerateService bridgeGenerateService;

    public BridgeGame(OutputView outputView,
                      InputView inputView,
                      BridgeGenerateService bridgeGenerateService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeGenerateService = bridgeGenerateService;
    }

    private List<String> generateBridge() {
        outputView.printBridgeSizeInputNotice();
        bridgeSize = inputView.readBridgeSize();
        return bridgeGenerateService.generateBridgeBySize(bridgeSize);
    }

    private void move() {
        outputView.printMovingInputNotice();
        String moving = inputView.readMoving();
        onMovableCompartment = bridge.get(position++).equals(moving);
        outputView.printMap(position, moving, onMovableCompartment);
    }

    private String askGameCommand() {
        outputView.printGameCommandInputNotice();
        return inputView.readGameCommand();
    }

    private boolean retry(String gameCommand) {
        return gameCommand.equals(GameCommand.RESTART.getCommand());
    }
}
