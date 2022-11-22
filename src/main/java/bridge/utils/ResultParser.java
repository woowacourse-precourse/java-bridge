package bridge.utils;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;

import java.util.List;

import static bridge.constant.BridgePosition.DOWN;
import static bridge.constant.BridgePosition.UP;

public class ResultParser {

    private final String OPEN_BRACKET = "[";
    private final String CLOSE_BRACKET = "]";
    private final String CORRECT = " O ";
    private final String WRONG = " X ";
    private final String SEPARATOR = "|";
    private final String SPACE = "   ";
    private final StringBuilder topLine;
    private final StringBuilder bottomLine;

    public ResultParser() {
        topLine = new StringBuilder();
        bottomLine = new StringBuilder();
    }

    public void init() {
        topLine.setLength(0);
        bottomLine.setLength(0);
    }

    public String parseResultToMapUI(GameResult gameResult) {
        init();
        parseResultToMapUIExceptLastPart(gameResult);
        parseResultToMapUILastPart(gameResult);

        return topLine.append("\n").append(bottomLine).toString();
    }

    private void parseResultToMapUIExceptLastPart(GameResult gameResult) {
        List<String> bridge = gameResult.getResult();
        topLine.append(OPEN_BRACKET);
        bottomLine.append(OPEN_BRACKET);
        for (int index = 0; index < bridge.size() - 1; index++) {
            String currentPosition = bridge.get(index);
            appendCorrectSignToTopLine(currentPosition);
            appendCorrectSignToBottomLine(currentPosition);
        }
    }

    private void appendCorrectSignToTopLine(String position) {
        if (position.equals(UP.getPositionFormOfAlphabet())) {
            topLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        topLine.append(SPACE).append(SEPARATOR);
    }

    private void appendCorrectSignToBottomLine(String position) {
        if (position.equals(DOWN.getPositionFormOfAlphabet())) {
            bottomLine.append(CORRECT).append(SEPARATOR);
            return;
        }
        bottomLine.append(SPACE).append(SEPARATOR);
    }

    private void parseResultToMapUILastPart(GameResult result) {
        ViewStatus status = result.getNextViewStatus();
        List<String> bridge = result.getResult();
        String lastPosition = bridge.get(bridge.size() - 1);
        if (status == ViewStatus.DETERMINE_RETRY) {
            appendWrongSignAsLastPartOfMap(lastPosition);
            return;
        }
        appendCorrectSignAsLastPartOfMap(lastPosition);
    }

    private void appendWrongSignAsLastPartOfMap(String lastPosition) {
        appendWrongSignAsLastPartOfTopLine(lastPosition);
        appendWrongSignAsLastPartOfBottomLine(lastPosition);
    }

    private void appendWrongSignAsLastPartOfTopLine(String lastPosition) {
        if (lastPosition.equals(DOWN.getPositionFormOfAlphabet())) {
            topLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendWrongSignAsLastPartOfBottomLine(String lastPosition) {
        if (lastPosition.equals(UP.getPositionFormOfAlphabet())) {
            bottomLine.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendCorrectSignAsLastPartOfMap(String lastPosition) {
        appendCorrectSignAsLastPartOfTopLine(lastPosition);
        appendCorrectSignAsLastPartOfBottomLine(lastPosition);
    }

    private void appendCorrectSignAsLastPartOfTopLine(String lastPosition) {
        if (lastPosition.equals(UP.getPositionFormOfAlphabet())) {
            topLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        topLine.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendCorrectSignAsLastPartOfBottomLine(String lastPosition) {
        if (lastPosition.equals(DOWN.getPositionFormOfAlphabet())) {
            bottomLine.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        bottomLine.append(SPACE).append(CLOSE_BRACKET);
    }
}
