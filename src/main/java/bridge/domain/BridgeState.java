package bridge.domain;

import bridge.constants.Command;
import java.util.ArrayList;
import java.util.List;

public class BridgeState {
    private static final String SPACE = " ";

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

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

    public String upBridgeGenerate() {
        return "[ " + String.join(" | ", upBridge) + " ]";
    }

    public String downBridgeGenerate() {
        return "[ " + String.join(" | ", downBridge) + " ]";
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
