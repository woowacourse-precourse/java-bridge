package bridge;

import bridge.type.RetryType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final PositionUtils positionUtils;

    public BridgeGame(PositionUtils positionUtils) {
        this.positionUtils = positionUtils;
    }

    /**
     * @param position 다리의 위치 ( 아래칸, 위칸)
     * @param player   사용자
     *                 <p>
     *                 다리의 size 만큼 사용자는 칸을 선택하여 List 에 담는다.
     */
    public void start(String position, Player player) {
        player.selectPosition(position);
    }

    /**
     * @param player 사용자
     * @param bridge 건널 수 있는 다리
     * @return 건널 수 있다면 true / 건널 수 없다면 false
     * <p>
     * 사용자가 다리를 이동하고 이동 결과를 boolean type 으로 반환 한다.
     */
    public boolean move(Player player, Bridge bridge, int start) {
        return positionUtils.compareTo(player, bridge, start);
    }

    /**
     * @param isPass 다리를 건넌 결과
     * @return RetryType
     * <p>
     * 다리를 건넌 결과로 RetryType 을 반환한다.
     */
    public RetryType retry(boolean isPass) {
        return positionUtils.toRetryType(isPass);
    }


}
