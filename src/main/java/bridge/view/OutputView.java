package bridge.view;

import bridge.command.Movement;
import bridge.command.Retry;
import bridge.path.Path;
import bridge.path.Result;

import java.util.EnumMap;
import java.util.Map;

public class OutputView {

    private static final String MESSAGE_TITLE = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_MOVING = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private static final String MESSAGE_RETRYING = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";
    private static final String MESSAGE_RESULT_HEADER = "최종 게임 결과";
    private static final String MESSAGE_RESULT_FOOTER = "게임 성공 여부: %s\n총 시도한 횟수: %d";

    private static final EnumMap<Result, String> format = new EnumMap<>(
            Map.ofEntries(
                    Map.entry(Result.PREFIX, "[ "),
                    Map.entry(Result.SUFFIX, " ]"),
                    Map.entry(Result.DELIMITER, " | "),
                    Map.entry(Result.O, "O"),
                    Map.entry(Result.X, "X"),
                    Map.entry(Result.UNSELECTED, " ")
            )
    );

    public void printTitle() {
        System.out.println(MESSAGE_TITLE);
        System.out.println();
    }

    public void printBridgeSize() {
        System.out.println(MESSAGE_BRIDGE_SIZE);
    }

    public void printMoving() {
        System.out.printf(MESSAGE_MOVING, Movement.UP.getCommand(), Movement.DOWN.getCommand());
        System.out.println();
    }

    public void printMap(final Path path) {
        System.out.println(path.format(format));
        System.out.println();
    }

    public void printRetrying() {
        System.out.printf(MESSAGE_RETRYING, Retry.YES.getCommand(), Retry.NO.getCommand());
        System.out.println();
    }

    public void printResult(
            final Path path,
            final int numTry
    ) {
        System.out.println(MESSAGE_RESULT_HEADER);
        printMap(path);
        System.out.printf(MESSAGE_RESULT_FOOTER, decision(path), numTry);
    }

    private String decision(Path path) {
        if (path.searchesFailed()) {
            return "실패";
        }
        return "성공";
    }
}
