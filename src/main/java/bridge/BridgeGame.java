package bridge;

import java.util.List;

// 다리 건너기 게임을 관리하는 클래스
public class BridgeGame {
    static List<String> bridge;
    static int position;
    static boolean dead = false;

    public void makeGame(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        position = -1;
    }

    public void move(String userDirection) {
        String correctDirection = bridge.get(position + 1);
        position++;
        if(!userDirection.equals(correctDirection)) dead = true;
    }

    public void retry(String gameCommand) {
        if(gameCommand.equals("Q"))
        {
            dead = false;
            position = -1;
        }
    }

    public boolean isDead() {
        return dead;
    }
}
