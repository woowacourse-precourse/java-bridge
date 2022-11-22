package bridge.view;

import bridge.domain.Step;
import bridge.dto.GameResultDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String SUCCESS_MARKER = " O ";
    private static final String FAILURE_MARKER = " X ";
    private static final String EMPTY_MARKER = "   ";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String BAR = "|";
    private static final String NEW_LINE = System.lineSeparator();

    private static final String MSG_FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String MSG_GAME_SUCCESS_RESULT = "게임 성공 여부: %s" + NEW_LINE;
    private static final String MSG_TOTAL_TRY_COUNT = "총 시도한 횟수: %d" + NEW_LINE;
    ;
    private StringBuilder upRow;
    private StringBuilder downRow;

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultDto gameResultDto) {
        System.out.println(MSG_FINAL_GAME_RESULT);
        printMap(gameResultDto);
        System.out.println();
        System.out.printf(MSG_GAME_SUCCESS_RESULT, gameResultDto.getGameStatus().getGameStatusMessage());
        System.out.printf(MSG_TOTAL_TRY_COUNT, gameResultDto.getGameCount());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResultDto gameResultDto) {
        initStringBuilder();
        printGame(gameResultDto);
        concat();
        System.out.println(upRow.toString());
    }

    private void initStringBuilder() {
        upRow = new StringBuilder();
        downRow = new StringBuilder();
    }

    private void printGame(GameResultDto gameResultDto) {
        printer(START_BRACKET);
        printSuccess(gameResultDto.getSuccessSteps());
        printFailStep(gameResultDto.getFailStep());
        printer(END_BRACKET);
    }

    private void printer(String marker) {
        upRow.append(marker);
        downRow.append(marker);
    }

    private void printSuccess(List<Step> successSteps) {
        for (Step successStep : successSteps) {
            printRow(successStep, SUCCESS_MARKER);
            printer(BAR);
        }
    }

    private void printRow(Step userStep, String marker) {
        if (userStep.equals(Step.UP)) {
            printColumn(marker, EMPTY_MARKER);
        }
        if (userStep.equals(Step.DOWN)) {
            printColumn(EMPTY_MARKER, marker);
        }
    }

    private void printColumn(String upMarker, String downMarker) {
        upRow.append(upMarker);
        downRow.append(downMarker);
    }

    private void printFailStep(Step failStep) {
        if (failStep != null) {
            printRow(failStep, FAILURE_MARKER);
            return;
        }
        deleteLastSection();
    }

    private void deleteLastSection() {
        upRow.deleteCharAt(upRow.length() - 1);
        downRow.deleteCharAt(downRow.length() - 1);
    }

    private void concat() {
        upRow.append(NEW_LINE);
        upRow.append(downRow);
    }
}
