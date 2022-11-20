package bridge.domain;

import bridge.constants.Command;
import java.util.ArrayList;
import java.util.List;

public class BridgeState {  // Map 걷어내고 이거 쓰겠다.

    private final List<String> upBridge = new ArrayList<>();   // "| O |"
    private final List<String> downBridge = new ArrayList<>(); // "|   |"

    // up     O,O,O
    // down " "," "," "
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
        for(String uparr : upBridge) {
             System.out.print(uparr);
        }
        System.out.println();

        for(String downBridge : downBridge) {
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
        System.out.println("최종 게임 결과");

        for(String uparr : upBridge) {
            System.out.print(uparr);
        }
        System.out.println();

        for(String downBridge : downBridge) {
            System.out.print(downBridge);
        }
        System.out.println();
    }

}
