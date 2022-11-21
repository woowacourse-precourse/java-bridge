package bridge.view;

import bridge.constant.BridgeGameInfo;
import bridge.model.Bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static void printSuccess() {
        System.out.println("성공");
    }

    private static void printFailure() {
        System.out.println("실패");
    }

    private static boolean isSameSize(Bridge target, List<String> pre) {
        return target.getSize() == pre.size();
    }

    private static boolean isSame(Bridge target, List<String> pre) {
        int size = pre.size();
        for (int i = 0; i < size; i++) {
            if (!target.bridgeSameIndex(i, pre.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void printTop(Bridge
                                         targetBridge, List<String> preStatus) {
        System.out.print("[ ");
        for (int i = 0; i < preStatus.size(); i++) {
            if (preStatus.get(i).equals("U")) {
                if (preStatus.get(i).equals(targetBridge.getBridgeShape().get(i))) {
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
    }

    private static void printBottom(Bridge targetBridge, List<String> preStatus) {
        System.out.print("[ ");
        for (int i = 0; i < preStatus.size(); i++) {
            if (preStatus.get(i).equals("D")) {
                if (preStatus.get(i).equals(targetBridge.getBridgeShape().get(i))) {
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

    public static void printMap(Bridge targetBridge, List<String> preStatus) {
        printTop(targetBridge,  preStatus);
        printBottom(targetBridge,  preStatus);
    }

    public static void printResult() {
        System.out.println(BridgeGameInfo.RESULT.message);
    }

    public static void printStart() {
        System.out.println(BridgeGameInfo.START.message);
    }

    public static void printTryNumber(int number) {
        System.out.print(BridgeGameInfo.TOTAL_TRY.message);
        System.out.println(number);
    }

    public static void printSuccessFailure(Bridge targetBridge, List<String> preStatus) {
        System.out.print(BridgeGameInfo.SUCSSES_FAILURE.message);
        if (!isSameSize(targetBridge, preStatus)) {
            printFailure();
            return;
        }

        if (isSame(targetBridge, preStatus)) {
            printSuccess();
            return;
        }
        printFailure();
    }
}