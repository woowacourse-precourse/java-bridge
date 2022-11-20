package bridge.View;

import bridge.Enum.CrossResult;
import bridge.Enum.Crossing;
import bridge.Enum.GameStatus;
import bridge.Model.VO.CrossResults;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.UserChoices;

public class OutputView {
    public void printMap(UserChoices userChoices, CrossResults crossResults) {
        String upLine = "[";
        String downLine = "[";
        for (int position = 0; position < userChoices.length(); position++) {
            UserChoice userChoice = userChoices.get(position);
            CrossResult crossResult = crossResults.get(position);

            if (userChoice.compare(Crossing.UP)) {
                upLine = upLine.concat(" " + crossResult.getString() + " ");
                downLine = downLine.concat(" " + " " + " ");
            } else if (userChoice.compare(Crossing.DOWN)) {
                upLine = upLine.concat(" " + " " + " ");
                downLine = downLine.concat(" " + crossResult.getString() + " ");
            }

            if (position < userChoices.length() - 1) {
                upLine = upLine.concat("|");
                downLine = downLine.concat("|");
            }
        }
        upLine += "]";
        downLine += "]";
        System.out.println(upLine);
        System.out.println(downLine);
    }

    public void printResult(UserChoices userChoices, CrossResults crossResults, GameStatus gameStatus, int tryCount) {
        System.out.println("최종 게임 결과");
        String upLine = "[";
        String downLine = "[";
        for (int position = 0; position < userChoices.length(); position++) {
            UserChoice userChoice = userChoices.get(position);
            CrossResult crossResult = crossResults.get(position);

            if (userChoice.compare(Crossing.UP)) {
                upLine = upLine.concat(" " + crossResult.getString() + " ");
                downLine = downLine.concat(" " + " " + " ");
            } else if (userChoice.compare(Crossing.DOWN)) {
                upLine = upLine.concat(" " + " " + " ");
                downLine = downLine.concat(" " + crossResult.getString() + " ");
            }

            if (position < userChoices.length() - 1) {
                upLine = upLine.concat("|");
                downLine = downLine.concat("|");
            }
        }
        upLine += "]";
        downLine += "]";
        System.out.println(upLine);
        System.out.println(downLine);

        System.out.println("게임 성공 여부: " + gameStatus.getStatus());
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
