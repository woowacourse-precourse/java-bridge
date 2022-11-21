package bridge.view;

import bridge.domain.GameMoving;
import bridge.domain.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String WHETHER_GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private final String TOTAL_TRY_MESSAGE = "총 시도한 횟수: ";

    private final String SUCCESS_SYMBOL = "O";
    private final String FAIL_SYMBOL = "X";
    private final String EMPTY_SPACE = " ";
    private final String NEW_LINE = "\n";

    private final String FORMAT_DELIMITER = " | ";
    private final String FORMAT_PREFIX = "[ ";
    private final String FORMAT_SUFFIX = " ]";

    public void printResult(GameStatus gameStatus) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(gameStatus);
        System.out.println(WHETHER_GAME_SUCCESS_MESSAGE + gameStatus.getMessage());
        System.out.println(TOTAL_TRY_MESSAGE + gameStatus.getCount());
    }

    public void printMap(GameStatus gameStatus) {
        String result = makeFormattedResult(gameStatus);
        System.out.println(result);
    }

    private String makeFormattedResult(GameStatus gameStatus) {
        String normalizedGameHistory = normalize(gameStatus.getGameHistory());
        List<String> upperLine = makeUpperLine(normalizedGameHistory);
        List<String> lowerLine = makeLowerLine(normalizedGameHistory);

        if (gameStatus.isFail()) {
            addFailSymbol(upperLine, lowerLine);
        }
        return formatLine(upperLine) + NEW_LINE + formatLine(lowerLine) + NEW_LINE;
    }

    private void addFailSymbol(List<String> upperLine, List<String> lowerLine) {
        int upperLineFinalSymbolIdx = upperLine.lastIndexOf(SUCCESS_SYMBOL);
        int lowerLineFinalSymbolIdx = lowerLine.lastIndexOf(SUCCESS_SYMBOL);

        if (upperLineFinalSymbolIdx > lowerLineFinalSymbolIdx) {
            upperLine.set(upperLineFinalSymbolIdx, FAIL_SYMBOL);
            return;
        }
        lowerLine.set(lowerLineFinalSymbolIdx, FAIL_SYMBOL);
    }

    private String normalize(String gameHistory) {
        String commaDeleted = gameHistory.replaceAll(",", "");
        String emptySpaceDeleted = commaDeleted.replaceAll(" ", "");
        String bracketDeleted = emptySpaceDeleted.substring(1, emptySpaceDeleted.length() - 1);
        return bracketDeleted;
    }

    private List<String> makeUpperLine(String gameHistory) {
        List<String> upperLine = new ArrayList<>();
        for (int i = 0; i < gameHistory.length(); i++) {
            upperLine.add(getSymbolIfMovingIsUp(gameHistory.substring(i, i + 1)));
        }
        return upperLine;
    }

    private List<String> makeLowerLine(String gameHistory) {
        List<String> lowerLine = new ArrayList<>();
        for (int i = 0; i < gameHistory.length(); i++) {
            lowerLine.add(getSymbolIfMovingIsDown(gameHistory.substring(i, i + 1)));
        }
        return lowerLine;
    }

    private String getSymbolIfMovingIsUp(String moving) {
        if (GameMoving.isUp(moving)) {
            return SUCCESS_SYMBOL;
        }
        return EMPTY_SPACE;
    }

    private String getSymbolIfMovingIsDown(String moving) {
        if (GameMoving.isDown(moving)) {
            return SUCCESS_SYMBOL;
        }
        return EMPTY_SPACE;
    }

    private String formatLine(List<String> toJoin) {
        return toJoin.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(FORMAT_DELIMITER, FORMAT_PREFIX, FORMAT_SUFFIX));
    }
}
