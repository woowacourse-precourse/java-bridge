package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 게임 시작 안내 메세지 출력
     */
    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public static void printMap(List<String> map) {
        for (String path : map) {
            System.out.println(path);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMap());

        String result;
        if (bridgeGame.hasSucceeded()) {
            result = "성공";
        } else {
            result = "실패";
        }

        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + bridgeGame.getTrial());
    }
}
