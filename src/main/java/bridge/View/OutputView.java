package bridge.View;

import bridge.BridgeGame;
import bridge.User;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void outputInitialAnnouncement() {
        String startAnnouncement = "다리 건너기 게임을 시작합니다.";
        System.out.println(startAnnouncement);
        System.out.println();
        String enterLengthOfBridge = "다리의 길이를 입력해주세요.";
        System.out.println(enterLengthOfBridge);
    }

    public void outputChoiceMove() {
        String choiceMove = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        System.out.println(choiceMove);
    }

    public void outputRetryOrNot() {
        String retryOrNot = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        System.out.println(retryOrNot);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        String startOfBridge = "[";
        String endOfBridge = "]";
        String between = " | ";
        String output = startOfBridge + " " + String.join(between, map) + " " + endOfBridge;
        System.out.println(output);
    }

    private String checkSuccess(boolean isSuccess) {
        String success = "게임 성공 여부: ";
        if (isSuccess) {
            return success + "성공";
        }
        return success + "실패";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        User user = bridgeGame.getUser();
        String resultOfGame = "최종 게임 결과";
        System.out.println(resultOfGame);
        printMap(user.getPathOfUpperBridge());
        printMap(user.getPathOfLowerBridge());
        System.out.println();
        System.out.println(checkSuccess(bridgeGame.isSuccess()));
        String totalOfAttempt = "총 시도한 횟수: ";
        System.out.println(totalOfAttempt + bridgeGame.getAttempt());
    }
}
