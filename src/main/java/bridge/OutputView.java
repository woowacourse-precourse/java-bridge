package bridge;

import java.util.ArrayDeque;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printResult(ArrayDeque<String> bridge, int trialCount) {
        System.out.println("\n최종 게임 결과");
        printMap(bridge);
        if (bridge.getLast().equals("UO") || bridge.getLast().equals("DO")) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (bridge.getLast().equals("UX") || bridge.getLast().equals("DX")) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + trialCount);
    }

    public void printMap(ArrayDeque<String> bridge) {
        printUpperSideRecord(bridge);
        printUpperSideNewRecord(bridge.getLast());
        printLowerSideRecord(bridge);
        printLowerSideNewRecord(bridge.getLast());
    }

    // 이전 다리 상태 위쪽 출력
    private void printUpperSideRecord(ArrayDeque<String> bridge) {
        System.out.print("[");
        for (String position : bridge) {
            if (position.equals("U")) {
                System.out.print(" O |");
            }
            if (position.equals("D")) {
                System.out.print("   |");
            }
        }
    }

    // 새로 생기는 다리 위쪽 출력
    private void printUpperSideNewRecord(String lastPosition) {
        if (lastPosition.equals("UO")) {
            System.out.println(" O ]");
            return;
        }
        if (lastPosition.equals("UX")) {
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }

    // 이전 다리 상태 아래쪽 출력
    private void printLowerSideRecord(ArrayDeque<String> bridge) {
        System.out.print("[");
        for (String position : bridge) {
            if (position.equals("D")) {
                System.out.print(" O |");
            }
            if (position.equals("U")) {
                System.out.print("   |");
            }
        }
    }

    // 새로 생기는 다리 아래쪽 출력
    private void printLowerSideNewRecord(String lastPosition) {
        if (lastPosition.equals("DO")) {
            System.out.println(" O ]");
            return;
        }
        if (lastPosition.equals("DX")) {
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }

}
