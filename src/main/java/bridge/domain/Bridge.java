package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 정보와 관련 메서드
 */
public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridgeInfo) {
        this.bridge = bridgeInfo;
    }

    /**
     * 유저 이동 정보와 다리 정보를 비교한다.
     *
     * @param userMovement 유저 이동 정보
     * @return 비교 정보를 반환한다.
     */
    public List<Boolean> compareWithUserMovement(List<String> userMovement) {
        List<Boolean> compareResult = new ArrayList<>();
        for (int i = 0; i < userMovement.size(); i++) {
            compareResult.add(userMovement.get(i).equals(bridge.get(i)));
        }
        return compareResult;
    }

    /**
     * 유저가 다리의 마지막에 위치했는가
     *
     * @param userMovement 유저 이동 정보
     * @return true/false
     */
    public Boolean whetherAtTheEndOfBridge(List<String> userMovement) {
        return userMovement.size() == bridge.size();
    }

    /**
     * 유저가 존재하는 칸으로 이동했는가
     *
     * @param userMovement
     * @return true/false
     */
    public Boolean whetherMoveToExitingCell(List<String> userMovement) {
        List<Boolean> compareResult = compareWithUserMovement(userMovement);
        return compareResult.get(compareResult.size() - 1);
    }
}
