package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class BridgeGame {

    BridgeCheck bridgeCheck = new BridgeCheck();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String move(List<String> bridgeInfo, int bridgeLength, int gameCount) {
        String checkResult;
        for (int i = 0; i < bridgeLength; i++){
            checkResult = BridgeCheck.isRightBridge(bridgeInfo, i);
            if (checkResult.contains("Q")) return checkResult;
            if (checkResult == "R") {
                i--; gameCount++;
            };
        }
        return "C";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String retry(String reGameCommendResult, int i) {
        if (reGameCommendResult.equals("Q")){
            String tmp  = "Q" + Integer.toString(i);
            return tmp;
        }

        return "R";
    }
}
