package bridge;

import bridge.constants.BridgeConstants;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new OutputView().printGameStart();
        List<String> bridge = printAndReadBridgeSize();
        int gameTryCount = BridgeConstants.GAME_TRY_START_COUNT;
        while (true){
            gameTryCount = new Gaming(bridge, gameTryCount).startGame();
            if (gameTryCount == BridgeConstants.ESCAPE_LOOP_NUM){break;}
        }
    }
    /** 입력받은 길이의 다리를 생성하는 기능 */
    static List<String> printAndReadBridgeSize(){
        new OutputView().printGetBridgeSize();
        int size = new InputView().readBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }
}
