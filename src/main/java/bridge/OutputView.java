package bridge;

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
    public static void printMap(List<String> bridgeNow, boolean flag, String moveTo) {
        StringBuilder UpStep = new StringBuilder("[ ");
        StringBuilder DownStep = new StringBuilder("[ ");
        for (String s : bridgeNow) {
            if (s.equals("1")) {
                UpStep.append("O | ");
                DownStep.append("  | ");
            }
            if (s.equals("0")) {
                UpStep.append("  | ");
                DownStep.append("O | ");
            }
        }
        if (flag) {
            continueRound(UpStep, DownStep);
        }
        if (!flag) {
            overRound(UpStep, DownStep, moveTo);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridgeNow, boolean flag, String moveTo, int totalCount) {
        System.out.println("최종 게임 결과");
        printMap(bridgeNow, flag, moveTo);
        if (flag) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!flag) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + totalCount);
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
}
