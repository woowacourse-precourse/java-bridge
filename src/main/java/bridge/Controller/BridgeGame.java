package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Entity.Bridge;
import bridge.Entity.BridgeMaker;
import bridge.Service.BridgeResult;
import bridge.Service.GenerateBridgeSize;
import bridge.Service.GenerateUserBridge;

import java.util.ArrayList;
import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void start() {
        int size = getsize();
        List<String> randomBridge = getrandomBridge(size);
        play(size, randomBridge);
    }

    public boolean play(int size, List<String> randomBridge) {
        List<Bridge> bridgeList = new ArrayList<>();
        List<String> userList = new ArrayList<>();
        for (int i=0;i<size;i++) {
            userList.add(move());
            bridgeList.add(CanGo(randomBridge.get(i), userList.get(i)));
            BridgeResult.getresult(bridgeList, userList);
        }
        return true;
    }

    private int getsize() {
        return new GenerateBridgeSize().getBridgeSize();
    }

    private List<String> getrandomBridge(int size) {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        System.out.println(bridge);
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        return new GenerateUserBridge().getInput();
    }

    public Bridge CanGo(String bridge, String user) {
        return Bridge.compareTo(bridge, user);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int size, List<String> existingBridge) {
        if (BridgeResult.requestReGame())
            play(size, existingBridge);

    }
}
