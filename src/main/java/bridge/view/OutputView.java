package bridge.view;

import bridge.dto.PrintMapDto;
import bridge.dto.PrintResultDto;
import bridge.type.BridgeSpaceStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String STARTING_PHRASE = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_PHRASE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE_PHRASE = "게임 성공 여부: ";
    private static final String ATTEMPT_COUNT_PHRASE = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    public static void printStart() {
        System.out.println(STARTING_PHRASE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(PrintMapDto map) {
        printLayer(map, BridgeSpaceStatus.UP.getLetter());
        printLayer(map, BridgeSpaceStatus.DOWN.getLetter());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(PrintResultDto result) {
        System.out.println(RESULT_PHRASE);
        printMap(new PrintMapDto(result.getSequence(), result.isSuccess(), result.getIndex()));
        printSuccessOrFailure(result.isSuccess());
        printAttemptCount(result.getAttemptCount());
    }

    private static void printSuccessOrFailure(boolean isSuccess) {
        System.out.print(SUCCESS_OR_FAILURE_PHRASE);
        if (isSuccess) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAILURE);
    }

    private static void printAttemptCount(int attemptCount) {
        System.out.println(ATTEMPT_COUNT_PHRASE + attemptCount);
    }

    private static void printLayer(PrintMapDto map, String letter) {
        System.out.print("[ ");
        printSequence(map, letter);
        System.out.print(" ]\n");
    }

    private static void printSequence(PrintMapDto map, String letter) {
        for (int i = 0; i < map.getIndex(); i++) {
            if (map.getSequence().get(i).equals(letter)) {
                System.out.print("O | ");
                continue;
            }
            System.out.print("  | ");
        }
        System.out.print(getLastLetter(map, letter));
    }

    private static String getLastLetter(PrintMapDto map, String letter) {
        if (map.getSequence().get(map.getIndex()).equals(letter) && map.isPossible()) {
            return "O";
        }
        if (!map.getSequence().get(map.getIndex()).equals(letter) && !map.isPossible()) {
            return "X";
        }
        return " ";
    }
}
