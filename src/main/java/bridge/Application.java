package bridge;

import bridge.domain.*;
import bridge.viewer.InputView;
import bridge.viewer.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        PositionTable userTable = PositionTable.newInstance();
        int tryNumber = 0;
        Scanner scanner = new Scanner(System.in);
        boolean retry = true;
        while (retry) {
            tryNumber += 1;
            int bridgeSize = InputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = Bridge.of(bridgeMaker.makeBridge(bridgeSize));
            Result result = move(userTable, bridgeSize, bridge);
            OutputView.printMap(userTable);
            if (result.isLose()) {
                System.out.println(InputView.GAME_COMMAND_MESSAGE);
                String gameCommand = InputView.readGameCommand();
                if (gameCommand.equals("Q")) {
                    System.out.println(OutputView.RESULT_MESSAGE);
                    OutputView.printResult(userTable,result);
                    System.out.println(OutputView.WIN_MESSAGE);
                    System.out.println(OutputView.TRY_MESSAGE + tryNumber);
                    retry = false;
                }
            }
            if (result.isWin()) {
                System.out.println(OutputView.RESULT_MESSAGE);
                OutputView.printResult(userTable,result);
                System.out.println(OutputView.WIN_MESSAGE);
                System.out.println(OutputView.TRY_MESSAGE + tryNumber);
                retry = false;
            }
        }
    }

    private static Result move(PositionTable userTable, int bridgeSize, Bridge bridge) {
        Result gameResult;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i< bridgeSize; i++) {
            System.out.println(InputView.MOVING_MESSAGE);
            String movingCommand = InputView.readMoving();
            userTable.add(Position.of(movingCommand));
            gameResult = bridge.play(userTable);
            if (gameResult.isEnd()) {
                return gameResult;
            }
        }
        return Result.KEEP;
    }
}
