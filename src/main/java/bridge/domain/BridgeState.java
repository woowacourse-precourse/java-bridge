package bridge.domain;

import bridge.view.SystemConsole;
import java.util.ArrayList;
import java.util.List;

public class BridgeState {
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();
    private final SystemConsole systemConsole;

    public BridgeState(SystemConsole systemConsole) {
        this.systemConsole = systemConsole;
    }

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

    public void connection(int bridgeLength, String bridgeJudgment, int i) {
        if (i != bridgeLength - 1 && bridgeJudgment.equals("O")) {
            upBridge.add(" | ");
            downBridge.add(" | ");
        }

        if (i == bridgeLength - 1 || bridgeJudgment.equals("X")) {
            upBridge.add(" ]");
            downBridge.add(" ]");
        }
    }

    public void printBridge() {
        for (String uparr : upBridge) {
            System.out.print(uparr);
        }
        System.out.println();

        for (String downBridge : downBridge) {
            System.out.print(downBridge);
        }
        System.out.println();
    }

    public String findLastValue() {
        StringBuilder str = new StringBuilder();
        for (String arr : upBridge) {
            str.append(arr);
        }
        return str.toString();
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
