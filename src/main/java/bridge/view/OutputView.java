package bridge.view;

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
        StringBuffer up = new StringBuffer(START.getElement());
        StringBuffer down = new StringBuffer(START.getElement());
        for (int i = 0; i < nowBridge.size(); i++) {
            consistentCase(nowBridge, generatedBridge, i, up, down);
            inconsistentCase(nowBridge, generatedBridge, i, up, down);
        }
        up.replace(up.length() - 1, up.length(), END.getElement()).append("\n");
        down.replace(down.length() - 1, down.length(), END.getElement()).append(("\n"));
        return up.append(down);
    }

    public static void consistentCase(List<String> nowBridge, List<String> generatedBridge, int i, StringBuffer up, StringBuffer down) {
        if (nowBridge.get(i).equals(generatedBridge.get(i))) {
            if (nowBridge.get(i).equals(UP.getElement())) {
                up.append(CORRECT.getElement());
                down.append(BLANK.getElement());
            }
            if (nowBridge.get(i).equals(DOWN.getElement())) {
                up.append(BLANK.getElement());
                down.append(CORRECT.getElement());
            }
        }
    }

    public static void inconsistentCase(List<String> nowBridge, List<String> generatedBridge, int i, StringBuffer up, StringBuffer down) {
        if (!nowBridge.get(i).equals(generatedBridge.get(i))) {
            if (nowBridge.get(i).equals(UP.getElement())) {
                up.append(INCORRECT.getElement());
                down.append(BLANK.getElement());
            }
            if (nowBridge.get(i).equals(DOWN.getElement())) {
                up.append(BLANK.getElement());
                down.append(INCORRECT.getElement());
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
