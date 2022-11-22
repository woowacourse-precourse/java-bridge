package bridge.view;

import bridge.setting.Setting;

import java.util.List;

public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<String> bridge) {
        for (String bridgeRow : bridge) {
            System.out.print("[ ");
            System.out.print(bridgeRow);
            System.out.println(" ]");
        }
    }

    public void printResult(List<String> bridge, String resultMessage, int tryCount) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(bridge);

        System.out.println(String.format("%n게임 성공 여부: %s", resultMessage));
        System.out.println(String.format("총 시도한 횟수: %d", tryCount));
    }
}
