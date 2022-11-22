package bridge.view;

import java.util.List;

import static bridge.view.message.PrintMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBoardList, List<String> downBoardList) {
        String upMap = getUpMap(upBoardList);
        String downMap = getDownMap(downBoardList);
        System.out.println(upMap + downMap);
    }

    private String getUpMap(List<String> upBoardList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < upBoardList.size() - 1; i++) {
            stringBuilder.append(" ").append(upBoardList.get(i)).append(" ");
            stringBuilder.append("|");
        }
        stringBuilder.append(" ").append(upBoardList.get(upBoardList.size() - 1)).append(" ");
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    private String getDownMap(List<String> downBoardList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < downBoardList.size() - 1; i++) {
            stringBuilder.append(" ").append(downBoardList.get(i)).append(" ");
            stringBuilder.append("|");
        }
        stringBuilder.append(" ").append(downBoardList.get(downBoardList.size() - 1)).append(" ");
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputBoard() {
        System.out.println(INPUT_BOARD_MESSAGE);
    }
}
