package bridge;

import java.util.List;

public class Application {
    static BridgeGame bridgeGame = new BridgeGame();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        List<String> bridgeState = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridgeState);
        List<String> currentBridgeState=bridgeMaker.initialBridge();
        int count=0;
        while(true){
            if(count>=bridgeState.size()){
                break;
            }
            currentBridgeState = outputView.printMap(bridgeMaker.addBridge(currentBridgeState,bridgeGame.replacePositonNumber(bridgeState.get(count)),bridgeGame.move()));
            count++;
        }

    }
}
