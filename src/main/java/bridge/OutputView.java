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

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printMap(BridgeGame game) {
        StringBuilder builder = new StringBuilder();

        builder.append(buildBridgeLine(Line.TOP, game).append("\n"));
        builder.append(buildBridgeLine(Line.BOTTOM, game));

        System.out.println(builder.toString());
    }

    private StringBuilder buildBridgeLine(Line flag, BridgeGame game) {
        StringBuilder builder = new StringBuilder();

        buildInnerBridgeLine(flag, game, builder);
        appendBracketBothSide(builder);
        return builder;
    }

    private void buildInnerBridgeLine(Line flag, BridgeGame game, StringBuilder builder) {
        for (int i = 0; i < game.getPosition(); ++i) {
            builder.append(getCell(flag, i, game));
            builder.append(getSeparator(game.getIndex(), i));
        }
    }

    private static String getSeparator(int nowIndex, int i) {
        if (i != nowIndex) {
            return SEPARATOR;
        }
        return "";
    }

    private String getCell(Line flag, int index, BridgeGame game) {
        if (index < game.getIndex() && isSameLine(flag, game.getBridgeCell(index))) {
            return CORRECT_CELL;
        }
        if (index == game.getIndex() && isSameLine(flag, game.getLastCommand())) {
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

    public void printResult(BridgeGame game) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(game);
        System.out.println(WHETHER_GAME_RESULT_MESSAGE + game.getGameResultToString());
        System.out.println(TOTAL_TRY_MESSAGE + game.getTryCount());
    }
}
