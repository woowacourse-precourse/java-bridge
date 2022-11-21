package bridge;

import java.util.List;

public class GameManagement {
    private static final String UPSIDE_MESSAGE = "U";
    private static final String DOWNSIDE_MESSAGE = "D";
    private static final String BLANK_MESSAGE = " ";
    private static final String MOVE_SUCCESS_MESSAGE = "O";
    private static final String MOVE_FAILURE_MESSAGE = "X";
    private static final String ERROR_MESSAGE = "ERROR";

    public String[][] settingBridge(List<String> bridge, int bridgeSize) {
        String[][] bridgeBoard = new String[2][bridgeSize * 2];
        for (int i = 0; i < bridgeSize; i++) {
            if (bridge.get(i).equals(UPSIDE_MESSAGE)) {
                bridgeBoard[0][i] = UPSIDE_MESSAGE;
                bridgeBoard[1][i] = BLANK_MESSAGE;
            }
            if (bridge.get(i).equals(DOWNSIDE_MESSAGE)) {
                bridgeBoard[0][i] = BLANK_MESSAGE;
                bridgeBoard[1][i] = DOWNSIDE_MESSAGE;
            }
        }
        System.out.println();

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < bridgeSize; j++) {
//                System.out.print(bridgeBoard[i][j] + " ");
//            }
//            System.out.println();
//        }
        return bridgeBoard;
    }

    public void userBoardInitialization(String[][] userBoard) {
        for (int i = 0; i < userBoard.length; i++) {
            for (int j = 0; j < userBoard[i].length; j++) {
                userBoard[i][j] = BLANK_MESSAGE;
            }
        }
    }

    public void gameProgress(String[][] bridgeBoard, int bridgeSize) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        String[][] userBoard = new String[2][bridgeSize];
        int position = 0;
        int moveResult = 0;
        boolean flag = false;
        boolean success = false;
        String command;
        int totalAttemptCount = 1;

        userBoardInitialization(userBoard);

        while (position < bridgeSize) {

            command = inputView.readMoving();
            //사용자가 움직이려고 한 칸 에러
            if (command.equals(ERROR_MESSAGE)) {
                return;
            }
            moveResult = bridgeGame.move(command, bridgeBoard, position);
            if (position == moveResult) {
                //실패 결과 출력
                if (command.equals(UPSIDE_MESSAGE)) {
                    userBoard[0][moveResult] = MOVE_FAILURE_MESSAGE;
                }
                if (command.equals(DOWNSIDE_MESSAGE)) {
                    userBoard[1][moveResult] = MOVE_FAILURE_MESSAGE;
                }
                outputView.printMap(userBoard, position + 1);
                //재시작 확인
                command = inputView.readGameCommand();
                if (command.equals(ERROR_MESSAGE)) {
                    return;
                }
                flag = bridgeGame.retry(command);
                success = false;
                //재시작할 경우
                if (flag) {
                    totalAttemptCount++;
                    position = 0;
                    moveResult = 0;
                    flag = false;
                    userBoardInitialization(userBoard);
                    continue;
                }
                if (!flag) {
                    break;
                }
            }

            //사용자가 움직이려고 한 칸 에러 or 재시작 입력 에러
            if (command.equals(ERROR_MESSAGE)) {
                return;
            }

            //성공 케이스
            if (position != moveResult) {
                if (command.equals(UPSIDE_MESSAGE)) {
                    userBoard[0][position] = MOVE_SUCCESS_MESSAGE;
                }
                if (command.equals(DOWNSIDE_MESSAGE)) {
                    userBoard[1][position] = MOVE_SUCCESS_MESSAGE;
                }
                position = moveResult;

                outputView.printMap(userBoard, position);
                success = true;
            }
        }
        //성공 결과 or 최종 실패 출력
        if (!success) {
            outputView.printResult(userBoard, position + 1, success, totalAttemptCount);
        }
        if (success) {
            outputView.printResult(userBoard, position, success, totalAttemptCount);
        }
    }
}
