package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<String> bridge, int currentStep, boolean die) {
        String firstLayer = "[";
        String secondLayer = "[";

        for(int i = 0; i < currentStep - 1; i++) {
            if(bridge.get(i).equals("U")) {
                firstLayer += "   |";
                secondLayer += " O |";
                continue;
            }
            firstLayer += " O |";
            secondLayer += "   |";
        }

        if(die) {
            if(bridge.get(currentStep - 1).equals("U")) {
                firstLayer += " X ]";
                secondLayer += "   ]";

                return firstLayer + "\n" + secondLayer +"\n";
            }

            firstLayer += "   ]";
            secondLayer += " X ]";

            return firstLayer + "\n" + secondLayer +"\n";
        }

        if(bridge.get(currentStep - 1).equals("U")) {
            firstLayer += "   ]";
            secondLayer += " O ]";

            return firstLayer + "\n" + secondLayer +"\n";
        }

        firstLayer += " O ]";
        secondLayer += "   ]";

        return firstLayer + "\n" + secondLayer +"\n";
    }

    /*
    public String fillLastLayer(List<String> bridge, int currentStep, String fill) {
        if(bridge.get(currentStep - 1).equals("U")) {
            return "   ]" + "\n" + " " + fill + " ]" +"\n";
        }

        return " " + fill + " ]" + "\n" + "   ]" +"\n";
    }
    */

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
