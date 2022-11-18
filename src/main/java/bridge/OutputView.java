package bridge;

public class OutputView {
    private static StringBuilder[] map = new StringBuilder[2];

    private static void resetMap() {
        map[0].setLength(0);
        map[1].setLength(1);
    }

    private static void addDelimiter() {
        map[0].append("|");
        map[1].append("|");
    }

    private static void addComponent(String step, boolean stepStatus) {
        map[0].append(MapSkeleton.valueOf(step).getFirst(stepStatus));
        map[1].append(MapSkeleton.valueOf(step).getSecond(stepStatus));
    }

    private static void wrapMap() {
        map[0].insert(0, "[");
        map[0].append("]");
        map[1].insert(0, "[");
        map[1].append("]");
    }

    private static void drawMap(BridgeGame bridgeGame) {
        for (int i = 0; i < bridgeGame.getStepNumber(); i++) {
            String bridgeI = bridgeGame.getBridge().get(i);
            boolean stepStatus = bridgeGame.getStepStatus(i);
            addComponent(bridgeI, stepStatus);
            if (i != bridgeGame.getStepNumber() - 1) addDelimiter();
        }
        wrapMap();
    }

    public static void printMap(BridgeGame bridgeGame) {
        drawMap(bridgeGame);
        System.out.println(map[0].toString());
        System.out.println(map[1].toString());
        resetMap();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
    }
}
