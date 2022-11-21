package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static int location;
//    private static List<String> builtbridge;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> builtbridge = bridgeMaker.makeBridge(bridgeSize);
//        System.out.println(builtbridge);
        return builtbridge;
    }

    public boolean move(String userMove, int location, List<String> builtBridge) {

        if (userMove.equals(builtBridge.get(location))) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {

        if (command.equals("Q")) {
            return false;
        }
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

}
