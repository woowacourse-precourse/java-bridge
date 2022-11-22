package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Moving;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String DIVISION_BRIDGE = " | ";
    private static final String BLANK_BRIDGE = " ";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String GAME_TRY = "총 시도한 횟수: ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printLine(bridgeGame, Moving.UP.getDirection(), Moving.DOWN.getDirection());
        printLine(bridgeGame, Moving.DOWN.getDirection(), Moving.UP.getDirection());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean quitFlag, int userTry) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeGame);
        System.out.println();
        System.out.println(GAME_SUCCESS_OR_FAIL + decisionSuccessOrFail(quitFlag));
        System.out.println(GAME_TRY + userTry);
    }

    private void printLine(BridgeGame bridgeGame, String printLine, String otherLine){
        List<String> userThinkBridge = bridgeGame.getUserThinkBridge();
        System.out.print(START_BRIDGE);

        if (userThinkBridge.size() == 1){
            printOnlyOneMap(bridgeGame, printLine, otherLine);
            return;
        }

        printMiddleMap(bridgeGame, printLine);
        printLastMap(bridgeGame, printLine);
    }

    private void printOnlyOneMap(BridgeGame bridgeGame, String printLine, String otherLine){
        String userMoving = bridgeGame.getUserMoving();
        if (userMoving.equals(printLine) && bridgeGame.getBridge().get(0).equals(userMoving)){
            System.out.println("O" + END_BRIDGE);
            return;
        }
        if (userMoving.equals(otherLine)){
            System.out.println(" " + END_BRIDGE);
            return;
        }
        System.out.println("X" + END_BRIDGE);
    }

    private void printMiddleMap(BridgeGame bridgeGame, String printLine){
        List<String> bridge = bridgeGame.getBridge();
        List<String> userThinkBridge = bridgeGame.getUserThinkBridge();
        printFirstBridgeMap(bridgeGame, printLine);
        for (int i = 1; i < userThinkBridge.size() - 1; i++) {
            if (bridge.get(i).equals(printLine)){
                System.out.print(DIVISION_BRIDGE + userThinkBridge.get(i));
                continue;
            }
            System.out.print(DIVISION_BRIDGE + BLANK_BRIDGE);
        }
    }

    private void printFirstBridgeMap(BridgeGame bridgeGame, String printLine){
        if (bridgeGame.getBridge().get(0).equals(printLine)){
            System.out.print(bridgeGame.getUserThinkBridge().get(0));
            return;
        }
        System.out.print(BLANK_BRIDGE);
    }

    private void printLastMap(BridgeGame bridgeGame, String printLine){
        String userMoving = bridgeGame.getUserMoving();
        if (printLine.equals(userMoving) && bridgeGame.compareLastBridgeAndUserThink()){
            System.out.println(DIVISION_BRIDGE + "O" + END_BRIDGE);
            return;
        }
        if (printLine.equals(userMoving) && !bridgeGame.compareLastBridgeAndUserThink()){
            System.out.println(DIVISION_BRIDGE + "X" + END_BRIDGE);
            return;
        }
        System.out.println(DIVISION_BRIDGE + " " + END_BRIDGE);
    }

    private String decisionSuccessOrFail(boolean quitFlag){
        if (quitFlag) return "실패";
        return "성공";
    }
}
