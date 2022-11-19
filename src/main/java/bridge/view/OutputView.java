package bridge.view;

import bridge.BridgeGame;
import bridge.Moving;

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
        List<String> bridge = bridgeGame.getBridge();
        List<String> userThinkBridge = bridgeGame.getUserThinkBridge();
        printUpMap(bridge, userThinkBridge);
        printDownMap(bridge, userThinkBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeGame);
        System.out.println();
        System.out.println(GAME_SUCCESS_OR_FAIL);
        System.out.println(GAME_TRY);
    }

    private void printUpMap(List<String> bridge, List<String> userThinkBridge){
        System.out.print(START_BRIDGE);
        System.out.print(userThinkBridge.get(0));
        for (int i = 1; i < userThinkBridge.size(); i++) {
            if (bridge.get(i).equals(Moving.UP.getDirection())){
                System.out.print(DIVISION_BRIDGE + userThinkBridge.get(i));
                continue;
            }
            System.out.print(BLANK_BRIDGE);
        }
        System.out.println(END_BRIDGE);
    }

    private void printDownMap(List<String> bridge, List<String> userThinkBridge){
        System.out.print(START_BRIDGE);
        System.out.print(userThinkBridge.get(0));
        for (int i = 1; i < userThinkBridge.size(); i++) {
            if (bridge.get(i).equals(Moving.DOWN.getDirection())){
                System.out.print(DIVISION_BRIDGE + userThinkBridge.get(i));
                continue;
            }
            System.out.print(BLANK_BRIDGE);
        }
        System.out.println(END_BRIDGE);
    }
}
