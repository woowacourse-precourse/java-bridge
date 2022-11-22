package bridge.console.utility;

import bridge.constant.Move;
import bridge.data.MoveResult;

import java.util.List;

public class MapDrawer {
    private static final String LEFT_BOUND = "[";
    private static final String RIGHT_BOUND = "]";
    private static final String MIDDLE_LINE = "|";
    private static final String CORRECT_MOVE = " O ";
    private static final String WRONG_MOVE = " X ";
    private static final String EMPTY_PADDING = "   ";

    public void drawMap(List<MoveResult> moveResults, StringBuilder upperRow, StringBuilder lowerRow) {
        drawLeftBound(upperRow, lowerRow);
        drawBody(moveResults, upperRow, lowerRow);
        drawRightBound(upperRow, lowerRow);
    }

    private void drawLeftBound(StringBuilder upperRow, StringBuilder lowerRow) {
        upperRow.append(LEFT_BOUND);
        lowerRow.append(LEFT_BOUND);
    }

    private void drawRightBound(StringBuilder upperRow, StringBuilder lowerRow) {
        upperRow.append(RIGHT_BOUND);
        lowerRow.append(RIGHT_BOUND);
    }

    private void drawBody(List<MoveResult> moveResults, StringBuilder upperRow, StringBuilder lowerRow) {
        int count = 0;
        while (count < moveResults.size() - 1) {
            switchCorrectAndWrongRows(moveResults.get(count), upperRow, lowerRow);
            drawMiddleLine(upperRow, lowerRow);
            count++;
        }

        switchCorrectAndWrongRows(moveResults.get(count), upperRow, lowerRow);
    }

    private void drawMiddleLine(StringBuilder upperRow, StringBuilder lowerRow) {
        upperRow.append(MIDDLE_LINE);
        lowerRow.append(MIDDLE_LINE);
    }

    private void switchCorrectAndWrongRows(MoveResult moveResult, StringBuilder upperRow, StringBuilder lowerRow) {
        if (moveResult.getCorrectMove() == Move.UP) {
            drawColumn(moveResult, upperRow, lowerRow);
            return;
        }
        drawColumn(moveResult, lowerRow, upperRow);
    }

    private void drawColumn(MoveResult moveResult, StringBuilder correctRow, StringBuilder wrongRow) {
        if (moveResult.isUserMoveCorrect()) {
            correctRow.append(CORRECT_MOVE);
            wrongRow.append(EMPTY_PADDING);
            return;
        }
        correctRow.append(EMPTY_PADDING);
        wrongRow.append(WRONG_MOVE);
    }
}
