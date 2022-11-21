package bridge.serviceImpl;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.message.SystemMessage;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.service.GameService;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.MovingValidation;
import bridge.validation.RestartQuickValidation;

import java.util.List;

public class BridgeGame implements GameService {
    private static final String RETRY = "R";

    private static InputView inputView;
    private static OutputView outputView;
    private static int gameTry;
    private static int count;

    public BridgeGame() {
        inputView = buildInputView();
        outputView = new OutputView();
        gameTry = 1;
        count = 0;
    }

    @Override
    public void startGame() {
        introMessage();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        doGame(bridge);

        boolean isSuccess = (count == bridgeSize);
        outputView.printResult(isSuccess, gameTry);
    }

    private void introMessage() {
        println(SystemMessage.START.getMessage() + System.lineSeparator());
        println(SystemMessage.BRIDGE_SIZE.getMessage());
    }

    private void doGame(List<String> bridge) {
        int bridgeSize = bridge.size();

        while (count < bridgeSize) {
            println(SystemMessage.MOVING_DIRECTION.getMessage());
            String inputMove = inputView.readMoving();

            boolean moving = move(inputMove, bridge);
            count++;

            if (!isRestart(moving)) {
                break;
            }
        }
    }

    private boolean isRestart(boolean moving) {
        if (!moving) {
            println(SystemMessage.RESTART_OR_QUICK.getMessage());
            String restartOrQuick = inputView.readGameCommand();
            if (!retry(restartOrQuick)) {
                return false;
            }
            count = 0;
            gameTry++;
        }
        return true;
    }

    public boolean move(String inputMove, List<String> bridge) {
        outputView.printMap(count, inputMove, bridge);
        return bridge.get(count).equals(inputMove);
    }

    public boolean retry(String restartOrQuick) {
        return restartOrQuick.equals(RETRY);
    }

    private static void println(String message) {
        System.out.print(message + System.lineSeparator());
    }

    private static InputView buildInputView() {
        InputView inputView = new InputView();
        inputView.builder()
                .setBridgeValidation(new BridgeSizeValidation())
                .setMovingValidation(new MovingValidation())
                .setRestartQuickValidation(new RestartQuickValidation())
                .build();
        return inputView;
    }
}
