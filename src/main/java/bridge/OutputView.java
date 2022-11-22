package bridge;

public class OutputView {

    private static StringBuilder[] initializeMap() {
        StringBuilder[] map = new StringBuilder[2];
        map[0] = new StringBuilder();
        map[1] = new StringBuilder();
        return map;
    }

    private static void addDelimiter(StringBuilder[] map) {
        map[0].append("|");
        map[1].append("|");
    }

    private static void addComponent(StringBuilder[] map, String step, boolean stepStatus) {
        map[0].append(MapSkeleton.valueOf(step).getFirst(stepStatus));
        map[1].append(MapSkeleton.valueOf(step).getSecond(stepStatus));
    }

    private static StringBuilder[] wrapMap(StringBuilder[] map) {
        map[0].insert(0, "[");
        map[0].append("]");
        map[1].insert(0, "[");
        map[1].append("]");
        return map;
    }

    private static StringBuilder[] drawMap(BridgeGame bridgeGame) {
        StringBuilder[] map = initializeMap();
        for (int i = 0; i < bridgeGame.getStepNumber(); i++) {
            String bridgeI = bridgeGame.getBridge().get(i);
            boolean stepStatus = bridgeGame.getStepStatus(i);
            addComponent(map, bridgeI, stepStatus);
            if (i != bridgeGame.getStepNumber() - 1) addDelimiter(map);
        }
        return wrapMap(map);
    }

    public static void printMap(BridgeGame bridgeGame) {
        StringBuilder[] map = drawMap(bridgeGame);
        System.out.println(map[0].toString());
        System.out.println(map[1].toString());
        System.out.println();
    }

    public static void printResult(BridgeGame bridgeGame) {
        String result = "실패";
        if (bridgeGame.terminateCheck()) result = "성공";
        System.out.println("게임 성공 여부: " + result);
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTryNumber());
    }
}
