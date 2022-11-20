package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private enum Line {
        TOP, BOTTOM;
    }
    private static final String CORRECT_CELL = " O ";
    private static final String INCORRECT_CELL = " X ";
    private static final String EMPTY_CELL = "   ";
    private static final String SEPARATOR = "|";
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        StringBuilder builder = new StringBuilder();

        builder.append(buildBridgeLine(Line.TOP, game).append("\n"));
        builder.append(buildBridgeLine(Line.BOTTOM, game));

        System.out.println(builder.toString());
    }

    private StringBuilder buildBridgeLine(Line flag, BridgeGame game) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < game.getPlayerPosition(); ++i) {
            builder.append(getCell(flag, i, game));
            if (i != game.getPlayerIndex()) {
                builder.append(SEPARATOR);
            }
        }
        appendBracketBothSide(builder);

        return builder;
    }

    private String getCell(Line flag, int index, BridgeGame game) {
        if (index < game.getPlayerIndex() && isSameLine(flag, game.getBridge().get(index))) {
            return CORRECT_CELL;
        }
        if (index == game.getPlayerIndex() && isSameLine(flag, game.getLastCommand())) {
            if (game.getLastCommand().equals(game.getBridge().get(index))) {
                return CORRECT_CELL;
            }
            return INCORRECT_CELL;
        }
        return EMPTY_CELL;
    }

    private boolean isSameLine(Line flag, String command) {
        if (flag == Line.TOP && command.equals(BridgeGame.CMD_UP)
                || flag == Line.BOTTOM && command.equals(BridgeGame.CMD_DOWN)) {
            return true;
        }
        return false;
    }

    private void appendBracketBothSide(StringBuilder builder) {
        builder.insert(0, "[");
        builder.append("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        System.out.println("최종 게임 결과");
        System.out.println(game.getBridge().toString());
        System.out.println("게임 성공 여부: " + game.getGameResultToString());
        System.out.println("총 시도한 횟수: " + game.getTryCount());
    }
}
