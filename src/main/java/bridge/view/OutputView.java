package bridge.view;

import bridge.Constants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void printGameStart(){
        System.out.println(OutputMessage.GAME_START.message());
    }

    public void printMap(List<String> moves, boolean isFail) {
        List<String> upperMap = partialMap(moves, isFail, Constants.CODE_UP);
        List<String> lowerMap = partialMap(moves, isFail, Constants.CODE_DOWN);

        System.out.println(Map.START.code() + String.join(Map.JOIN.code(), upperMap) + Map.END.code());
        System.out.println(Map.START.code() + String.join(Map.JOIN.code(), lowerMap) + Map.END.code());
        System.out.println();
    }

    private List<String> partialMap(List<String> moves, boolean isFail, String code) {
        return IntStream.range(0, moves.size()).mapToObj(index -> {
            if (isFail && index == moves.size() - 1 && moves.get(index).equals(code)) {
                return Map.MOVE_FAIL.code();
            }
            if (moves.get(index).equals(code)) {
                return Map.MOVE_SUCCESS.code();
            }
            return Map.MOVE_EMPTY.code();
        }).collect(Collectors.toList());
    }

    public void printResult(List<String> moves, boolean isFail, int attempts) {
        System.out.println(OutputMessage.GAME_RESULT.message());
        printMap(moves, isFail);
        printSuccessOrFail(isFail);
        System.out.printf(OutputMessage.ATTEMPT.message(), attempts);
    }

    private void printSuccessOrFail(boolean isFail){
        String result = OutputMessage.SUCCESS.message();
        if (isFail) {
            result = OutputMessage.FAIL.message();
        }
        System.out.printf(OutputMessage.SUCCESS_OR_FAIL.message(), result);
    }
}
