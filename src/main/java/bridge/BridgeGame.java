package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridge;
    int position;
    boolean dead;
    int totalTry;

    public void StartGame(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        position = -1;
        totalTry = 1;
    }

    public void move(String direction) {
        String answer = bridge.get(position + 1);
        if (!direction.equals(answer)) dead = true;
        position++;
    }

    public void retry(String command) {
        if (command.equals("R")) {
            dead = false;
            position = -1;
            totalTry++;
        }
    }

    public boolean playing() {
        if (dead) return false;
        return position < bridge.size() - 1;
    }

    public boolean isDead() { return dead; }
    public String getCurStep() { return bridge.get(position); }
    public int getTotalTry() { return totalTry; }
}
