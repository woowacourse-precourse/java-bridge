package bridge;

import static bridge.Constant.*;

import bridge.BridgeGame.MoveResult;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = startGame();
        int flag = 1;
        int count = 0;
        MoveResult gameResult = new MoveResult(0, null);
        while (flag == 1) {
            count++;
            gameResult = playGame(bridgeGame);
            if (gameResult.flag == MOVERESULT_FLAG_INVALID) {
                System.out.println(MESSAGE_RESTART);
                InputView inputView = new InputView();
                flag = bridgeGame.retry(inputView.readGameCommand());
            }
        }
        OutputView outputView = new OutputView();
        outputView.printResult(count, gameResult);
    }

    public static BridgeGame startGame() {
        System.out.println(MESSAGE_GAME_START);
        System.out.println(MESSAGE_ENTER_LENGTH);
        InputView inputView = new InputView();

        int length = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(length);
        return new BridgeGame(bridge);
    }

    public static MoveResult playGame(BridgeGame bridgeGame) {
        int moveFlag = MOVERESULT_FLAG_VALID;
        MoveResult moveResult = new MoveResult(0, null);
        while(moveFlag == MOVERESULT_FLAG_VALID) {
            System.out.println(MESSAGE_MOVE);
            InputView inputView = new InputView();
            String move = inputView.readMoving();
            System.out.println(move);
            moveResult = bridgeGame.move(move);

            OutputView outputView = new OutputView();
            outputView.printMap(moveResult);
            moveFlag = moveResult.flag;
        }
        return moveResult;
    }
}
