package bridge.business;

import bridge.business.enumeration.BridgeLength;
import bridge.business.enumeration.MovingKey;
import bridge.business.enumeration.RetryKey;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int MIN_LENGTH_SIZE = BridgeLength.MIN.getValue();
    private final int MAX_LENGTH_SIZE = BridgeLength.MAX.getValue();
    private final Set<String> MOVING_KEY = new HashSet<>(Set.of(MovingKey.UP.getKey(), MovingKey.DOWN.getKey()));
    private final Map<String, Boolean> RETRY_KEY = new HashMap<>(
            Map.of(RetryKey.RETRY.getKey(), RetryKey.RETRY.getValue(),
                    RetryKey.NONE.getKey(), RetryKey.NONE.getValue()));

    private List<String> bridge;


    public void setBridge(List<String> bridge){
        this.bridge = bridge;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int validateBridgeSize(String bridgeSize) {
        try {
            return validateBridgeSize(Integer.parseInt(bridgeSize));
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자 아닌 값이 입력되었습니다.");
        }
    }

    public int validateBridgeSize(int bridgeSize) {
        if(bridgeSize < MIN_LENGTH_SIZE || bridgeSize > MAX_LENGTH_SIZE){
            throw new IllegalArgumentException("다리 길이가 허용 범위를 벗어났습니다.");
        }
        return bridgeSize;
    }

    public String validateMovingKey(String movingKey) {
        if(movingKey == null){
            throw new IllegalArgumentException("올바르지 못한 이동 키 입니다.");
        }
        if(!MOVING_KEY.contains(movingKey)){
            throw new IllegalArgumentException("올바르지 못한 이동 키 입니다.");
        }
        return movingKey;
    }

    public String validateRetryKey(String retryKey) {
        if(retryKey == null){
            throw new IllegalArgumentException("올바르지 못한 재시도 키 입니다.");
        }
        if(!RETRY_KEY.containsKey(retryKey)){
            throw new IllegalArgumentException("올바르지 못한 재시도 키 입니다.");
        }
        return retryKey;
    }
}
