package bridge;

import bridge.BridgeGame.BridgeGame;
import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = new BridgeGame(generator);

        int location = 0, count = 1;
        boolean tryFlag = true, retryFlag = false;

        while(location < bridgeGame.getBridgeSize() && tryFlag){
            // 다리 맞추기를 시도하고, 실패한 경우
            if(!bridgeGame.move(location)) {
                tryFlag = false;
                retryFlag = bridgeGame.retry();
            }

            // 재도전을 수락한 경우
            if(retryFlag) {
                location = 0;
                bridgeGame.clear();
                tryFlag = true;
                retryFlag = false;
                count++;
                continue;
            }

            location++;
        }

        bridgeGame.printResult(tryFlag, count);
    }
}
