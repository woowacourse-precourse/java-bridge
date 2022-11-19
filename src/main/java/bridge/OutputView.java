package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_MESSAGE = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> result) {
        System.out.println(bridgeOfTop(bridge, result));
        System.out.println(bridgeOfBottom(bridge, result));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    /**
     * 게임 중 발생한 에러에 대한 정보를 출력한다.
     *
     * @param error 에러의 타입
     */
    public void printError(Exception error) {
        System.out.println(ERROR_MESSAGE + error.getMessage());
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printAskBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printAskMovement() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    private String bridgeOfTop(List<String> bridge, List<String> result) {
        StringBuilder top = new StringBuilder("[ ");
        int moveSize = result.size();
        for (int point = 0; point < moveSize - 1; point++) {
            top.append(checkMoveTop(bridge.get(point)));
        }
        top.append(checkLastMoveTop(bridge.get(moveSize - 1), result.get(moveSize - 1)));
        return top.toString();
    }

    private String checkMoveTop(String bridgePoint) {
        if (bridgePoint.equals("U")) {
            return "O | ";
        }
        return "  | ";
    }

    private String checkLastMoveTop(String lastBridgePoint, String resultLastBridgePoint) {
        if (lastBridgePoint.equals("U") & resultLastBridgePoint.equals("O")
                | lastBridgePoint.equals("D") & resultLastBridgePoint.equals("X")) {
            return resultLastBridgePoint + " ]";
        }
        return "  ]";
    }

    private String bridgeOfBottom(List<String> bridge, List<String> result) {
        StringBuilder bottom = new StringBuilder("[ ");
        int moveSize = result.size();
        for (int point = 0; point < moveSize - 1; point++) {
            bottom.append(checkMoveBottom(bridge.get(point)));
        }
        bottom.append(checkLastMoveBottom(bridge.get(moveSize - 1), result.get(moveSize - 1)));
        return bottom.toString();
    }

    private String checkMoveBottom(String bridgePoint) {
        if (bridgePoint.equals("D")) {
            return "O | ";
        }
        return "  | ";
    }

    private String checkLastMoveBottom(String lastBridgePoint, String resultLastBridgePoint) {
        if (lastBridgePoint.equals("U") & resultLastBridgePoint.equals("X")
                | lastBridgePoint.equals("D") & resultLastBridgePoint.equals("O")) {
            return resultLastBridgePoint + " ]";
        }
        return "  ]";
    }

}
