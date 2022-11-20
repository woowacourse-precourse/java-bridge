package view;

import dto.GameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.MoveInformation;
import model.enums.MoveChoice;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String GAME_INIT_COMMENT = "다리 건너기 게임을 시작합니다.";
    private final String FINAL_RESULT_COMMENT = "최종 게임 결과";
    private final String SUCCESS_FORMAT = "게임 성공 여부: %s";
    private final String TOTAL_TRY_COUNT_FORMAT = "총 시도한 횟수: %d";
    private final String ROW_MOVE_RESULT_FORMAT = "[ %s ]";
    private final Map<Boolean, String> gameSuccessMapper = Map.of(false, "실패", true, "성공");
    private final Map<Boolean, String> moveSuccessMapper = Map.of(false, "X", true, "O");
    private final String BLANK = " ";
    private final String ERROR_FORMAT = "[ERROR] %s";


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
            formattedRow.add(BLANK);
        }
        return String.format(ROW_MOVE_RESULT_FORMAT,String.join(" | ", formattedRow));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_COMMENT);
        printMap(gameResult);

        System.out.println(String.format(SUCCESS_FORMAT, gameSuccessMapper.get(gameResult.getStatus().succeed())));
        System.out.println(String.format(TOTAL_TRY_COUNT_FORMAT, gameResult.getTryCount()));
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT, message));
    }
}
