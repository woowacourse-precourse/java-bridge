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

    public void StartGame(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        position = -1;
        totalTry = 1;
    }

    public void move(String direction) {
        String answer = bridge.get(position + 1);
        if(!direction.equals(answer)) dead = true;
        position++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if(command.equals("R")) {
            dead = false;
            position = -1;
            totalTry++;
        }
    }

    public boolean playing(){
        if(dead) return false;
        return position < bridge.size() - 1;
    }

    public boolean isDead() {
        return dead;
    }

    public List<String> getBridge(){
        return bridge;
    }

    public int getPosition() {
        return position;
    }

    public String getCurStep() { return bridge.get(position); }

    public int getTotalTry() { return totalTry; }
}
