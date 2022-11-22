package bridge.views;

import bridge.identifiers.Direction;
import bridge.paths.PlayerPath;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView extends DefaultView{

    public static final String FORMAT_ERROR_MESSAGE = "[ERROR] {0}";
    private static final String FORMAT_MAP = "[ {0} ]";
    private static final String FORMAT_MAP_DELIMITER = " | ";
    private static final String FORMAT_WHETHER_SUCCESS = "게임 성공 여부: {0}";
    private static final String FORMAT_ATTEMPT_COUNT = "총 시도한 횟수: {0}";
    private static final String MSG_WELCOME = "다리 건너기 게임을 시작합니다.";
    private static final String MSG_CORRECT_DIRECTION = "O";
    private static final String MSG_WRONG_DIRECTION = "X";
    private static final String MSG_NONE_DIRECTION = " ";
    private static final String MSG_FINAL_RESULT = "최종 게임 결과";
    private static final String MSG_GAME_SUCCESS = "성공";
    private static final String MSG_GAME_FAILURE = "실패";

    public void printErrorMessage(String message) {
        output(MessageFormat.format(
                FORMAT_ERROR_MESSAGE,
                message
        ));
    }

    public void printWelcome() {
        output(MSG_WELCOME);
        printLineSeparator();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PlayerPath playerPath) {
        Map<Direction, List<String>> messageParts
                = makeMessagePartsByDirection(playerPath.getPath(), playerPath.getIsAlive());
        output(applyMapFormat(messageParts.get(Direction.UP)));
        output(applyMapFormat(messageParts.get(Direction.DOWN)));
        printLineSeparator();
    }

    private Map<Direction, List<String>> makeMessagePartsByDirection(List<Direction> playerPath, boolean isGameOver){
        int pathLength = playerPath.size();
        Map<Direction, List<String>> messageParts = new HashMap<>();
        messageParts.put(Direction.UP, makeNoneDirections(pathLength));
        messageParts.put(Direction.DOWN, makeNoneDirections(pathLength));

        for (int index = 0; index < pathLength; ++index) {
            modifyPathMessageParts(playerPath.get(index), isGameOver, pathLength, messageParts, index);
        }

        return messageParts;
    }


    private void modifyPathMessageParts(Direction direction, boolean isAlive, int pathLength, Map<Direction, List<String>> messageParts, int index) {
        if (pathLength - 1 == index) {
            if (!isAlive) {
                messageParts.get(direction).set(index, MSG_WRONG_DIRECTION);
                return;
            }
        }
        messageParts.get(direction).set(index, MSG_CORRECT_DIRECTION);
    }

    private String applyMapFormat(List<String> messageParts){
        return MessageFormat.format(
                FORMAT_MAP,
                messageParts.stream().collect(Collectors.joining(FORMAT_MAP_DELIMITER))
                );
    }


    private List<String> makeNoneDirections(int size) {
        List<String> directions = new ArrayList<>(size);
        for (int index = 0; index < size; ++index) {
            directions.add(MSG_NONE_DIRECTION);
        }
        return directions;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(PlayerPath playerPath, boolean isSuccess) {
        output(MSG_FINAL_RESULT);
        printMap(playerPath);
        output(makeWhetherSuccessMessage(isSuccess));
        output(makeAttemptCountMessage(playerPath.getOrdinalNumber()));
    }

    private String makeWhetherSuccessMessage(boolean isSuccess){
        String messagePart_isSuccess = MSG_GAME_FAILURE;
        if(isSuccess){
            messagePart_isSuccess = MSG_GAME_SUCCESS;
        }
        return MessageFormat.format(
                FORMAT_WHETHER_SUCCESS,
                messagePart_isSuccess
        );
    }

    private String makeAttemptCountMessage(int countAttempt){
        return MessageFormat.format(
                FORMAT_ATTEMPT_COUNT,
                countAttempt
        );
    }
}
