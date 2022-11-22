package bridge;

public class OutputView {
    private enum Line {
        TOP, BOTTOM;
    }

    private static final String CORRECT_CELL = " O ";
    private static final String INCORRECT_CELL = " X ";
    private static final String EMPTY_CELL = "   ";
    private static final String SEPARATOR = "|";
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String WHETHER_GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_TRY_MESSAGE = "총 시도한 횟수: ";

    private final BridgeGame game;

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public OutputView(BridgeGame game) {
        this.game = game;
    }

    public void printMap() {
        StringBuilder builder = new StringBuilder();

        builder.append(buildBridgeLine(Line.TOP).append("\n"));
        builder.append(buildBridgeLine(Line.BOTTOM));

        System.out.println(builder.toString());
    }

    private StringBuilder buildBridgeLine(Line flag) {
        StringBuilder builder = new StringBuilder();

        buildInnerBridgeLine(flag, builder);
        appendBracketBothSide(builder);
        return builder;
    }

    private void buildInnerBridgeLine(Line flag, StringBuilder builder) {
        for (int i = 0; i < game.getLastPosition(); ++i) {
            builder.append(getCell(flag, i));
            if (!isLastCell(i)) {
                builder.append(SEPARATOR);
            }
        }
    }

    private boolean isLastCell(int i) {
        if (game.getLastIndex() == i) {
            return true;
        }
        return false;
    }

    private String getCell(Line flag, int index) {
        if (index < game.getLastIndex() && isSameLine(flag, game.getBridgeCell(index))) {
            return CORRECT_CELL;
        }
        if (index == game.getLastIndex() && isSameLine(flag, game.getLastCommand())) {
            if (game.getLastCommand().equals(game.getBridgeCell(index))) {
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
        builder.insert(0, LEFT_BRACKET);
        builder.append(RIGHT_BRACKET);
    }

    public void printResult() {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap();
        System.out.println(WHETHER_GAME_RESULT_MESSAGE + game.getGameResultToString());
        System.out.println(TOTAL_TRY_MESSAGE + game.getTryCount());
    }
}
