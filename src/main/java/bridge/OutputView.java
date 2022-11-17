package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder firstLine = new StringBuilder();
    private StringBuilder secondLine = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String currentStep, boolean valid) {
        updateFirstLine(currentStep, valid);
        updateSecondLine(currentStep, valid);
        System.out.println(firstLine.toString() + ']');
        System.out.println(secondLine.toString() + ']');
        if (!valid) {
            firstLine.setLength(firstLine.length() - 2);
            secondLine.setLength(secondLine.length() - 2);
        }
    }

    private void updateFirstLine(String currentStep, boolean valid) {
        if (currentStep.equals("D") && valid)
            firstLine.append("| ");
        if (currentStep.equals("U") && valid)
            firstLine.append("|O");
        if ((currentStep.equals("D") && !valid) ||
                (currentStep.equals("U") && !valid))
            firstLine.append("|X");
        firstLine.setCharAt(0, '[');
    }

    private void updateSecondLine(String currentStep, boolean valid) {
        if (currentStep.equals("D") && valid)
            secondLine.append("|O");
        if (currentStep.equals("U") && valid)
            secondLine.append("| ");
        if ((currentStep.equals("U") && !valid) ||
                (currentStep.equals("D") && !valid))
            secondLine.append("|X");
        secondLine.setCharAt(0, '[');
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(firstLine.toString() + ']');
        System.out.println(secondLine.toString() + ']');
    }
}
