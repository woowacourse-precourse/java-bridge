package bridge.View;

import bridge.Enum.CrossResult;
import bridge.Enum.Direction;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.CrossResults;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.ChoiceDirections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final int UP_LINE = 0;
    private static final int DOWN_LINE = 1;

    public void printMap(BridgeGame bridgeGame) {
        ChoiceDirections choiceDirections = bridgeGame.getChoiceDirections();
        CrossResults crossResults = bridgeGame.getCrossResults();

        List<String> line = createLineString(choiceDirections, crossResults);
        String upLine = line.get(UP_LINE);
        String downLine = line.get(DOWN_LINE);
        System.out.println(upLine);
        System.out.println(downLine);
    }

    private List<String> createLineString(ChoiceDirections choiceDirections, CrossResults crossResults) {
        List<String> line = new ArrayList<>(Arrays.asList("[", "["));
        int length = choiceDirections.length();
        for (int position = 0; position < length; position++) {
            ChoiceDirection choiceDirection = choiceDirections.get(position);
            CrossResult crossResult = crossResults.get(position);
            line = concatCrossResult(line, choiceDirection, crossResult);
            line = concatDivisionLine(line, position, length);
        }

        return line;
    }

    private List<String> concatCrossResult(List<String> line, ChoiceDirection choiceDirection, CrossResult crossResult) {
        String upLine = line.get(UP_LINE);
        String downLine = line.get(DOWN_LINE);
        if (choiceDirection.compare(Direction.UP)) {
            line.set(UP_LINE, upLine.concat(" " + crossResult.getString() + " "));
            line.set(DOWN_LINE, downLine.concat(" " + " " + " "));
        } else if (choiceDirection.compare(Direction.DOWN)) {
            line.set(UP_LINE, upLine.concat(" " + " " + " "));
            line.set(DOWN_LINE, downLine.concat(" " + crossResult.getString() + " "));
        }
        return line;
    }

    private List<String> concatDivisionLine(List<String> line, int position, int length) {
        String upLine = line.get(UP_LINE);
        String downLine = line.get(DOWN_LINE);
        if (position < length - 1) {
            line.set(UP_LINE, upLine.concat("|"));
            line.set(DOWN_LINE, downLine.concat("|"));
            return line;
        }
        line.set(UP_LINE, upLine.concat("]"));
        line.set(DOWN_LINE, downLine.concat("]"));
        return line;
    }


    public void printResult(BridgeGame bridgeGame, GameStatus gameStatus) {
        System.out.println("최종 게임 결과\n");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: " + gameStatus.getStatus());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }


}
