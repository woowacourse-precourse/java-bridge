package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;

    public void getBridge(BridgeRandomNumberGenerator bridgeRandomNumberGenerator, int size){
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(String move) {

    }

    public void retry(String retry) {

    }
}
