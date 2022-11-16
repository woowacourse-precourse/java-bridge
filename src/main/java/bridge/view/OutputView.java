package bridge.view;

import bridge.BridgeGame;

class Message {
    public static final String Start = "다리 건너기 게임을 시작합니다.";
    public static final String Length = "다리의 길이를 입력해주세요.";
    public static final String Moving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String Retry = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
}

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, boolean success) {
        System.out.print("[ ");
        for (int step = 0; step < bridgeGame.getLocate(); step++) {
            if (bridgeGame.getBridge().get(step).equals("U")) {
                System.out.print("O ");
                continue;
            }
            System.out.print("  ");
        }
        System.out.println("]");
        System.out.print("[ ");
        for (int step = 0; step < bridgeGame.getLocate(); step++) {
            if (bridgeGame.getBridge().get(step).equals("D")) {
                System.out.print("X ");
                continue;
            }
            System.out.print("  ");
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean success) {
        String result = "성공";
        if (!success) {
            result = "실패";
        }
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, success);
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + bridgeGame.getTrial());
    }

    public void printMapLine(BridgeGame bridgeGame, boolean success, String identifier) {
        System.out.print("[ ");
        for (int step = 0; step < bridgeGame.getLocate() - 1; step++) {
            if (step > 1) {
                System.out.print("| ");
            }
            if (bridgeGame.getBridge().get(step).equals(identifier)) {
                System.out.print("O ");
                continue;
            }
            System.out.print("  ");
        }
    }

    public void printStart() {
        System.out.println(Message.Start);
        System.out.println();
    }

    public void printGetLength() {
        System.out.println(Message.Length);
    }

    public void printGetMoving() {
        System.out.println(Message.Moving);
    }

    public void printRetry() {
        System.out.println(Message.Retry);
    }

    public static void printError(String error) {
        System.out.println("[ERROR] " + error);
    }
}
