package bridge.business;

import java.util.Set;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int MIN_LENGTH_SIZE;
    private final int MAX_LENGTH_SIZE;
    private final Set<String> MOVING_KEY;
    private final Set<String> RETRY_KEY;

    public BridgeGame(int minLengthSize, int maxLengthSize, Set<String> movingKey, Set<String> retryKey) {
        this.MIN_LENGTH_SIZE = minLengthSize;
        this.MAX_LENGTH_SIZE = maxLengthSize;
        this.MOVING_KEY = movingKey;
        this.RETRY_KEY = retryKey;
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
        if(!MOVING_KEY.contains(movingKey)){
            throw new IllegalArgumentException("올바르지 못한 이동 키 입니다.");
        }
        return movingKey;
    }

    public String validateRetryKey(String retryKey) {
        if(!RETRY_KEY.contains(retryKey)){
            throw new IllegalArgumentException("올바르지 못한 재시도 키 입니다.");
        }
        return retryKey;
    }
}
