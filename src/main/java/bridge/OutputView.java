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
    public static void printMap(List<String> bridgeNow, boolean flag) {
        StringBuilder UpStep = new StringBuilder("[ ");
        StringBuilder DownStep = new StringBuilder("[ ");
        for (String s : bridgeNow) {
            if ((s.equals("1")) && (flag)) {
                UpStep.append("O | ");
                DownStep.append("  | ");
            }
            if ((s.equals("0")) && (flag)) {
                UpStep.append("  | ");
                DownStep.append("O | ");
            }
            if ((s.equals("1")) && (!flag)) {
                UpStep.append("X | ");
                DownStep.append("  | ");
            }
            if ((s.equals("0")) && (!flag)) {
                UpStep.append("  | ");
                DownStep.append("X | ");
            }
        }
        UpStep.deleteCharAt(UpStep.length() - 1);
        UpStep.deleteCharAt(UpStep.length() - 1);
        DownStep.deleteCharAt(DownStep.length() -1);
        DownStep.deleteCharAt(DownStep.length() -1);

        System.out.println(UpStep + "]");
        System.out.println(DownStep + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println("최종 게임 결과");
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
