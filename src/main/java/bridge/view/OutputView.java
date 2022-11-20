package bridge.view;

import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    // [refactor 예정]
    public static void printMap(List<String> bridge, List<Boolean> status) {
        String resultUp = "[";
        String resultDown = "[";
        for(int i=0; i<status.size(); i++) {
            if(bridge.get(i).equals("U")) {
                if(status.get(i).booleanValue() == TRUE) {
                    resultUp += " O ";
                    resultDown += "   ";
                }
                else {
                    resultUp += "   ";
                    resultDown += " X ";
                }
            }
            else {
                if(status.get(i).booleanValue() == TRUE) {
                    resultUp += "   ";
                    resultDown += " O ";
                }
                else {
                    resultUp += " X ";
                    resultDown += "   ";
                }
            }

            if(i != status.size() -1) {
                resultUp += "|";
                resultDown += "|";
            }
        }
        resultUp += "]";
        resultDown += "]";

        System.out.println(resultUp);
        System.out.println(resultDown);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
