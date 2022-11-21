package bridge.view;

import bridge.standard.Rule;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String EMPTY_LINE = "";
    private static final String GUIDE_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String GUIDE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String GUIDE_INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GUIDE_INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";

    private static final String MAP_START = "[ ";
    private static final String MAP_SEPARATOR = " | ";
    private static final String MAP_END = " ]\n";

    public void emptyLine() {
        System.out.println(EMPTY_LINE);
    }

    public void guideStart() {
        System.out.println(GUIDE_START);
    }

    public void guideInputBridgeSize() {
        System.out.println(GUIDE_INPUT_BRIDGE_SIZE);
    }

    public void guideInputMoving() {
        System.out.println(GUIDE_INPUT_MOVING);
    }

    public void guideInputGameCommand() {
        System.out.println(GUIDE_INPUT_GAME_COMMAND);
    }

    public void printMap(List<List<String>> positions) {
        System.out.println(transFromToMap(positions));
    }

    public void printResult(List<List<String>> positions, int numberOfAttempts, String outcome) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(transFromToMap(positions));
        System.out.println(SUCCESS_OR_NOT + outcome);
        System.out.println(NUMBER_OF_ATTEMPTS + numberOfAttempts);
    }

    private String transFromToMap(List<List<String>> positions) {
        String map;
        StringJoiner upStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        StringJoiner downStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        for (List<String> position : positions) {
            upStairMap.add(position.get(Rule.UP_LAYER));
            downStairMap.add(position.get(Rule.DOWN_LAYER));
        }
        map = upStairMap + downStairMap.toString();
        return map;
    }

}