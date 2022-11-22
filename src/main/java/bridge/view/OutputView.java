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

import bridge.model.GameStatus;
import bridge.model.constant.MoveDirection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final List<MoveDirection> displayOrder = List.of(MoveDirection.UP, MoveDirection.DOWN);

    private final Map<Boolean, String> gameSuccessMapper = Map.of(
            true, GAME_SUCCESS_COMMENT.getValue(),
            false, GAME_FAIL_COMMENT.getValue());

    private final Function<Boolean, String> moveResultSymbolMapper = (moveSuccess) -> {
        if (moveSuccess == null) {
            return BLANK_SYMBOL.getValue();
        }

        if (moveSuccess == true) {
            return MOVE_SUCCESS_SYMBOL.getValue();
        }

        return MOVE_FAIL_SYMBOL.getValue();
    };

    public void printInitComment() {
        System.out.println(GAME_INIT_COMMENT.getValue());
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameStatus gameStatus) {
        for (MoveDirection moveDirection : displayOrder) {
            List<String> rowMoveResults = getRowMoveResults(moveDirection, gameStatus);
            System.out.println(getFormattedRow(rowMoveResults));
        }
        System.out.println();
    }

    private String getFormattedRow(List<String> rowMoveResult) {
        return String.format(ROW_MOVE_RESULT_FORMAT.getValue(), String.join(SYMBOL_PARSER.getValue(), rowMoveResult));

    }

    private List<String> getRowMoveResults(MoveDirection row, GameStatus gameStatus) {
        List<MoveDirection> moveDirections = gameStatus.getMoveDirections();
        List<String> rowMoveResults = IntStream.range(0, moveDirections.size())
                .mapToObj((index) -> moveResultSymbolMapper.apply(gameStatus.successMove(index, row)))
                .collect(Collectors.toUnmodifiableList());

        return rowMoveResults;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus) {
        System.out.println(FINAL_RESULT_COMMENT.getValue());
        printMap(gameStatus);

        System.out.println(String.format(SUCCESS_FORMAT.getValue(), gameSuccessMapper.get(gameStatus.fail() != true)));
        System.out.println(String.format(TOTAL_TRY_COUNT_FORMAT.getValue(), gameStatus.tryCount()));
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT.getValue(), message));
    }
}
