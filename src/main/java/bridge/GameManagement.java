package bridge;

import java.sql.SQLOutput;
import java.util.List;

public class GameManagement {

    public String[][] settingBridge(List<String> bridge, int bridgeSize) {
        String[][] bridgeBoard = new String[2][bridgeSize * 2];
        for (int i = 0; i < bridgeSize; i++) {
            if (bridge.get(i).equals(Constants.UPSIDE)) {
                bridgeBoard[0][i] = Constants.UPSIDE;
                bridgeBoard[1][i] = Constants.BLANK;
            }
            if (bridge.get(i).equals(Constants.DOWNSIDE)) {
                bridgeBoard[0][i] = Constants.BLANK;
                bridgeBoard[1][i] = Constants.DOWNSIDE;
            }
        }
        System.out.println();
        return bridgeBoard;
    }

    public void userBoardInitialization(String[][] userBoard) {
        for (int i = 0; i < userBoard.length; i++) {
            for (int j = 0; j < userBoard[i].length; j++) {
                userBoard[i][j] = Constants.BLANK;
            }
        }
    }

    public void markFailure(String command, String[][] userBoard, int moveResult) {
        if (command.equals(Constants.UPSIDE)) {
            userBoard[0][moveResult] = Constants.MOVE_FAILURE;
        }
        if (command.equals(Constants.DOWNSIDE)) {
            userBoard[1][moveResult] = Constants.MOVE_FAILURE;
        }
    }

    public void markSuccess(String command, String[][] userBoard, int moveResult) {
        if (command.equals(Constants.UPSIDE)) {
            userBoard[0][moveResult] = Constants.MOVE_SUCCESS;
        }
        if (command.equals(Constants.DOWNSIDE)) {
            userBoard[1][moveResult] = Constants.MOVE_SUCCESS;
        }
    }

    public void gameProgress(String[][] bridgeBoard, int bridgeSize) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        String[][] userBoard = new String[2][bridgeSize];
        int position = 0;
        int moveResult;
        boolean retryCheckFlag;
        boolean successCheckFlag = false;
        String command;
        int totalAttemptCount = 1;

        userBoardInitialization(userBoard);

        while (position < bridgeSize) {
            command = inputView.readMoving();
            //사용자가 움직이려고 한 칸 에러
            if (command.equals(Constants.ERROR)) {
                return;
            }

            moveResult = bridgeGame.move(command, bridgeBoard, position);

            if (position == moveResult) {
                markFailure(command, userBoard, moveResult);
                outputView.printMap(userBoard, position + 1);
                //재시작 확인
                command = inputView.readGameCommand();
                if (command.equals(Constants.ERROR)) {
                    return;
                }
                retryCheckFlag = bridgeGame.retry(command);
                successCheckFlag = false;
                if (!retryCheckFlag) {
                    break;
                }
                if (retryCheckFlag) {
                    totalAttemptCount++;
                    position = 0;
                    userBoardInitialization(userBoard);
                    continue;
                }
            }

            //사용자가 움직이려고 한 칸 에러 or 재시작 입력 에러
            if (command.equals(Constants.ERROR)) {
                return;
            }

            //성공한 경우
            if (position != moveResult) {
                markSuccess(command, userBoard, position);
                position = moveResult;
                outputView.printMap(userBoard, position);
                successCheckFlag = true;
            }
        }
        //성공 결과 or 최종 실패 출력
        if (!successCheckFlag) {
            outputView.printResult(userBoard, position + 1, successCheckFlag, totalAttemptCount);
        }
        if (successCheckFlag) {
            outputView.printResult(userBoard, position, successCheckFlag, totalAttemptCount);
        }
    }
}
