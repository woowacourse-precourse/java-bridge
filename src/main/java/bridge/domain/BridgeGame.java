package bridge.domain;

import bridge.type.RetryType;
import bridge.utils.PositionUtils;
import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCount = 1;
    private final Bridge bridge;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void start(Player player, String position) {
        player.selectPosition(position);
    }

    /**
     * @param player 사용자
     * @return 건널 수 있다면 true / 건널 수 없다면 false
     * <p>
     * 사용자가 다리를 이동하고 이동 결과를 boolean type 으로 반환 한다.
     */
    public boolean move(Player player, int start) {
        return PositionUtils.compareTo(player, bridge, start);
    }

    /**
     * @param isPass 다리를 건넌 결과
     * @return RetryType
     * <p>
     * 다리를 건넌 결과로 RetryType 을 반환한다.
     */
    public RetryType retry(boolean isPass, InputView inputView) {
        RetryType retryType = PositionUtils.toRetryType(isPass, inputView);

        if (RetryType.RETRY.equals(retryType)) {
            gameCount += 1;
        }

        return retryType;
    }

    public int totalGameCount() {
        return this.gameCount;
    }
}
