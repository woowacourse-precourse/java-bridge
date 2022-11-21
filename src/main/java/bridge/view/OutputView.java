package bridge.view;

import bridge.dto.PathTravel;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final String BRIDGE_DIVIDING_LINE = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PathTravel pathTravel) {
        printPlayerMap(pathTravel.getUpperBridge());
        printPlayerMap(pathTravel.getLowerBridge());
    }

    private void printPlayerMap(final List<String> map) {
        System.out.print(BRIDGE_START);

        int mapSize = map.size();
        for (int i = 0; i < mapSize; i++) {
            System.out.print(map.get(i));
            if (canPrintDividingLine(i, mapSize)) {
                System.out.print(BRIDGE_DIVIDING_LINE);
            }
        }
        System.out.println(BRIDGE_END);
    }

    private boolean canPrintDividingLine(int currentPosition, int mapSize) {
        if (currentPosition < mapSize - 1) {
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printError(String message) {
        System.out.println(message);
    }

}