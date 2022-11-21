package bridge;

import bridge.domain.*;
import bridge.viewer.InputView;
import bridge.viewer.OutputView;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        PositionTable userTable = PositionTable.newInstance();
        Bridge bridge = makeBridge();
        Result result = Result.KEEP;
        int tryNumber = 1;
        while (result.isKeep()) {
            result = moveToEnd(userTable, bridge);
            String gameCommand;
            if (result.isLose()) {
                gameCommand = readGameCommand();
                if (gameCommand.equals("Q")) {
                    showResult(userTable, result, tryNumber);
                }
            }
            if (result.isWin()) {
                showResult(userTable, result, tryNumber);
            }
            tryNumber += 1;
        }
    }

    private static void showResult(PositionTable userTable, Result result, int tryNumber) {
        System.out.println(OutputView.RESULT_MESSAGE);
        OutputView.printResult(userTable, result);
        System.out.println(OutputView.TRY_MESSAGE + tryNumber);
    }

    private static Bridge makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = Bridge.of(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        return bridge;
    }

    private static Result moveToEnd(PositionTable userTable, Bridge bridge) {
        Result gameResult;
        for (int i = 0; i< bridge.size(); i++) {
            userTable.add(Position.of(readMovingCommand()));
            gameResult = bridge.play(userTable);
            OutputView.printMap(userTable, gameResult);
            if (gameResult.isEnd()) {
                return gameResult;
            }
        }
        return Result.KEEP;
    }
    private static String readGameCommand() {
        System.out.println(InputView.GAME_COMMAND_MESSAGE);
        return InputView.readGameCommand();
    }
    private static String readMovingCommand() {
        System.out.println(InputView.MOVING_MESSAGE);
        return InputView.readMoving();
    }
}
