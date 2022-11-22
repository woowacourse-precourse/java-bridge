package bridge.domain.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private List<String> bridge = new ArrayList<>();

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        while (true){

        }

    }

    public List<String> getBridge(final int inputSize) {
        bridge = bridgeMaker.makeBridge(inputSize); // size만큼 bridgeMaker-moveCase에 랜덤 방향값 문자열 리스트로 저장한걸 가져오기
        return bridge;
    } // ex) [U,D,D] 출력

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String playerInput, final int inputSize) { //플레이어의 입력 문자
        try {
            checkValidMoving(playerInput);
            isCompareTo(getBridge(inputSize), playerInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void isCompareTo(List<String> bridge, final String playerInput) {
        List<String> playerInputDirection = new ArrayList<>();
        playerInputDirection.add(playerInput);
        validateBridge(bridge, playerInputDirection);
    }

    private void validateBridge(List<String> bridge, final List<String> playerInputDirection) {
        for (int index = 0; index < bridge.size() - 1; index++) {
            if (bridge.get(index) != playerInputDirection.get(index)) {
                playerInputDirection.clear();
                index = -1;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    //유효한 입력인지 검증
    private void checkValidMoving(final String input) {
        if (input != "U" || input != "D") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void checkValidCommand(final String input) {
        if (input != "R" || input != "Q") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
