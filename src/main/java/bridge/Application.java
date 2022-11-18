package bridge;

import java.util.List;

public class Application {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 게임을 시작하는 문구 출력
        outputView.printStartGame();
        
        // 다리 길이 입력 받는 안내 문구 출력
        outputView.printInputBridgeLength();
        int bridgeSize;
        
        // 다리길이 입력받기 + 예외 시 추가적으로 계속 입력
        while(true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

    }
}
