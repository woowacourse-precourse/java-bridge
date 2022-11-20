package bridge.view;

import bridge.dto.MapDto;
import bridge.dto.ResultDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String TRUE = " O ";
    private static final String FALSE = " X ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = "   ";
    private static final String DIVIDER = "|";
    private static final String START_MAP = "[";
    private static final String END_MAP = "]";
    private static final String NEW_LINE = "\n";
    private static final String RESULT_TITLE_MESSAGE = "최종 게임 결과";
    private static final String IS_SUCCESSFUL_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 1;

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapDto mapDto) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        List<String> bridge = mapDto.getBridge();
        List<Boolean> result = mapDto.getResult();
        for (int i = 0; i < result.size(); i++) {
            up.append(makeUpMap(result.get(i), bridge.get(i)));
            down.append(makeDownMap(result.get(i), bridge.get(i)));
        }
        System.out.println(makeBothEnds(up) + makeBothEnds(down));
    }

    private String makeBothEnds(StringBuilder oneBridge) {
        oneBridge.insert(FIRST_INDEX, START_MAP);
        oneBridge.deleteCharAt(oneBridge.length() - LAST_INDEX);
        oneBridge.append(END_MAP).append(NEW_LINE);
        return String.valueOf(oneBridge);
    }

    private String makeUpMap(boolean result, String moving) {
        if (moving.equals(UP) && result || !moving.equals(UP) && !result) {
            return getResultMessage(result) + DIVIDER;
        }
        return BLANK + DIVIDER;
    }

    private String makeDownMap(boolean result, String moving) {
        if (moving.equals(DOWN) && result || !moving.equals(DOWN) && !result) {
            return getResultMessage(result) + DIVIDER;
        }
        return BLANK + DIVIDER;
    }

    private String getResultMessage(boolean result) {
        if (result) {
            return TRUE;
        }
        return FALSE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ResultDto resultDto) {
        System.out.println(RESULT_TITLE_MESSAGE);
        printMap(resultDto.getMapDto());
        System.out.println(IS_SUCCESSFUL_MESSAGE + getSuccessMessage(resultDto.isSuccess()));
        System.out.println(TRY_COUNT_MESSAGE + resultDto.getTryCount());
    }

    private String getSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS_MESSAGE;
        }
        return FAIL_MESSAGE;
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
        System.out.println();
    }
}
