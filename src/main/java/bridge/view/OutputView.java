package bridge.view;

import bridge.domain.GameFlag;
import bridge.domain.GameMoving;
import bridge.domain.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OutputView {

    public void printResult(GameStatus gameStatus, int count) {
        System.out.println("최종 게임 결과");
        printMap(gameStatus);
        System.out.println("게임 성공 여부: " + gameStatus.getMessage());
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printMap(GameStatus gameStatus) {
        String gameHistory = gameStatus.getGameHistory();
        List<String> upperLine = new ArrayList<>();
        List<String> lowerLine = new ArrayList<>();

        setLines(gameHistory, upperLine, lowerLine);
        convertIfGameOver(gameStatus, upperLine, lowerLine);

        String result = joinListToString(upperLine) + "\n" + joinListToString(lowerLine) + "\n";
        System.out.println(result);
    }

    private String joinListToString(List<String> toJoin) {
        return toJoin.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private void setLines(String gameHistory, List<String> upperLine, List<String> lowerLine) {
        for (int i = 0; i < gameHistory.length(); i++) {
            if (GameMoving.isUp(gameHistory.substring(i, i+1))) {
                upperLine.add("O");
                lowerLine.add(" ");
            }
            if (GameMoving.isDown(gameHistory.substring(i, i+1))) {
                upperLine.add(" ");
                lowerLine.add("O");
            }
        }
    }

    private void convertIfGameOver(GameStatus gameStatus, List<String> upperLine, List<String> lowerLine) {
        if (gameStatus.isFail()) {
            convertIfNeeded(upperLine);
            convertIfNeeded(lowerLine);
        }
    }

    private void convertIfNeeded(List<String> line) {
        if (line.get(line.size() - 1).equals("O")) {
            line.set(line.size() - 1, "X");
        }
    }
}
