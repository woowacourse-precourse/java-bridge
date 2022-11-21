package bridge.view;

import bridge.GameStatus;
import bridge.MovementType;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String BLANK = "   |";
    public static final String O = " O |";
    public static final String X = " X |";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> realBridges, List<String> selectBridges) {
        String map = makeMaps(realBridges, selectBridges);
        System.out.println(map);
    }

    public String makeMaps(List<String> realBridges, List<String> selectBridges) {
        List<StringBuilder> maps = List.of(new StringBuilder(), new StringBuilder());
        for (int index = 0; index < selectBridges.size(); index++) {
            String selectBridge = selectBridges.get(index);
            String realBridge = realBridges.get(index);
            updateMaps(maps, realBridge, selectBridge);
        }
        return convertStringBuilderListToString(maps);
    }

    private static void updateMaps(List<StringBuilder> maps, String realBridge, String selectBridge) {
        if (selectBridge.equals(MovementType.UP.getCode())) {
            updateUpMap(maps, realBridge, selectBridge);
            return;
        }
        updateDownMap(maps, realBridge, selectBridge);
    }

    private static void updateUpMap(List<StringBuilder> maps, String realBridge, String selectBridge) {
        StringBuilder up = maps.get(MovementType.UP.getIndex());
        StringBuilder down = maps.get(MovementType.DOWN.getIndex());
        if (realBridge.equals(selectBridge)) {
            up.append(O);
            down.append(BLANK);
            return;
        }
        up.append(X);
        down.append(BLANK);
    }

    private static void updateDownMap(List<StringBuilder> maps, String realBridge, String selectBridge) {
        StringBuilder up = maps.get(MovementType.UP.getIndex());
        StringBuilder down = maps.get(MovementType.DOWN.getIndex());
        if (realBridge.equals(selectBridge)) {
            down.append(O);
            up.append(BLANK);
            return;
        }
        down.append(X);
        up.append(BLANK);
    }

    private static String convertStringBuilderListToString(List<StringBuilder> maps) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(maps.get(MovementType.UP.getIndex()));
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "]");
        stringBuilder.append("\n[");
        stringBuilder.append(maps.get(MovementType.DOWN.getIndex()));
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "]");
        return stringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus, List<String> realBridges, List<String> selectBridges) {
        System.out.println("\n최종 게임 결과");
        printMap(realBridges, selectBridges);
        if (gameStatus.isSuccess()) {
            System.out.println("\n게임 성공 여부: 성공\n총 시도한 횟수: " + gameStatus.getTryCount());
            return;
        }
        System.out.println("\n게임 성공 여부: 실패\n총 시도한 횟수: " + gameStatus.getTryCount());
    }
}
