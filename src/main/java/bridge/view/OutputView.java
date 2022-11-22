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
        int lengthBeforeSquareBracket = map[selectedIndex].length() - 1;

        if (position == FIRST) {
            makeFirstMap(movingResult, selectedIndex, notSelectedIndex);
            return;
        }
        map[selectedIndex] = map[selectedIndex].substring(0, lengthBeforeSquareBracket) + INFIX + movingResult + SUFFIX;
        map[notSelectedIndex] = map[notSelectedIndex].substring(0, lengthBeforeSquareBracket) + INFIX + " " + SUFFIX;
    }

    private void makeFirstMap(String movingResult, int selectedIndex, int notSelectedIndex) {
        map[selectedIndex] = PREFIX + movingResult + SUFFIX;
        map[notSelectedIndex] = PREFIX + " " + SUFFIX;
    }

    public void printResult() {
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
}
