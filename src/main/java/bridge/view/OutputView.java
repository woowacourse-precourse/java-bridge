package bridge.view;

import bridge.MoveResult;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 요구 사항 분석 :
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public static final String OUTPUT_MESSAGE_RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String OUTPUT_MESSAGE_START_GAME = "다리 건너기 게임을 시작합니다.";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int playerPosition, MoveResult lastMoveResult) {
        System.out.print("[");

        List<String> movePaths = Arrays.asList("U", "D");

        for (String path : movePaths) {
            for (int i = 0; i <= playerPosition; i++) {
                if (playerPosition != i) {
                    if (bridge.get(i).equals(path)) {
                        System.out.print(" O |");
                        continue;
                    }
                    if ((!bridge.get(i).equals(path))) {
                        System.out.print("   |");
                        continue;
                    }
                } else {
                    if (lastMoveResult == MoveResult.O) {
                        if (bridge.get(i).equals(path)) {
                            System.out.println(" O ]");
                        } else {
                            System.out.println("   ]");
                        }
                    } else {//X 또는 빈칸
                        if (bridge.get(i).equals(path)) {
                            System.out.println("   ]");
                        } else {
                            System.out.println(" X ]");
                        }
                    }
                }
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartMassage() {
        System.out.println(OUTPUT_MESSAGE_START_GAME);
    }

    public void printRestartMassage() {
        System.out.println(OUTPUT_MESSAGE_RESTART_GAME);
    }
}
