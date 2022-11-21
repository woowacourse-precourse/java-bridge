package bridge;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public String mapU = "[";
    public String mapD = "[";

    public void printMap(int bridgeCount, ArrayList<String> currentCoordinate) {
        if (bridgeCount > 0) {
            mapU += "|";
            mapD += "|";
        }
        if (Objects.equals(currentCoordinate.get(bridgeCount), "U")){
            mapU += " O ";
            mapD += "   ";
        }
        if (Objects.equals(currentCoordinate.get(bridgeCount), "D")){
            mapU += "   ";
            mapD += " O ";
        }
        BoilerPlates.printMap(mapU,mapD);
    }

    public void printFinalResult(ArrayList<String> currentCoordinate, int gameCount) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            BoilerPlates.printCompleteUp(mapU,mapD,gameCount);
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            BoilerPlates.printCompleteDown(mapU,mapD,gameCount);
        }
    }

    public void printFinalFailed(ArrayList<String> currentCoordinate, int gameCount) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            BoilerPlates.printFinalFailedUp(mapU,mapD,gameCount);
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            BoilerPlates.printFinalFailedDown(mapU,mapD,gameCount);
        }
    }
    public void printFailedMap(ArrayList<String> currentCoordinate, int gameCount) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            BoilerPlates.printFailedUp(mapU,mapD,gameCount);
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            BoilerPlates.printFailedDown(mapU,mapD,gameCount);
        }
    }
    public void printResultMap(ArrayList<String> currentCoordinate, int gameCount) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            BoilerPlates.printResultUp(mapU,mapD,gameCount);
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            BoilerPlates.printResultDown(mapU,mapD,gameCount);
        }
    }

}
