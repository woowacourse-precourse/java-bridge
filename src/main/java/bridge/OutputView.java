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
    public void printMap(List<String> bridge, int pos, boolean correct) {
        printMapLine(bridge.subList(0, pos+1), "U", correct);
        printMapLine(bridge.subList(0, pos+1), "D", correct);
    }

    private void printMapLine(List<String> bridge, String line, boolean correct) {
        int lastIdx = bridge.size() - 1;

        System.out.print("[ ");
        for(int idx = 0; idx < lastIdx; idx++) {
            System.out.printf("%s | ", onPath(line, bridge.get(idx), true));
        }

        System.out.printf("%s ]\n", onPath(line, bridge.get(lastIdx), correct));
    }

    private String onPath(String line, String cell, boolean correct) {
        if(correct) {
            if(line.equals(cell)) {
                return "O";
            }
            return " ";
        }

        if(!line.equals(cell)) {
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int trial) {
        System.out.printf("게임 성공 여부: \n");
        System.out.printf("총 시도한 횟수: %d\n", trial);
    }

    /** 추가 출력 메세지
     */
    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
    public void printStartGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoveMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
