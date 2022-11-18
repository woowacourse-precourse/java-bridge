package bridge.view;

import bridge.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameStatus gameStatus) {
        String gameHistory = gameStatus.getGameHistory();
        List<String> upperLine = new ArrayList<>();
        List<String> lowerLine = new ArrayList<>();

        setLines(gameHistory, upperLine, lowerLine);
        convertIfGameOver(gameStatus, upperLine, lowerLine);

        String result = joinListToString(upperLine) + "\n" + joinListToString(lowerLine);
        System.out.println(result);
    }

    private String joinListToString(List<String> toJoin) {
        return toJoin.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private void setLines(String gameHistory, List<String> upperLine, List<String> lowerLine) {
        for (int i = 0; i < gameHistory.length(); i++) {
            if (gameHistory.charAt(i) == 'U') {
                upperLine.add("O");
                lowerLine.add(" ");
            }
            if (gameHistory.charAt(i) == 'D') {
                upperLine.add(" ");
                lowerLine.add("O");
            }
        }
    }

    private void convertIfGameOver(GameStatus gameStatus, List<String> upperLine, List<String> lowerLine) {
        if (gameStatus.getFlag() == 1) {
            convertIfNeeded(upperLine);
            convertIfNeeded(lowerLine);
        }
    }

    private void convertIfNeeded(List<String> line) {
        if (line.get(line.size() - 1).equals("O")) {
            line.set(line.size() - 1, "X");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
