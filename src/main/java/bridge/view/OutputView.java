package bridge.view;

import java.util.List;

public class OutputView {

    public void printMap(List<String> toStringBridges) {
        System.out.println(toStringBridges.get(0) + "\n" + toStringBridges.get(1) + "\n");
    }

    public void printResult(List<String> finalMap, String successOrFail, int triedNumber) {
        System.out.println("최종 게임 결과");
        printMap(finalMap);

        System.out.println("게임 성공 여부 : " + successOrFail);
        System.out.println("총 시도한 횟수 : " + triedNumber);
    }
}
