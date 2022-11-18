package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    /**
     * 사용자가 입력한 다리 길이의 타입을 확인하는 함수
     * <p>
     * 성공 시 Integer로 바뀐 다리 길이를 반환
     */
    public int checkBridgeType(String readBridgeSize) {
        int changeBridgeSize;

        try {
             changeBridgeSize = Integer.parseInt(readBridgeSize);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        return changeBridgeSize;
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
}
