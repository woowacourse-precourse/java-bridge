package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridges;

    public boolean move(String randomInput, String move) {
        return randomInput.equals(move);
    }

    public boolean isRetry(String command) {
        return command.equals("R");
    }

    public List<String> getBridges() {
        return bridges;
    }

    public int getBridgeSize(){
        return bridges.size();
    }

    public void setBridges(List<String> bridges) {
        this.bridges = bridges;
    }
}
