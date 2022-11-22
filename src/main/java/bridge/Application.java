package bridge;

import java.util.List;

public class Application {

    static final String START_GAME = "다리 건너기 게임을 시작합니다. \n";

    public static void main(String[] args) {
        // 게임 시작
        System.out.println(START_GAME);

        // 다리 길이 입력 받기
        int bridgeSize = InputView.readBridgeSize();

        // 랜덤으로 건널 수 있는 다리 생성
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridgeShape = bridgeMaker.makeBridge(bridgeSize);

        // 이동 할 다리를 선택하여 다리 건너기
        new CrossBridge(bridgeSize, bridgeShape);


    }
}
