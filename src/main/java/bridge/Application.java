package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 다리 건너기 게임 시작
        System.out.println("다리 건너기 게임을 시작합니다.");

        // 다리의 길이를 입력
        System.out.println("다리의 길이를 입력해주세요.");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        // 다리를 만듦
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge.toString());


    }
}
