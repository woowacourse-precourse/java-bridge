package bridge;

import java.util.List;
import java.util.Map;

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
        String ret = "O";
        if(!correct) {
            ret = "X";
        }

        if(line.equals(cell)) {
            return ret;
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
    public void printStartGameMessage() {
    }

    public void printInputSizeMessage() {

    }

    public void printMoveMessage() {
    }

    public void printRetryMessage() {
    }
}
