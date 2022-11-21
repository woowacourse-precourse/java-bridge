package bridge.view;

import static bridge.message.OutputMessage.BLANK_SYMBOL;
import static bridge.message.OutputMessage.ERROR_FORMAT;
import static bridge.message.OutputMessage.FINAL_RESULT_COMMENT;
import static bridge.message.OutputMessage.GAME_FAIL_COMMENT;
import static bridge.message.OutputMessage.GAME_INIT_COMMENT;
import static bridge.message.OutputMessage.GAME_SUCCESS_COMMENT;
import static bridge.message.OutputMessage.MOVE_FAIL_SYMBOL;
import static bridge.message.OutputMessage.MOVE_SUCCESS_SYMBOL;
import static bridge.message.OutputMessage.ROW_MOVE_RESULT_FORMAT;
import static bridge.message.OutputMessage.SUCCESS_FORMAT;
import static bridge.message.OutputMessage.SYMBOL_PARSER;
import static bridge.message.OutputMessage.TOTAL_TRY_COUNT_FORMAT;

import bridge.dto.GameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import bridge.model.MoveInformation;
import bridge.model.enums.MoveChoice;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final Map<Boolean, String> gameSuccessMapper = Map.of(false, GAME_FAIL_COMMENT.toString(), true, GAME_SUCCESS_COMMENT.toString());
    private final Map<Boolean, String> moveSuccessMapper = Map.of(false, MOVE_FAIL_SYMBOL.toString(), true, MOVE_SUCCESS_SYMBOL.toString());


    public void printInitComment() {
        System.out.println(GAME_INIT_COMMENT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        List<String> formattedMap = getFormattedMap(gameResult.getBridgeMoveInformation());

        for (int i = formattedMap.size() - 1; i >= 0; i--) {
            System.out.println(formattedMap.get(i));
        }
        System.out.println();
    }

    private List<String> getFormattedMap(List<MoveInformation> bridgeMoveInformation) {
        List<String> formattedMap = new ArrayList<>();
        for (int i = 0; i < MoveChoice.values().length; i++) {
            formattedMap.add(getFormattedRow(i, bridgeMoveInformation));
        }
        return formattedMap;
    }
    private String getFormattedRow(int row, List<MoveInformation> bridgeMoveInformation) {
        List<String> formattedRow = new ArrayList<>();

        for (int i = 0; i < bridgeMoveInformation.size(); i++) {
            if (bridgeMoveInformation.get(i).getRow() == row) {
                formattedRow.add(moveSuccessMapper.get(bridgeMoveInformation.get(i).moveSucceed()));
                continue;
            }
            formattedRow.add(BLANK_SYMBOL.toString());
        }
        return String.format(ROW_MOVE_RESULT_FORMAT.toString(),String.join(SYMBOL_PARSER.toString(), formattedRow));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_COMMENT);
        printMap(gameResult);

        System.out.println(String.format(SUCCESS_FORMAT.toString(), gameSuccessMapper.get(gameResult.succeed())));
        System.out.println(String.format(TOTAL_TRY_COUNT_FORMAT.toString(), gameResult.tryCount()));
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT.toString(), message));
    }
}
