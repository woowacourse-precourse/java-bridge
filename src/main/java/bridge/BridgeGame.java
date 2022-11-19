package bridge;

import java.util.stream.DoubleStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {

    private int tryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        int randomNumber = BridgeNumberGenerator();
        // U == 1, D == 0일 때 성공
        if ((moving.equals("U") && randomNumber == 1) || (moving.equals("D") && randomNumber == 0)) {
            System.out.println("성공");
            return true;
        }
        System.out.println("실패");
        return false;
    }

    public String bridgeMove(boolean isMove, String bridgeMove) {
        if (isMove) {
            return bridgeMoveSuccess(bridgeMove);
        }
        return bridgeMoveFail(bridgeMove);
    }

    public String bridgeMoveSuccess(String bridgeMove) {
        if (bridgeMove.equals("U")) {
            return "[ O ]";
        }
        return "[ O ]";
    }

    public String bridgeMoveFail(String bridgeMove) {
        if (bridgeMove.equals("U")) {
            return "[ X ]";
        }
        return "[ X ]";
    }

    public int BridgeNumberGenerator() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeRandomNumberGenerator.generate();
        return randomNumber;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}
