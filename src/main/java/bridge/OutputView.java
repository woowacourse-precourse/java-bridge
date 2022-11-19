package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    List<String> bridge;

    public OutputView(List<String> bridge) {
        this.bridge = bridge;
    }

    public void printMap(int currentPosition, String moving) {
        printUpperSideRecord(currentPosition);
        printUpperSideNewRecord(currentPosition, moving);
        printLowerSideRecord(currentPosition);
        printLowerSideNewRecord(currentPosition, moving);
    }

    // 이전 다리 상태 위쪽 출력
    private void printUpperSideRecord(int currentPosition) {
        System.out.print("[");
        for (int i = 0; i < currentPosition; i++) {
            if (this.bridge.get(i).equals("U")) {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
    }

    // 새로 생기는 다리 위쪽 출력
    private void printUpperSideNewRecord(int currentPosition, String moving) {
        if (this.bridge.get(currentPosition).equals("U")) {
            if (this.bridge.get(currentPosition).equals(moving)) {
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
        }
        if (this.bridge.get(currentPosition).equals("D")) {
            System.out.println("   ]");
        }
    }

    // 이전 다리 상태 아래쪽 출력
    private void printLowerSideRecord(int currentPosition) {
        System.out.print("[");
        for (int i = 0; i < currentPosition; i++) {
            if (this.bridge.get(i).equals("D")) {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
    }

    // 새로 생기는 다리 아래쪽 출력
    private void printLowerSideNewRecord(int currentPosition, String moving) {
        if (this.bridge.get(currentPosition).equals("D")) {
            if (this.bridge.get(currentPosition).equals(moving)) {
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
        }
        if (this.bridge.get(currentPosition).equals("U")) {
            System.out.println("   ]");
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int trialCount, int bestRecordPosition, boolean SuccessOrFail) {
        System.out.println("최종 게임 결과");
        System.out.println("게임 성공 여부 : 실패");
        System.out.println("게임 성공 여부 : 성공");
        System.out.println("총 시도한 횟수: " + "1");
    }
}
