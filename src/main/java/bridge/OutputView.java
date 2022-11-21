package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        List<List<String>> map = makeMap(bridge);

        String upMap = format(map.get(0));
        String downMap = format(map.get(1));

        System.out.println(upMap);
        System.out.println(downMap);
        System.out.println();
    }

    private List<List<String>> makeMap(Bridge bridge) {
        List<List<String>> map = makeDefaultMap(2);
        for (int col = 0; col < bridge.getMoveTrace().size(); ++col) {
            String nowBridgeShape = bridge.getBridgeShape().get(col);
            String nowMoveTrace = bridge.getMoveTrace().get(col);

            map.get(0).add(decideNowMap("U", nowBridgeShape, nowMoveTrace));
            map.get(1).add(decideNowMap("D", nowBridgeShape, nowMoveTrace));
        }
        return map;
    }

    private String decideNowMap(String direction, String nowBridgeShape, String nowMoveTrace) {
        if (!nowMoveTrace.equals(direction))
            return " ";
        if (nowBridgeShape.equals(nowMoveTrace))
            return "O";
        return "X";
    }

    private List<List<String>> makeDefaultMap(int rowSize) {
        return Stream.generate(ArrayList<String>::new)
                .limit(rowSize)
                .collect(Collectors.toList());
    }

    private String format(List<String> strings) {
        String ret = "";
        String joinedStrings = strings.stream()
                .collect(Collectors.joining(" | "));
        return ret.concat("[ ").concat(joinedStrings).concat(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge) {
        System.out.println("최종 게임 결과");
        printMap(bridge);
        System.out.println(makeResultString(bridge));
        System.out.println("총 시도한 횟수: " + bridge.getAttemptNumber());
    }

    private String makeResultString(Bridge bridge) {
        if (bridgeGame.isClearGame(bridge))
            return "게임 성공 여부: 성공";
        return "게임 성공 여부: 실패";
    }
}
