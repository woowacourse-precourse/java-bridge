package bridge.model;

import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CompareBridge {

    public static StringBuilder sbUp = new StringBuilder();
    public static StringBuilder sbDown = new StringBuilder();
    public static List<String> ranBridge = BridgeMaker.getBridge();
    public static int udCount = 0;


    // 윗 열 비교
    public static void compareUp(int i, String compare) {
        if (compare.equals("U")) {
            sbDown.append("|   ");
            if (ranBridge.get(i).equals(compare)) {
                sbUp.append("| O ");
                BridgeController.compareBridgeNum++;
                OutputView.printMap();
            }
            if (!ranBridge.get(i).equals(compare)) {
                sbUp.append("| X ");
                // retry method : Q 면 최종 게임 결과 출력, R이면 4칸 지우고 다시 + , compareBridgeNum -1
                OutputView.printMap();
                BridgeController.retryGame();
            }
        }
    }

    //아랫 열 비교
    public static void compareDown(int i, String compare) {
        if (compare.equals("D")) {
            sbUp.append("|   ");
            if (ranBridge.get(i).equals(compare)) {
                sbDown.append("| O ");
                BridgeController.compareBridgeNum++;
                OutputView.printMap();
            }
            if (!ranBridge.get(i).equals(compare)) {
                sbDown.append("| X ");
                OutputView.printMap();
                BridgeController.retryGame();
            }
        }
    }



}
