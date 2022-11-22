package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    List<String> trialMap_down = BridgeGame.trialMap_down;
    List<String> trialMap_up = BridgeGame.trialMap_up;
    List<String> recordUpTable = new ArrayList<>();
    List<String> recordDownTable = new ArrayList<>();

    public void startMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap() {
        for (int i = 0; i < printUpRoadRecord().size(); i++)
            System.out.print(printUpRoadRecord().get(i));
        for (int i = 0; i < printDownRoadRecord().size(); i++)
            System.out.print(printDownRoadRecord().get(i));
    }
    public List<String> printUpRoadRecord() {
        recordUpTable = new ArrayList<>();
        recordUpTable.add("[");
        for (int i = 0; i < trialMap_up.size(); i++) {
            if (i > 0) recordUpTable.add("|");
            recordUpTable.add(trialMap_up.get(i));
        }
        recordUpTable.add("]\n");

        return recordUpTable;
    }


    public List<String> printDownRoadRecord() {
        recordDownTable = new ArrayList<>();
        recordDownTable.add("[");
        for (int i = 0; i < trialMap_down.size(); i++) {
            if (i > 0) recordDownTable.add("|");
            recordDownTable.add(trialMap_down.get(i));
        }
        recordDownTable.add("]\n");

        return recordDownTable;
    }


    public void printResult(String lastFilter, int totalTrial) {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("게임 성공 여부: " + lastFilter);
        System.out.println("총 시도한 횟수: " + totalTrial);
    }
}
