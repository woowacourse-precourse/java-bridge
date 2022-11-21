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

import bridge.model.GameResult;
import bridge.model.constant.MoveChoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final List<MoveChoice> displayOrder = List.of(MoveChoice.UP, MoveChoice.DOWN);
    private final Map<Boolean, String> gameSuccessMapper = Map.of(false, GAME_FAIL_COMMENT.getValue(), true,
            GAME_SUCCESS_COMMENT.getValue());
    private final Map<Boolean, String> moveSuccessMapper = Map.of(false, MOVE_FAIL_SYMBOL.getValue(), true,
            MOVE_SUCCESS_SYMBOL.getValue());


    public void printInitComment() {
        System.out.println(GAME_INIT_COMMENT.getValue());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        for(MoveChoice moveChoice : displayOrder){
            System.out.println(getFormattedRow(moveChoice, gameResult.getMoveChoices(),gameResult.succeed()));
        }
        System.out.println();
    }

    private String getFormattedRow(MoveChoice userMoveChoice, List<MoveChoice> moveChoices, boolean succeed) {
        List<String> formattedRow = new ArrayList<>();

        for(MoveChoice choice : moveChoices){
            if(userMoveChoice == choice){
                formattedRow.add(moveSuccessMapper.get(succeed || formattedRow.size() != moveChoices.size() - 1));
                continue;
            }
            formattedRow.add(BLANK_SYMBOL.getValue());
        }
        return String.format(ROW_MOVE_RESULT_FORMAT.getValue(), String.join(SYMBOL_PARSER.getValue(), formattedRow));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_COMMENT.getValue());
        printMap(gameResult);

        System.out.println(String.format(SUCCESS_FORMAT.getValue(), gameSuccessMapper.get(gameResult.succeed())));
        System.out.println(String.format(TOTAL_TRY_COUNT_FORMAT.getValue(), gameResult.tryCount()));
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT.getValue(), message));
    }
}
