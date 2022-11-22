package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public List<List<String>> getPlayerBridge() {
        return playerBridge;
    }

    private List<List<String>> playerBridge;

    public int getTryCount() {
        return tryCount;
    }

    private int tryCount;

    /**
     * BridgeGame 필드 초기화 생성자
     */
    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new ArrayList<>();
        playerBridge = new ArrayList<>();
        playerBridge.add(new ArrayList<>());
        playerBridge.add(new ArrayList<>());
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        int select = 0;
        if (input.equals("U")) select = 1;
        if (input.equals("D")) select = 0;
        playerBridge.get(Math.abs(1 - select)).add(" ");
        if (input.equals(bridge.get(playerBridge.get(select).size()))) {
            playerBridge.get(select).add("O");
            return;
        }
        playerBridge.get(select).add("X");
    }

    /**
     * 다리 건너기 게임이 끝나는지 체크하는 메서드
     *
     * @return 0 - 게임이 끝나지 않음
     * 1 - 게임이 성공적으로 끝남
     * 2 - 게임이 실패로 끝남
     */
    public boolean checkGameOver() {
        for (int i = 0; i < playerBridge.size(); i++) {
            if (playerBridge.get(i).get(playerBridge.get(i).size() - 1).equals("X")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return true - 재시작
     * false-  게임 종료
     */
    public boolean retry(String input) {
        if (input.equals("R")) {
            playerBridge.get(0).clear();
            playerBridge.get(1).clear();
            tryCount++;
            return true;
        }
        if (input.equals("Q")) return false;
        System.out.println("[ERROR] 입력 값은 \"R\" 또는 \"Q\"여야 합니다.");
        throw new IllegalArgumentException();
    }

    /**
     * 다리를 생성하는 메서드
     */
    public void buildBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 게임에서 승리했는지 판단하는 메서드
     *
     * @return
     */
    public boolean checkGameWin() {
        if (playerBridge.get(0).size() == bridge.size()) {
            if (!playerBridge.get(0).get(bridge.size() - 1).equals("X") && !playerBridge.get(0).get(bridge.size() - 1).equals("X")) {
                return true;
            }
        }
        return false;
    }
}
