package view;

import dto.GameResult;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.enums.MoveResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String GAME_INIT_COMMENT = "다리 건너기 게임을 시작합니다.";
    private final String FINAL_RESULT_COMMENT = "최종 게임 결과";
    private final String SUCCESS_FORMAT = "게임 성공 여부: %s";
    private final String TOTAL_TRY_COUNT_FORMAT = "총 시도한 횟수: %d";
    private final Map<Boolean, String> successMapper = Map.of(false, "실패", true, "성공");
    private final String ERROR_FORMAT = "[ERROR] %s";

    public void printInitComment(){
        System.out.println(GAME_INIT_COMMENT);
        System.out.println();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        List<List<MoveResult>> bridgeMoveResults = gameResult.getMoveResult();

        for (int i = bridgeMoveResults.size() - 1 ; i >= 0 ; i--) {
            System.out.println(getFormattedRow(bridgeMoveResults.get(i)));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_COMMENT);
        printMap(gameResult);

        System.out.println(String.format(SUCCESS_FORMAT, successMapper.get(gameResult.getStatus().succeed())));
        System.out.println(String.format(TOTAL_TRY_COUNT_FORMAT, gameResult.getTryCount()));
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT, message));
    }

    private String getFormattedRow(List<MoveResult> rowMoveResults) {
        StringBuilder builder = new StringBuilder("[ ");
        builder.append(String.join(" | ", rowMoveResults.stream().map((moveResult) -> moveResult.getStringValue())
                .collect(Collectors.toUnmodifiableList())));
        builder.append(" ]");
        return builder.toString();
    }


}
