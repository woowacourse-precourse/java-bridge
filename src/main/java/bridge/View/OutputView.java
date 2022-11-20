package bridge.View;

import bridge.Enum.CrossResult;
import bridge.Enum.Crossing;
import bridge.Enum.GameStatus;
import bridge.Model.VO.CrossResults;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.UserChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final int UP_LINE = 0;
    private static final int DOWN_LINE = 1;

    public void printMap(UserChoices userChoices, CrossResults crossResults) {
        List<String> line = createLineString(userChoices, crossResults);
        String upLine = line.get(UP_LINE);
        String downLine = line.get(DOWN_LINE);
        System.out.println(upLine);
        System.out.println(downLine);
    }

    private List<String> createLineString(UserChoices userChoices, CrossResults crossResults) {
        List<String> line = new ArrayList<>(Arrays.asList("[", "["));
        int length = userChoices.length();
        for (int position = 0; position < userChoices.length(); position++) {
            UserChoice userChoice = userChoices.get(position);
            CrossResult crossResult = crossResults.get(position);
            line = concatCrossResult(line, userChoice, crossResult);
            line = concatDivisionLine(line, position, length);
        }

        return line;
    }

    private List<String> concatCrossResult(List<String> line, UserChoice userChoice, CrossResult crossResult) {
        String upLine = line.get(UP_LINE);
        String downLine = line.get(DOWN_LINE);
        if (userChoice.compare(Crossing.UP)) {
            line.set(UP_LINE, upLine.concat(" " + crossResult.getString() + " "));
            line.set(DOWN_LINE, downLine.concat(" " + " " + " "));
        } else if (userChoice.compare(Crossing.DOWN)) {
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


    public void printResult(UserChoices userChoices, CrossResults crossResults, GameStatus gameStatus, int tryCount) {
        System.out.println("최종 게임 결과\n");
        printMap(userChoices, crossResults);
        System.out.println("게임 성공 여부: " + gameStatus.getStatus());
        System.out.println("총 시도한 횟수: " + tryCount);
    }


}
