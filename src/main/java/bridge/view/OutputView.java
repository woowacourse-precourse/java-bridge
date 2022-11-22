package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.utils.Converter;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String PREFIX = "[ ";
    private static final String INFIX = "| ";
    private static final String SUFFIX = " ]";
    private static final int FIRST = 0;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private static String[] map = new String[Moving.values().length];

    public void printMap(int position, String moving, boolean isAnswer) {
        String movingResult = Converter.convertToOX(isAnswer);
        int selectedIndex = Converter.convertToIndex(moving);

        makeMap(position, movingResult, selectedIndex);

        printCurrentMap();
    }

    public void printCurrentMap() {
        for (String compartment : map) {
            System.out.println(compartment);
        }
        System.out.println();
    }

    private void makeMap(int position, String movingResult, int selectedIndex) {
        int notSelectedIndex = 1 - selectedIndex;
        if (position == FIRST) {
            makeFirstMap(movingResult, selectedIndex, notSelectedIndex);
            return;
        }
        int lengthBeforeSquareBracket = map[selectedIndex].length() - 1;
        map[selectedIndex] = map[selectedIndex].substring(0, lengthBeforeSquareBracket) + INFIX + movingResult + SUFFIX;
        map[notSelectedIndex] = map[notSelectedIndex].substring(0, lengthBeforeSquareBracket) + INFIX + " " + SUFFIX;
    }

    private void makeFirstMap(String movingResult, int selectedIndex, int notSelectedIndex) {
        map[selectedIndex] = PREFIX + movingResult + SUFFIX;
        map[notSelectedIndex] = PREFIX + " " + SUFFIX;
    }

    public void printResult(boolean isGameSuccess, int trialCount) {
        System.out.println("최종 게임 결과");
        printCurrentMap();
        printWhetherGameSuccess(isGameSuccess);
        printTrialCount(trialCount);
    }

    private void printWhetherGameSuccess(boolean isGameSuccess) {
        System.out.print("게임 성공 여부: ");
        if (isGameSuccess) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAIL);
    }

    private void printTrialCount(int trialCount) {
        System.out.println("총 시도한 횟수: " + trialCount);
    }

    public void printGameStartNotice() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printBridgeSizeInputNotice() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingInputNotice() {
        String up = Moving.UP.getCommand();
        String Down = Moving.DOWN.getCommand();
        System.out.println("이동할 칸을 선택해주세요. (위: " + up + ", 아래: " + Down + ")");
    }

    public void printGameCommandInputNotice() {
        String restart = GameCommand.RESTART.getCommand();
        String quit = GameCommand.QUIT.getCommand();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + restart + ", 종료: " + quit + ")");
    }

    public void initializeMap() {
        map = new String[Moving.values().length];
    }
}
