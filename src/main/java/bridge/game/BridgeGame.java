package bridge.game;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private Integer count;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param input 사용자가 입력한 입력값
     */
    public void move(String input) {
        checkInputLength(input);
        checkMoveInput(input);

        bridge.pass(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
    }

    private void checkInputLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("입력은 길이 1개까지 가능합니다.");
        }
    }

    private void checkMoveInput(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("이동은 U와 D만 입력할 수 있습니다.");
        }
    }
}
