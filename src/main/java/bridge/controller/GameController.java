package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeTile;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    public static final String GAME_RETRY_INPUT = "R";
    public static final String GAME_QUIT_INPUT = "Q";

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    // todo: refactor
    public void startGame() {
        Player player = new Player();
        Bridge bridge = generateRandomBridge();

        do {
            boolean isSurvival = playOneTurn(bridge, player);
            // isSurvival false -> 제시도 여부 확인
            if (!isSurvival) {
                if(!askForTryAgain()){
                    break;
                }
                bridgeGame.retry(player);
            }
        } while (!bridgeGame.isWin(bridge, player));
        // 결과 출력
    }

    private Bridge generateRandomBridge() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                List<String> bridgePositions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
                Bridge bridge = Bridge.from(bridgePositions);
                return bridge;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private boolean playOneTurn(Bridge bridge, Player player) {
        BridgeTile movingTargetTile = readMovingTargetTile();
        boolean turnResult = bridgeGame.move(bridge, player, movingTargetTile);
        return turnResult;
    }

    private BridgeTile readMovingTargetTile() {
        while (true) {
            try {
                String movingPosition = inputView.readMoving();
                BridgeTile movingTile = BridgeTile.findByTilePosition(movingPosition);
                return movingTile;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private boolean askForTryAgain() {
        String input = readTryAgainInput();
        if (input.equals(GAME_RETRY_INPUT)) {
            return true;
        }
        return false;
    }

    private String readTryAgainInput(){
        String input = null;
        do {
            try {
                input = inputView.readGameCommand(GAME_RETRY_INPUT, GAME_QUIT_INPUT);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (input == null);
        return input;
    }

}
