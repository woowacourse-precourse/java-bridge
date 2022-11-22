package ui;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String GAME_SUCCESS_RESULT = "게임 성공 여부: ";
    private final String BLOCK_START = "[";
    private final String BLOCK_END = "]";
    private final String BLOCK_SEP = "|";
    // 게임 성공, 실패는 ENUM으로 관리하도록 고려할 것.
    private final Map<Boolean, String> GAME_RESULT = Map.of(true, "성공",
            false, "실패");
    private final String GAME_TRY = "총 시도한 횟수: ";
    private final String FINAL_GAME_MAP = "최종 게임 결과";

    public void printMap(List<List<Integer>> map) {
        printOneLine(map.get(0));
        printOneLine(map.get(1));
        System.out.println();
    }
    private void printOneLine(List<Integer> line) {
        System.out.print(BLOCK_START);
        for (int i = 0; i < line.size(); i++) {
            printBlock(line.get(i));
            if (i != line.size() - 1) {
                System.out.print(BLOCK_SEP);
            }
        }
        System.out.println(BLOCK_END);
    }
    private void printBlock(final int index) {
        System.out.print(" " + Block.getMessage(index) + " ");
    }

    public void printResult(final boolean result) {
        System.out.println(GAME_SUCCESS_RESULT + GAME_RESULT.get(result));
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameTryResultMessage(int userTry) {
        System.out.println(GAME_TRY + userTry);
    }
    private void printFinalGameMapMessage(){
        System.out.println(FINAL_GAME_MAP);
    }
    public void printFinalGameMap(List<List<Integer>> map){
        printFinalGameMapMessage();
        printMap(map);
    }
}
