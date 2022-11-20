package bridge.view;

import bridge.type.GameStatusType;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String mapStarter = "[ ";
    private static final String mapFinisher = " ]";
    private static final String mapSeparator = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> playingMap) {
        for (List<String> playingBridge : playingMap) {
            String bridgeMap = toStringOf(playingBridge);
            System.out.println(bridgeMap);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> playingMap, GameStatusType gameStatusType, int gameCount) {
        System.out.println("최종 게임 결과");
        printMap(playingMap);
        System.out.println();
        System.out.println("게임 성공 여부: " + gameStatusType.toString());
        System.out.println("총 시도한 횟수: "+ gameCount);
    }

    private static String toStringOf(List<String> playingBridge) {
        StringJoiner stringJoiner = new StringJoiner(mapSeparator, mapStarter, mapFinisher);
        for (String result : playingBridge) {
            stringJoiner.add(result);
        }
        return stringJoiner.toString();
    }
}
