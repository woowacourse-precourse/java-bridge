package bridge.domain;

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
    private static final String ONE_BLANK = " ";

    public static final String GAME_FINISH_HEADER_MSG = "최종 게임 결과";
    public static final String GAME_FINISH_RESULT_SUCCESS_MSG = "게임 성공 여부: 성공";
    public static final String GAME_FINISH_RESULT_FAIL_MSG = "게임 성공 여부: 실패";
    public static final String GAME_FINISH_TOTAL_TRY_MSG = "총 시도한 횟수: ";

    public static final String GAME_START_HEADER_MSG = "다리 건너기 게임을 시작합니다.";
    public static final String GAME_ASK_BRIDGE_SIZE_MSG = "다리의 길이를 입력해주세요.";
    public static final String GAME_ASK_DIRECTION_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_ASK_RETRY_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private MessageGenerator() {
    }

    public static MessageGenerator getInstance() {
        return instance;
    }

    public List<String> getMapImage(BridgeGame bridgeGame) {
        List<List<String>> formattedMapData = getFormattedMapData(bridgeGame.getChecks());

        return convertToMapImage(formattedMapData);
    }

    private List<List<String>> getFormattedMapData(List<Check> checks) {
        List<List<String>> checkBoard = getInitCheckBoard(checks.size());
        for (int checkIndex = 0; checkIndex < checks.size(); checkIndex++) {
            Check check = checks.get(checkIndex);
            Integer code = Direction.getCodeByAbbr(check.getGuess());
            checkBoard.get(code).set(checkIndex, ONE_BLANK + check.getResult() + ONE_BLANK);
        }
        return checkBoard;
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
