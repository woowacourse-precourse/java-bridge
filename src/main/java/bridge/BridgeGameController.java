package bridge;

import bridge.domain.ActionAfterGameStatus;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.FootrestLocation;
import bridge.domain.GameResultCode;
import bridge.utils.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static BridgeGameController instance;
    private BridgeGame game;
    private final BridgeMaker bridgeMaker; // static 클래스로 만들고 싶지만, 건들었다가 무슨 일이 생길지 모르겠음

    private BridgeGameController() {
        this.game = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public static BridgeGameController init() {
        if (instance == null) {
            instance = new BridgeGameController();
        }
        return instance;
    }

    public void run() {
        InputView.showStartGameMessage();
        Bridge bridge = this.makeBridge();
        game.saveBridge(bridge);

        play();
        OutputView.printResult(game.getResult());
    }

    private void play() {
        GameResultCode movingResult = moveUserUntilEnd();
        if (movingResult == GameResultCode.FAIL) { // 게임에 실패한 경우
            determineWhatToDo();
        }
    }

    private void replay() {
        game.retry();
        play();
    }

    private void determineWhatToDo() {
        try {
            ActionAfterGameStatus code = ActionAfterGameStatus.findByUserInput(InputView.readGameCommand());
            if (code == ActionAfterGameStatus.RESTART) {
                replay();
            }
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            determineWhatToDo();
        }
    }

    // 열 한줄인데, 더 이상 못 줄이겠습니다 ㅠㅠ
    private GameResultCode moveUserUntilEnd() {
        try {
            GameResultCode gameResult = moveUser();
            if (gameResult == GameResultCode.MOVE_SUCCESS) {
                return moveUserUntilEnd();
            }
            return gameResult;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return moveUserUntilEnd();
        }
    }

    private GameResultCode moveUser() {
        String command = InputView.readMoving();
        FootrestLocation footrestLocation = FootrestLocation.findByUserInput(command);
        GameResultCode gameResult = game.move(footrestLocation);

        OutputView.printMap(game.getFootPrint());
        return gameResult;
    }

    private Bridge makeBridge() {
        try {
            Integer bridgeSize = InputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return makeBridge();
        }
    }
}
