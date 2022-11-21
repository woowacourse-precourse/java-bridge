package bridge.game;

import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.config.BridgeAppConfig.*;
import static bridge.enums.IntEnum.GAME_LOSE;
import static bridge.enums.IntEnum.GAME_WIN;
import static bridge.enums.StringEnum.QUIT;

public class BridgeGameCycle {
    private static final InputView inputView = inputView();
    private static final OutputView outputView = outputView();
    private static final boolean CONTINUE = true;
    private static final boolean FINISH = false;
    private int coin = 1;
    private int bridgeLength;
    private int nowState;
    private String finalMap;


    public void play() throws IllegalArgumentException {
        beforeGame();
        brideGamePlay();
        afterGame();
    }

    private void afterGame() {
        outputView.printResult(nowState, coin, finalMap);
    }

    private void beforeGame() {
        outputView.printGameStart();
        bridgeLength = checkReadBridgeSize();
    }

    private int checkReadBridgeSize() {
        while (CONTINUE) {
            try {
                outputView.printAskLength();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int oneTurnCycle(BridgeGame bridgeGame) {
        String inputMoving = checkReadMoving();
        int nowState = bridgeGame.move(inputMoving);
        finalMap = bridgeGame.nowBridgeStage(nowState);
        outputView.printMap(finalMap);
        return nowState;
    }

    private String checkReadMoving() {
        while (CONTINUE) {
            try {
                outputView.printAskMoving();
                return inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String askInputCommand() {
        outputView.printAskCommand();
        return inputView.readGameCommand();
    }

    private boolean loseCycle(BridgeGame bridgeGame) {
        if (nowState == GAME_LOSE.num()) {
            String inputCommand = checkInputCommand();
            if (inputCommand.equals(QUIT.key())) {
                return FINISH;
            }
            coin++;
            bridgeGame.retry();
        }
        return CONTINUE;
    }

    private String checkInputCommand() {
        while (CONTINUE) {
            try {
                return askInputCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void brideGamePlay() {
        BridgeGame bridgeGame = bridgeGame(bridgeLength);
        while (CONTINUE) {
            nowState = oneTurnCycle(bridgeGame);
            if (nowState == GAME_WIN.num()) break;
            if (!loseCycle(bridgeGame)) break;
        }
    }
}
