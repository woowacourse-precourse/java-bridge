package bridge.view;

import bridge.domain.direction.Direction;
import bridge.domain.game.Round;
import bridge.domain.movingrecord.MovingRecord;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printMap(MovingRecord movingRecord) {
        printSideMap(movingRecord, new Direction(Direction.UPWARD_DIRECTION));
        printSideMap(movingRecord, new Direction(Direction.DOWNWARD_DIRECTION));
    }

    private void printSideMap(MovingRecord movingRecord, Direction side) {
        List<String> bridgeMap = makeBridgeGraphic(movingRecord.makeBridgeSketches(side));
        System.out.printf((OutputMessage.BRIDGE_EDGE.getMessage()), String.join(OutputMessage.DELIMITER.getMessage(), bridgeMap));
    }

    private List<String> makeBridgeGraphic(List<Integer> bridgeSketches) {
        return bridgeSketches.stream()
                .map(this::makeAnswerMessage)
                .collect(Collectors.toList());
    }

    private String makeAnswerMessage(int number) {
        if (number == MovingRecord.CORRECT_DIRECTION) {
            return OutputMessage.CORRECT_ANSWER.getMessage();
        }
        if (number == MovingRecord.INCORRECT_DIRECTION) {
            return OutputMessage.INCORRECT_ANSWER.getMessage();
        }
        return OutputMessage.BLANK.getMessage();
    }

    public void printResult(MovingRecord movingRecord, boolean success, Round round) {
        System.out.print(OutputMessage.RESULT_TITLE.getMessage());
        printMap(movingRecord);
        System.out.printf(OutputMessage.RESULT_CONTENT.getMessage(), makeResultMessage(success));
        System.out.printf(OutputMessage.NUMBER_OF_ATTEMPT.getMessage(), round.getGameRound());
    }

    public void printStart() {
        System.out.print(OutputMessage.START.getMessage());
    }

    public void printErrorMessage(String error) {
        System.out.print(error);
    }

    private String makeResultMessage(boolean success) {
        if (success) {
            return OutputMessage.SUCCESS.getMessage();
        }
        return OutputMessage.FAIL.getMessage();
    }
}
