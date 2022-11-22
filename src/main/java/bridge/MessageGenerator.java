package bridge;

import bridge.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageGenerator {

    private static final MessageGenerator instance = new MessageGenerator();
    private static final String START_SIGN = "[";
    private static final String END_SIGN = "]";
    private static final String DELIMITER = "|";
    private static final String THREE_BLANK = "   ";

    public static final String GAME_FINISH_HEADER_MSG = "최종 게임 결과";
    public static final String GAME_FINISH_RESULT_SUCCESS_MSG = "게임 성공 여부: 성공";
    public static final String GAME_FINISH_RESULT_FAIL_MSG = "게임 성공 여부: 실패";
    public static final String GAME_FINISH_TOTAL_TRY_MSG = "총 시도한 횟수: ";

    private MessageGenerator() {
    }

    public static MessageGenerator getInstance() {
        return instance;
    }

    private List<List<String>> getInitCheckBoard(int checkCount) {
        List<List<String>> defaultBridge = new ArrayList<>();
        for (int directionCount = 0; directionCount < Direction.getNumOfDirections(); directionCount++) {
            List<String> defaultLayer = new ArrayList<>();
            for (int sectionCount = 0; sectionCount < checkCount; sectionCount++) {
                defaultLayer.add(THREE_BLANK);
            }
            defaultBridge.add(defaultLayer);
        }
        return defaultBridge;
    }

    private List<String> convertToMapImage(List<List<String>> formattedMap) {
        return formattedMap.stream()
                .map((List<String> layer) ->
                        START_SIGN + String.join(DELIMITER, layer) + END_SIGN
                )
                .collect(Collectors.toList());
    }
}
