package bridge.view;

import bridge.domain.direction.Direction;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.referee.Judgement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printMap(Pedestrian pedestrian) {
        List<String> upPath = makeBridgeGraphic(pedestrian, "U");
        List<String> downPath = makeBridgeGraphic(pedestrian, "D");

        System.out.printf((OutputMessage.BRIDGE_EDGE.getMessage()), String.join(OutputMessage.DELIMITER.getMessage(), upPath));
        System.out.printf((OutputMessage.BRIDGE_EDGE.getMessage()), String.join(OutputMessage.DELIMITER.getMessage(), downPath));
    }

    private List<String> makeBridgeGraphic(Pedestrian pedestrian, String answer) {
        return pedestrian.readRecord()
                .map(record -> makeAnswerMessage(record, answer))
                .collect(Collectors.toList());
    }

    private String makeAnswerMessage(Map.Entry<Judgement, Direction> record, String answer) {
        Direction direction = record.getValue();
        Judgement judgement = record.getKey();

        if (direction.equals(new Direction(answer)) && judgement.isTrue()) {
            return OutputMessage.CORRECT_ANSWER.getMessage();
        }
        if (direction.equals(new Direction(answer)) && judgement.isFalse()) {
            return OutputMessage.INCORRECT_ANSWER.getMessage();
        }
        return OutputMessage.BLANK.getMessage();
    }

    public void printResultTitle() {
        System.out.print(OutputMessage.RESULT_TITLE.getMessage());
    }

    public void printResult(boolean success, int count) {
        System.out.printf(OutputMessage.RESULT_CONTENT.getMessage(), makeResultMessage(success));
        System.out.printf(OutputMessage.NUMBER_OF_ATTEMPT.getMessage(), count);
    }

    public void printStart() {
        System.out.print(OutputMessage.START.getMessage());
    }

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    private String makeResultMessage(boolean success) {
        if (success) {
            return OutputMessage.SUCCESS.getMessage();
        }
        return OutputMessage.FAIL.getMessage();
    }
}
