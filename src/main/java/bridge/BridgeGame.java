package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;

    public BridgeGame(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int position) {
        String actual = bridge.get(position);
        if (validateMove(actual)) {
            if (moving.equals(actual)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException(Error.U_OR_D.toString());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retry) {
        if (retry.equals(Input.RETRY.toString())) {
            return true;
        }
        if (retry.equals(Input.QUIT.toString())) {
            return false;
        }
        throw new IllegalArgumentException(Error.R_OR_Q.toString());
    }

    private boolean validateMove(String target) {
        return target.equals(Input.UP.toString()) || target.equals(Input.DOWN.toString());
    }

    public int getSize() {
        return bridge.size();
    }

    public String getValue(int position) {
        return bridge.get(position);
    }
}
