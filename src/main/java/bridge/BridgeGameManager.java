package bridge;

import java.util.*;

public class BridgeGameManager {

    static List<Integer> bridge = new ArrayList<>();
    static List<String> bridgeCheck = new ArrayList<>();

    public void inputChanger(String userUpDown) {
        int zeroOrOne = InputUpOrDown.getZeroOrOne(userUpDown);
        bridge.add(zeroOrOne);
        bridgeCheck.add(checkBridge(zeroOrOne));
        OutputView.printMap(bridgeCheck);
    }


    public String checkBridge(int zeroOrOne) {
        System.out.println("this is bridge structure" + BridgeMaker.bridgeStructure);
        System.out.println("this is bridge" + bridge);
        String shouldBe = BridgeMaker.bridgeStructure.get(bridge.size() - 1);
        String asIs = String.valueOf(zeroOrOne);

        if (shouldBe.equals(asIs)) {
            return "O";
        }
        // choose whether to rerun the game
        BridgeGame.retry();
        return "X";
    }
}
