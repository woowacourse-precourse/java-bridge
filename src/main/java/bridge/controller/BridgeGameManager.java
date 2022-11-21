package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.domain.Position;
import bridge.domain.PositionTable;
import bridge.viewer.InputView;
import bridge.viewer.OutputView;

public class BridgeGameManager {
    public static String readGameCommand() {
        System.out.println(InputView.GAME_COMMAND_MESSAGE);
        return InputView.readGameCommand();
    }

    public static String readMovingCommand() {
        System.out.println(InputView.MOVING_MESSAGE);
        return InputView.readMoving();
    }

    public static void showResult(PositionTable userTable, GameResult gameResult, int tryNumber) {
        System.out.println(OutputView.RESULT_MESSAGE);
        OutputView.printResult(userTable, gameResult);
        System.out.println(OutputView.TRY_MESSAGE + tryNumber);
    }

    public static GameResult moveUser(PositionTable userTable, Bridge bridge) {
        userTable.add(Position.of(readMovingCommand()));
        GameResult gameResult = bridge.play(userTable);
        OutputView.printMap(userTable, gameResult);
        return gameResult;
    }
}
