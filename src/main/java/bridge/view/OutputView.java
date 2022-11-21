package bridge.view;

import bridge.constant.Constant;
import bridge.constant.Sign;
import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printUpBridgestate(bridgeGame.getplayerMoving(), bridgeGame.getBridgeStatus());
        printDownBridgestate(bridgeGame.getplayerMoving(), bridgeGame.getBridgeStatus());
    }

    private void printUpBridgestate(List<String> playerMoving, List<String> bridgeStatus) {
        System.out.print(Sign.LEFT_PARENTHESIS.getSign());
        for (int i = 0; i < playerMoving.size() - 1; i++) {
            printMiddleline(playerMoving.get(i), bridgeStatus.get(i), Constant.UP.getConstant());
        }
        printRightparenthesis(playerMoving.get(playerMoving.size() - 1), bridgeStatus.get(playerMoving.size() - 1), Constant.UP.getConstant());
    }

    private void printDownBridgestate(List<String> playerMoving, List<String> bridgeStatus) {
        System.out.print(Sign.LEFT_PARENTHESIS.getSign());
        for (int i = 0; i < playerMoving.size() - 1; i++) {
            printMiddleline(playerMoving.get(i), bridgeStatus.get(i), Constant.UP.getConstant());
        }
        printRightparenthesis(playerMoving.get(playerMoving.size() - 1), bridgeStatus.get(playerMoving.size() - 1), Constant.DOWN.getConstant());
    }

    private void printMiddleline(String moving, String matching, String updown) {
        if (moving.equals(updown)) {
            System.out.printf(Sign.MIDDLE_LINE_STRING.getSign(), matching);
            return;
        }
        System.out.print(Sign.MIDDLE_LINE.getSign());
    }

    private void printRightparenthesis(String moving, String matching, String updown) {
        if (moving.equals(updown)) {
            System.out.printf(Sign.RIGHT__PARENTHESIS_STRING.getSign(), matching);
            return;
        }
        System.out.println(Sign.RIGHT_PARENTHESIS.getSign());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
