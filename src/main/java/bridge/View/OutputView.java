package bridge.View;

import bridge.BridgeGame;
import bridge.Positions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.Utils.change_delimter;

public class OutputView {


    public void printMap() {
        System.out.println(change_delimter(Positions.getUp_Positions()));
        System.out.println(change_delimter(Positions.getDown_positions()));
    }

    public void printResult(int count, String status) {
        System.out.print("최종 게임 결과" + "\n");
        printMap();
        System.out.print("게임 성공 여부: " + status + "\n");
        System.out.print("총 시도한 횟수: " + count);
    }

}
