package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upMap, List<String> downMap) {
        printUpMap(upMap);
        printDownMap(downMap);
    }

    private static void printUpMap(List<String> upMap) {
        for (int index = 0 ; index < upMap.size(); index++) {
            if (index == 0) {
                System.out.print("[ ");
            } else if (index > 0) {
                System.out.print(" | ");
            }
            System.out.print(upMap.get(index));
        }
        System.out.print(" ]\n");
    }

    private static void printDownMap(List<String> downMap) {
        for (int index = 0 ; index < downMap.size(); index++) {
            if (index == 0) {
                System.out.print("[ ");
            } else if (index > 0) {
                System.out.print(" | ");
            }
            System.out.print(downMap.get(index));
        }
        System.out.print(" ]\n");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        String gameResult = "성공";
        
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getUpMap(), bridgeGame.getDownMap());
        if (bridgeGame.getAskRetryMarker()) {
            gameResult = "실패";
        }
        System.out.println("\n게임 성공 여부: " + gameResult + "\n총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static void printBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printMovingChoiceMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printRetryMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
