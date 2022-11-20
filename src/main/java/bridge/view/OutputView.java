package bridge.view;

import bridge.type.GameStatusType;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String mapStarter = "[ ";
    private static final String mapFinisher = " ]";
    private static final String mapSeparator = " | ";

    public void printMap(List<List<String>> playingMap) {
        for (List<String> playingBridge : playingMap) {
            String bridgeMap = toStringOf(playingBridge);
            System.out.println(bridgeMap);
        }
        System.out.println();
    }

    public void printResult(List<List<String>> playingMap, GameStatusType gameStatusType, int gameCount) {
        System.out.println("최종 게임 결과");
        printMap(playingMap);
        System.out.println("게임 성공 여부: " + gameStatusType.toString());
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    private String toStringOf(List<String> playingBridge) {
        StringJoiner stringJoiner = new StringJoiner(mapSeparator, mapStarter, mapFinisher);
        for (String result : playingBridge) {
            stringJoiner.add(result);
        }
        return stringJoiner.toString();
    }
}
