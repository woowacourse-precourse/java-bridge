package bridge.game;

import bridge.etc.GameState;

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
     * @return GameState 현재 게임 상태 반환
     */
    public GameState move(String input) {
        checkInputLength(input);
        checkMoveInput(input);

        return bridge.pass(input);
    }

    /**
     * 게임 시도 횟수를 반환하는 메소드
     *
     * @return 게임 시도 횟수
     */
    public Integer getTryCount() {
        return this.count;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @param input 사용자가 입력한 입력값
     * @return GameState 현재 게임 상태 반환
     */
    public GameState retry(String input) {
        checkInputLength(input);
        checkRetryInput(input);

        if (input.equals("Q")) {
            return GameState.EXIT;
        }

        return GameState.CONTINUE;
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

    private void checkRetryInput(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("재시작은 R와 Q만 입력할 수 있습니다.");
        }
    }
}
