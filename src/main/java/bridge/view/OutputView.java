package bridge.view;

import bridge.domain.GameMoving;
import bridge.domain.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OutputView {
    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String WHETHER_GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private final String TOTAL_TRY = "총 시도한 횟수: ";

    public void printResult(GameStatus gameStatus) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(gameStatus);
        System.out.println(WHETHER_GAME_SUCCESS_MESSAGE + gameStatus.getMessage());
        System.out.println(TOTAL_TRY + gameStatus.getCount());
    }

    public void printMap(GameStatus gameStatus) {
        String result = makeFormattedResult(gameStatus);
        System.out.println(result);
    }

    private String makeFormattedResult(GameStatus gameStatus) {
        String normalizedGameHistory = normalize(gameStatus.getGameHistory());
        List<String> upperLine = makeUpperLine(normalizedGameHistory);
        List<String> lowerLine = makeLowerLine(normalizedGameHistory);
        String formattedResult = formatLine(upperLine) + "\n" + formatLine(lowerLine) + "\n";

        if (gameStatus.isFail()) {
            formattedResult = addFailSymbolAndGetResult(formattedResult);
        }
        return formattedResult;
    }

    private String addFailSymbolAndGetResult(String target) {
        int finalSymbolIndex = target.lastIndexOf("O");
        StringBuilder forAddSymbol = new StringBuilder(target);
        forAddSymbol.setCharAt(finalSymbolIndex, 'X');
        return forAddSymbol.toString();
    }

    private String normalize(String gameHistory) {
        String commaDeleted = gameHistory.replaceAll(",", "");
        String spaceDeleted = commaDeleted.replaceAll(" ", "");
        String bracketDeleted = spaceDeleted.substring(1, spaceDeleted.length() - 1);
        return bracketDeleted;
    }

    private List<String> makeUpperLine(String gameHistory) {
        List<String> upperLine = new ArrayList<>();
        for (int i = 0; i < gameHistory.length(); i++) {
            upperLine.add(getSymbolIfMovingIsUp(gameHistory.substring(i, i+1)));
        }
        return upperLine;
    }

    private List<String> makeLowerLine(String gameHistory) {
        List<String> lowerLine = new ArrayList<>();
        for (int i = 0; i < gameHistory.length(); i++) {
            lowerLine.add(getSymbolIfMovingIsDown(gameHistory.substring(i, i+1)));
        }
        return lowerLine;
    }

    private String getSymbolIfMovingIsUp(String moving) {
        if (GameMoving.isUp(moving)) {
            return "O";
        }
        return " ";
    }

    private String getSymbolIfMovingIsDown(String moving) {
        if (GameMoving.isDown(moving)) {
            return "O";
        }
        return " ";
    }

    private String formatLine(List<String> toJoin) {
        return toJoin.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }
}
