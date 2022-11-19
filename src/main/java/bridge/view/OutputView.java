package bridge.view;

import bridge.constant.BridgeGameInfo;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> targetBridge, List<String> preStatus) {
        System.out.println(targetBridge);
        System.out.println(preStatus);
        // 윗줄 출력
        System.out.print("[ ");
        for (int i = 0; i < preStatus.size(); i++) {
            if (preStatus.get(i).equals("U")) {
                if (preStatus.get(i).equals(targetBridge.get(i))) {
                    if (i == preStatus.size()-1) {
                        System.out.print("O ");
                        continue;
                    }
                    System.out.print("O | ");
                    continue;
                }

                if (i == preStatus.size()-1) {
                    System.out.print("X ");
                    continue;
                }
                System.out.print("X | ");
            }

            if (preStatus.get(i).equals("D")) {
                if (i == preStatus.size()-1) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print("  | ");
            }
        }
        System.out.println("]");

        // 아랫줄 출력
        System.out.print("[ ");
        for (int i = 0; i < preStatus.size(); i++) {
            if (preStatus.get(i).equals("D")) {
                if (preStatus.get(i).equals(targetBridge.get(i))) {
                    if (i == preStatus.size()-1) {
                        System.out.print("O ");
                        continue;
                    }
                    System.out.print("O | ");
                    continue;
                }

                if (i == preStatus.size()-1) {
                    System.out.print("X ");
                    continue;
                }
                System.out.print("X | ");
            }

            if (preStatus.get(i).equals("U")) {
                if (i == preStatus.size()-1) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print("  | ");
            }
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println(BridgeGameInfo.RESULT.message);
    }

    // 게임시작 메세지 출력
    public static void printStart() {
        System.out.println(BridgeGameInfo.START.message);
    }

    // 시도 횟수 출력
    public static void printTryNumber(int number) {
        System.out.print(BridgeGameInfo.TOTAL_TRY.message);
        System.out.println(number);
    }

    // 성공 여부 출력
    public static void printSuccessFailure() {
        System.out.println(BridgeGameInfo.SUCSSES_FAILURE.message);

    }
}
