package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    //TODO: enum 변경, 상수화,

    public void addBridge(String playerMoving, String bridgeJudgment) {
        if (playerMoving.equals("U") && bridgeJudgment.equals("O")) {
            upBridge.add(bridgeJudgment);
            downBridge.add(" ");
        }

        if (playerMoving.equals("U") && bridgeJudgment.equals("X")) {
            upBridge.add(bridgeJudgment);
            downBridge.add(" ");
        }

        if (playerMoving.equals("D") && bridgeJudgment.equals("O")) {
            upBridge.add(" ");
            downBridge.add(bridgeJudgment);
        }

        if (playerMoving.equals("D") && bridgeJudgment.equals("X")) {
            upBridge.add(" ");
            downBridge.add(bridgeJudgment);
        }
    }

    //TODO: 너무 겟터 스럽게 작성을 금지 다시 수정하기.
    public List<String> getUpBridge() {
        return upBridge;
    }

    //TODO: 너무 겟터 스럽게 작성을 금지 다시 수정하기.
    public List<String> getDownBridge() {
        return downBridge;
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }

    public void initBridgeState() {
        upBridge.add("[ ");
        downBridge.add("[ ");
    }

    public void endPrintBridge() {
        systemConsole.lastGameResult();
        for (String uparr : upBridge) {
            System.out.print(uparr);
        }
        System.out.println();

        for (String downBridge : downBridge) {
            System.out.print(downBridge);
        }
        System.out.println();
    }
}
