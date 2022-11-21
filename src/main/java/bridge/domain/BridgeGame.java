package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private Player player;
    private int trial;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        setPlayer(player);
        this.trial = 1;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction, int round) {
        String answer = bridge.get(round);
        player.move(direction, answer);
        return direction.equals(answer);
    }

    public int getTotalRounds() {
        return bridge.size();
    }

    public int getTrial() {
        return trial;
    }

    public List<String> getMap() {
        return player.generateMap();
    }

    public boolean hasSucceeded() {
        return player.hasSucceeded(bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        validateCommand(command);
        if (command.equals("R")) {
            trial += 1;
            return true;
        }
        return false;
    }

    private void validateCommand(String command) {
        if (!List.of("R", "Q").contains(command)) {
            throw new IllegalArgumentException("[ERROR] R(재시작) 또는 Q(종료)만 입력할 수 있습니다.");
        }
    }
}
