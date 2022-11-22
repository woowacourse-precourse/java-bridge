package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> PROGRESS_COMMANDS = newArrayList(
            Progress.RETRY.toString(), Progress.QUIT.toString());

    private final List<String> bridge;
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
     */
    public boolean move(String direction, int round) {
        String answer = bridge.get(round);
        player.move(direction, answer);
        return player.isAlive();
    }

    public int getTotalRounds() {
        return bridge.size();
    }

    public int getTrial() {
        return trial;
    }

    public List<String> getMap() {
        return player.checkMap();
    }

    public boolean hasSucceeded() {
        return player.hasSucceeded(bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry(String command) {
        validateCommand(command);
        if (Progress.RETRY.toString().equals(command)) {
            trial += 1;
            return true;
        }
        return false;
    }

    private void validateCommand(String command) {
        if (!PROGRESS_COMMANDS.contains(command)) {
            String guide = "[ERROR] %s(재시작) 또는 %s(종료)만 입력할 수 있습니다.";
            throw new IllegalArgumentException(String.format(
                    guide, Progress.RETRY, Progress.QUIT));
        }
    }
}
