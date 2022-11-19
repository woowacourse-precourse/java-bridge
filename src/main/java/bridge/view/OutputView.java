package bridge.view;

import java.util.HashMap;
import java.util.List;

import static bridge.domain.BridgeCommand.DOWN;
import static bridge.domain.BridgeCommand.UP;
import static bridge.service.BridgeGame.isGameWin;
import static bridge.domain.BridgeMap.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static StringBuffer printMap(List<String> nowBridge, List<String> generatedBridge) {
        HashMap<String, String> bridgeScreen = initializeBridgeScreen();
        return buildBridgeMap(nowBridge, generatedBridge, bridgeScreen);
    }

    public static HashMap<String, String> initializeBridgeScreen() {
        HashMap<String, String> bridgeScreen = new HashMap<>();
        bridgeScreen.put(UP.getElement(), START.getElement());
        bridgeScreen.put(DOWN.getElement(), START.getElement());
        return bridgeScreen;
    }

    private static StringBuffer buildBridgeMap(List<String> nowBridge, List<String> generatedBridge, HashMap<String, String> bridgeScreen) {
        for (int i = 0; i < nowBridge.size(); i++) {
            consistentCase(nowBridge.get(i), generatedBridge.get(i), bridgeScreen);
            inconsistentCase(nowBridge.get(i), generatedBridge.get(i), bridgeScreen);
        }
        StringBuffer up = new StringBuffer(bridgeScreen.get(UP.getElement()));
        StringBuffer down = new StringBuffer(bridgeScreen.get(DOWN.getElement()));
        up.replace(up.length() - 1, up.length(), END.getElement()).append("\n");
        down.replace(down.length() - 1, down.length(), END.getElement()).append(("\n"));
        return up.append(down);
    }

    public static void consistentCase(String nowBridge, String generatedBridge, HashMap<String, String> bridgeScreen) {
        if (nowBridge.equals(generatedBridge)) {
            if (nowBridge.equals(UP.getElement())) {
                bridgeScreen.replace(UP.getElement(), bridgeScreen.get(UP.getElement()) + CORRECT.getElement());
                bridgeScreen.replace(DOWN.getElement(), bridgeScreen.get(DOWN.getElement()) + BLANK.getElement());
            }
            if (nowBridge.equals(DOWN.getElement())) {
                bridgeScreen.replace(UP.getElement(), bridgeScreen.get(UP.getElement()) + BLANK.getElement());
                bridgeScreen.replace(DOWN.getElement(), bridgeScreen.get(DOWN.getElement()) + CORRECT.getElement());
            }
        }
    }

    public static void inconsistentCase(String nowBridge, String generatedBridge, HashMap<String, String> bridgeScreen) {
        if (!nowBridge.equals(generatedBridge)) {
            if (nowBridge.equals(UP.getElement())) {
                bridgeScreen.replace(UP.getElement(), bridgeScreen.get(UP.getElement()) + INCORRECT.getElement());
                bridgeScreen.replace(DOWN.getElement(), bridgeScreen.get(DOWN.getElement()) + BLANK.getElement());
            }
            if (nowBridge.equals(DOWN.getElement())) {
                bridgeScreen.replace(UP.getElement(), bridgeScreen.get(UP.getElement()) + BLANK.getElement());
                bridgeScreen.replace(DOWN.getElement(), bridgeScreen.get(DOWN.getElement()) + INCORRECT.getElement());
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int count, List<String> nowBridge, List<String> generatedBridge) {
        System.out.println("최종 게임 결과");
        System.out.println(printMap(nowBridge, generatedBridge));
        System.out.println("게임 성공 여부: " + isGameWin(nowBridge, generatedBridge));
        System.out.println("총 시도한 횟수: " + count);
    }
}
