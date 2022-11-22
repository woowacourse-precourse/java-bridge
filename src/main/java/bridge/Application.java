package bridge;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new OutputView().printGameStart();
        List<String> bridge = printAndReadBridgeSize();
        int gameTryCount = 1;
        while (true){
            gameTryCount = new Gaming(bridge, gameTryCount).startGame();
            if (gameTryCount == -1){break;}
        }
    }
    /** 입력받은 길이의 다리를 생성하는 기능 */
    static List<String> printAndReadBridgeSize(){
        new OutputView().printGetBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(new InputView().readBridgeSize());
    }
}
