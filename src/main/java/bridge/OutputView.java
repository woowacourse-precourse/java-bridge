package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 게임 시작을 위한 문구를 출력한다.
     */
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 다리 길이 입력을 위한 문구를 출력한다.
     */
    public void printBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸을 선택하라는 문구를 출력한다.
     */
    public void printChoiceMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 윗 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printUpMap(List<String> upMoveResult) {
        for (int i = 0; i < upMoveResult.size(); i++) {
            if (i == 0) { System.out.print("["); }

            if (i != 0) { System.out.print(" |"); }

            System.out.print(" ");
            System.out.print(upMoveResult.get(i));
        }
        System.out.println(" ]");
    }

    /**
     * 아랫 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printDownMap(List<String> downMoveResult) {
        for (int i = 0; i < downMoveResult.size(); i++) {
            if (i == 0) { System.out.print("["); }

            if (i != 0) { System.out.print(" |"); }

            System.out.print(" ");
            System.out.print(downMoveResult.get(i));
        }
        System.out.println(" ]");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> moveResult) {
        printUpMap(moveResult.get(0));
        printDownMap(moveResult.get(1));
    }

    /**
     * 게임을 끝낼건지 묻는 문구를 출력한다.
     */
    public void printWantFinish() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과가 성공일 때
     */
    public void printSuccessResult(int gameCount) {
        System.out.println("게임 성공 여부: 성공");
        System.out.print("총 시도한 횟수: " + Integer.toString(gameCount));
    }

    /**
     * 게임의 최종 결과가 실패일 때
     */
    public void printFailResult(int gameCount) {
        System.out.println("게임 성공 여부: 실패");
        System.out.print("총 시도한 횟수: " + Integer.toString(gameCount));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> moveResult, int gameCount) {
        System.out.println("최종 게임 결과");
        printUpMap(moveResult.get(0));
        printDownMap(moveResult.get(1));

        if (!moveResult.get(0).contains("X") && !moveResult.get(1).contains("X")) {
            printSuccessResult(gameCount);
            return;
        }

        printFailResult(gameCount);
    }
}
