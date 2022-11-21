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
            // TODO: 다리 정보와 입력받은 정보 비교하여 결과 도출
            String bridgeInfo = bridgeList.get(size);
            String result = bridgeGame.move(moving, bridgeInfo);
            moveResults.add(result);
            outputView.printMap(moveResults, size, userMove);
            //TODO: 틀릴 경우 재시도 여부 입력받고 재시도진행
            if(result.equals(CANNOT_CROSS)){
                outputView.printRetry();
                String command = inputView.readGameCommand();
                HashMap<String, Integer> retryInfo = bridgeGame.retry(command, bridgeSize, tryCount);
                size = retryInfo.get("bridge");
                tryCount = retryInfo.get("count");
            }
        }
        outputView.printResult(moveResults, userMove, tryCount);
    }


}
