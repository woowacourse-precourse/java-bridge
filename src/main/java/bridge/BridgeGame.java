package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bridge.PrintMessage.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static String upBridge = "";
    private static String downBridge = "";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String inputSpace, int index, String space) {
        List<String> bridges = new ArrayList<>(Arrays.asList(upBridge, downBridge, ""));
        if (inputSpace.equals(BridgeSpace.get(1))) {
            upBridge = setBridge(upBridge, isPassed(inputSpace, space), isFirstChoose(index));
            downBridge = setNotSelectedBridge(downBridge, isFirstChoose(index));
        }
        if (inputSpace.equals(BridgeSpace.get(0))) {
            upBridge = setNotSelectedBridge(upBridge, isFirstChoose(index));
            downBridge = setBridge(downBridge, isPassed(inputSpace, space), isFirstChoose(index));
        }
        return setBridges(bridges, isPassed(inputSpace, space));
    }

    public Boolean isFirstChoose(int index) {
        return index == 0;
    }

    public Boolean isPassed(String space, String bridgeSpace) {
        return space.equals(bridgeSpace);
    }

    public List<String> setBridges(List<String> bridges, boolean isPassed) {
        bridges.set(0, upBridge);
        bridges.set(1, downBridge);

        if (isPassed) {
            bridges.set(2, PASS);
            return bridges;
        }
        bridges.set(2, FAIL);
        return bridges;
    }

    public String setBridge(String gameBridge, boolean isPassed, boolean isFirstChoose) {
        if (isPassed) {
            if (isFirstChoose) return isPassedAndFirstChoose(gameBridge);
            return isPassedAndNotFirstChoose(gameBridge);
        }

        if (isFirstChoose) return isNotPassedAndFirstChoose(gameBridge);
        return isNotPassedAndNotFirstChoose(gameBridge);
    }

    public String setNotSelectedBridge(String gameBridge, boolean isFirstChoose) {
        if (isFirstChoose) {
            return isNotSelectedAndFirstChoose(gameBridge);
        }
        return isNotSelectedAndNotFirstChoose(gameBridge);
    }

    public String isPassedAndFirstChoose(String gameBridge) {
        return gameBridge + (LEFT_BRACKET + PASS + RIGHT_BRACKET);
    }

    public String isPassedAndNotFirstChoose(String gameBridge) {
        return gameBridge.substring(0, gameBridge.length() - 1) + (MIDDLE_LINE + PASS + RIGHT_BRACKET);
    }

    public String isNotPassedAndFirstChoose(String gameBridge) {
        return gameBridge + (LEFT_BRACKET + FAIL + RIGHT_BRACKET);
    }

    public String isNotPassedAndNotFirstChoose(String gameBridge) {
        return gameBridge.substring(0, gameBridge.length() - 1) + (MIDDLE_LINE + FAIL + RIGHT_BRACKET);
    }

    public String isNotSelectedAndFirstChoose(String gameBridge) {
        return gameBridge + (LEFT_BRACKET + BLANK + RIGHT_BRACKET);
    }

    public String isNotSelectedAndNotFirstChoose(String gameBridge) {
        return gameBridge.substring(0, gameBridge.length() - 1) + (MIDDLE_LINE + BLANK + RIGHT_BRACKET);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
