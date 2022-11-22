package bridge;

import bridge.enums.GameCommandResult;
import bridge.enums.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Map map = new Map();
    private BridgeSize bridgeSize;
    private List<String> bridge;
    private BridgeGame bridgeGame;
    private int attempt = 1;
    private String result = "성공";

    public void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public void enterBridgeSize() {
        try {
            bridgeSize = new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterBridgeSize();
        }
    }

    public void makeBridge() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
    }

    public void playGame() {
        for (int count = 0; count < bridgeSize.getBridgeSize(); count++) {
            enterMoving();
            bridgeGame = new BridgeGame(bridge);
            String check = bridgeGame.move(Moving.getMoving(), count);
            makeMap(check);
            showMap();
            if (isMismatch(check)) {
                reGame();
                break;
            }
        }
    }

    public void enterMoving() {
        try {
            Moving.validateInput(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterMoving();
        }
    }

    public void makeMap(String check) {
        map.makeMap(Moving.getMoving(), check);
    }

    public void showMap() {
        outputView.printMap(map.getUpMap(), map.getDownMap());
    }

    public boolean isMismatch(String check) {
        return check.equals(bridgeGame.MISMATCH);
    }

    public void enterGameCommand() {
        try {
            GameCommand.validateInput(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterGameCommand();
        }
    }

    public void reGame() {
        enterGameCommand();
        attempt += bridgeGame.retry(GameCommand.getGameCommand());
        if (GameCommand.getGameCommand().equals(GameCommandResult.QUIT.getGameCommand())) {
            result = GameCommandResult.QUIT.getResult();
        }
        if (GameCommand.getGameCommand().equals(GameCommandResult.RETRY.getGameCommand())) {
            map.resetMap();
            playGame();
        }
    }

    public void showResult() {
        outputView.printResult(map.getUpMap(), map.getDownMap());
        outputView.printSuccessOrFail(result);
        outputView.printAttempt(attempt);
    }

}
