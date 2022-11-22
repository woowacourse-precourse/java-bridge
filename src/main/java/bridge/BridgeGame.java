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
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        userInput.add(moving);
        return Objects.equals(bridge.get(userInput.size() - 1), moving);
    }
}
