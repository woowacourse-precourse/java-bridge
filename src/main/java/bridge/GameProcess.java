package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    List<String> userInput = new ArrayList<>();
    Integer gameTryCount = 0;

    public int bridgeSizeProcess() {
        int userBridgeSize = 0;
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        userBridgeSizeInput(userBridgeSize);
        return userBridgeSize;
    }

    public void userBridgeSizeInput(int userBridgeSize) {
        while(true) {
            System.out.println("다리의 길이를 입력해주세요");
            try {
                userBridgeSize = inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    public List<String> bridgeGenerateProcess(int userBridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(userBridgeSize);
        System.out.println(bridgeAnswer);
        return bridgeAnswer;
    }

    
}
