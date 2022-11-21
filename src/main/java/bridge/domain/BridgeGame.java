package bridge.domain;

import bridge.BridgeMaker;
import bridge.data.BridgeResultData;
import bridge.data.MovingData;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RIGHT_RESULT = "O";
    private static final String WRONG_RESULT = "X";
    private static final String NOTHING_RESULT = " ";

    private final Bridge bridge;

    public BridgeGame(int size){
        this.bridge = new Bridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Moving moving) {
        MovingData.add(moving);
        BridgeResultData.add(
                getBridgeResult(moving, BridgeMaker.getUpBridgeCharacter()),
                getBridgeResult(moving, BridgeMaker.getDownBridgeCharacter())
        );
    }

    /**
     * '입력 받은 칸'과 '건널 수 있는 칸' 비교 결과 값 얻는 메서드
     */
    private String getBridgeResult(Moving moving, String bridgePos){
        String movingValue = moving.getValue();
        if (isRightResult(movingValue) && movingValue.equals(bridgePos)){
            return RIGHT_RESULT;
        }
        if (!isRightResult(movingValue) && movingValue.equals(bridgePos)){
            return WRONG_RESULT;
        }

        return NOTHING_RESULT;
    }

    public boolean isRightResult(String movingValue){
        String bridgeValue = this.bridge.getBridgeValue(MovingData.getRecentMovingIndex());
        return movingValue.equals(bridgeValue);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        MovingData.reset();
        BridgeResultData.reset();
    }

    /**
     * 비교한 값이 일치할 경우
     * 마지막 이동할 칸일지 아닐지 판단 하는 메서드
     */
    public boolean isSuccess(String movingValue) {
        return isRightResult(movingValue) && isLastMoving();
    }

    private boolean isLastMoving(){
        return bridge.getBridgeSize() == MovingData.getMovingDataSize();
    }
}