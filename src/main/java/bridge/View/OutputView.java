package bridge.View;

import bridge.Model.BridgeGame;
import bridge.Model.User;

import java.util.List;

import static bridge.View.Constants.OutputConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printNextLine(){
        System.out.println();
    }
    public void printGameStart() {
        System.out.println(GAME_START);
        printNextLine();
    }

    public void printEnterLengthOfBridge() {
        System.out.println(ENTER_LENGTH_OF_BRIDGE);
    }

    public void printEnterMove() {
        System.out.println(ENTER_MOVE);
    }

    public void printEnterRetryOrNot() {
        System.out.println(ENTER_RETRY_OR_NOT);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        String output = START_OF_BRIDGE + " " + String.join(BETWEEN_BRIDGES, map) + " " + END_OF_BRIDGE;
        System.out.println(output);
    }

    public void printTotalMap(List<String> UpperMap, List<String> LowerMap){
        printMap(UpperMap);
        printMap(LowerMap);
        printNextLine();
    }

    private String getSuccessOrNot(boolean success) {
        String successOrNot = SUCCESS_OR_NOT;
        if (success) {
            return successOrNot + SUCCESS;
        }
        return successOrNot + FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        User user = bridgeGame.getUser();
        System.out.println(GAME_RESULT);
        printMap(user.getPathOfUpperBridge());
        printMap(user.getPathOfLowerBridge());
        printNextLine();
        System.out.println(getSuccessOrNot(bridgeGame.getSuccess()));
        System.out.println(TOTAL_OF_ATTEMPT + bridgeGame.getAttempt());
    }
}
