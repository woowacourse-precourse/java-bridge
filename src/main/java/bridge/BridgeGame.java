package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeMaker bridgeMaker;
    public static List<String> bridge;
    public static int bridgeSize;
    public static List<String> userInput;

    public void setBridgeSize(int bridgeSize){
        this.bridgeSize = bridgeSize;
    }
    public void setBridge(){bridge = bridgeMaker.makeBridge(bridgeSize);}
    public static int getUserInputSize(){return userInput.size();}
    public static int getBridgeSize(){return bridgeSize;}

}
