package bridge;

import java.util.List;

public class OutputView {

    public static void printMap(List<String> bridgeNow, boolean success, String moveTo) {
        StringBuilder UpStep = new StringBuilder("[ " + UpStepAdder(bridgeNow));
        StringBuilder DownStep = new StringBuilder("[ " + DownStepAdder(bridgeNow));

        if (success) {
            continueRound(UpStep, DownStep);
            return;
        }
        overRound(UpStep, DownStep, moveTo);
    }

    public static void printResult(Bridge bridge, boolean flag, String moveTo) {
        System.out.println("최종 게임 결과");
        printMap(bridge.getBridgeNow(), flag, moveTo);
        if (flag) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!flag) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridge.getCountTotal());
    }

    private static void continueRound(StringBuilder UpStep, StringBuilder DownStep) {
        System.out.println(UpStep.substring(0,UpStep.length() - 3) + " ]");
        System.out.println(DownStep.substring(0,DownStep.length() - 3) + " ]");
    }

    private static void overRound(StringBuilder UpStep, StringBuilder DownStep, String moveTo) {
        if (moveTo.equals("U")) {
            System.out.println(UpStep.substring(0,UpStep.length() - 4) + "X ]");
            System.out.println(DownStep.substring(0,DownStep.length() - 2) + "]");}
        if (moveTo.equals("D")) {
            System.out.println(UpStep.substring(0,UpStep.length() - 2) + "]");
            System.out.println(DownStep.substring(0,DownStep.length() - 4) + "X ]");}
    }

    private static StringBuilder UpStepAdder(List<String> bridgeNow) {
        StringBuilder adder = new StringBuilder("");
        for (String s : bridgeNow) {
            if (s.equals("U")) {
                adder.append("O | ");
            }
            if (s.equals("D")) {
                adder.append("  | ");
            }
        }
        return adder;
    }

    private static StringBuilder DownStepAdder(List<String> bridgeNow) {
        StringBuilder adder = new StringBuilder("");
        for (String s : bridgeNow) {
            if (s.equals("U")) {
                adder.append("  | ");
            }
            if (s.equals("D")) {
                adder.append("O | ");
            }
        }
        return adder;
    }

    public static void messageGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void messageInputBridge() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void messageInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void messageRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
