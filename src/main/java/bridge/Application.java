package bridge;

public class Application {
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static void main(String[] args) {
        BridgeData bridgeData = new BridgeData(bridgeMaker.makeBridge(InputView.readBridgeSize()),0);
        while (bridgeData.getBridge().size() > bridgeData.getCurrentPosition() && BridgeGame.gameStatus){
            BridgeGame.move(bridgeData, InputView.readMoving());
        }
    }
}
