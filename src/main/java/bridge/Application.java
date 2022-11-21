package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static bridge.Constants.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();

        outputView.printInit();
        int bridgeSize = inputView.readBridgeSize();

        // TODO: 사이즈만큼 다리 생성
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        List<String> userMove = new ArrayList<>();
        List<String> moveResults = new ArrayList<>();
        int tryCount = 1;
        // TODO: 사이즈만큼 사용자로부터 다리 정보 입력받기
        for(int size = 0; size < bridgeSize; size++) {
            outputView.printSelect();
            String moving = inputView.readMoving();
            userMove.add(moving);
        }

    }


}
