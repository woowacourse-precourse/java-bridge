package bridge.view;

import java.util.List;

import static bridge.enums.OutputMsg.*;

public class OutputView {

    public void printStart() {
        System.out.println(MSG_OUTPUT_START_GAME.get());
    }

    public void printMap(List<String> eitherSideProgress) {
        int size = eitherSideProgress.size();

        System.out.print(OPEN_BRACKET.get());
        for (int iter = 0; iter < size; iter++) {
            System.out.print(eitherSideProgress.get(iter));
            if (iter + 1 != size) {
                System.out.print(PARTITION.get());
            }
        }
        System.out.println(CLOSE_BRACKET.get());
    }

    public void printResult(List<String> upSideProgress, List<String> downSideProgress) {
        System.out.println(LINE_BREAK.get() + MSG_OUTPUT_END_GAME.get());
        printMap(upSideProgress);
        printMap(downSideProgress);
    }

    public void printStatus(String gameStatus, int tryAttempt) {
        System.out.println(LINE_BREAK.get() + MSG_OUTPUT_GAME_RESULT.get() + gameStatus);
        System.out.println(MSG_OUTPUT_TRY_ATTEMPT.get() + tryAttempt);
    }
}
