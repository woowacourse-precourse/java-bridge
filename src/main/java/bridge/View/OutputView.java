package bridge.View;

import bridge.Enum.CrossResult;
import bridge.Enum.Crossing;
import bridge.Model.VO.CrossResults;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.UserChoices;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UserChoices userChoices, CrossResults crossResults) {
        String upLine = "[";
        String downLine = "[";
        for(int position = 0; position < userChoices.length(); position++){
            UserChoice userChoice = userChoices.get(position);
            CrossResult crossResult = crossResults.get(position);

            if(userChoice.compare(Crossing.UP)){
                upLine = upLine.concat(" " + crossResult.getString() + " ");
                downLine = downLine.concat(" " + " " + " ");
            } else if(userChoice.compare(Crossing.DOWN)){
                upLine = upLine.concat(" " + " " + " ");
                downLine = downLine.concat(" " + crossResult.getString() + " ");
            }

            if(position < userChoices.length() - 1){
                upLine = upLine.concat("|");
                downLine = downLine.concat("|");
            }
        }
        upLine += "]";
        downLine += "]";
        System.out.println(upLine);
        System.out.println(downLine);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
