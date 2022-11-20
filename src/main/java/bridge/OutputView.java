package bridge;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public enum PrintLastElement {
        O(true, true, " O ]"),
        X(true, false, " X ]"),
        Blank_O(false, true, "   ]"),
        Blank_X(false, false, "   ]");

        private final Boolean isRightLocation;
        private final Boolean isRightStep;
        private final String OutputMessage;

        PrintLastElement(Boolean isRightLocation, Boolean isRightStep, String outputMessage) {
            this.isRightLocation = isRightLocation;
            this.isRightStep = isRightStep;
            OutputMessage = outputMessage;
        }

        public static void getMessage(String lastStep, String lastBridge, String printLocation){
            boolean isRightLocation = lastStep.equals(printLocation);
            boolean isRightStep = lastStep.equals(lastBridge);
            String outputMessage = Arrays.stream(values())
                    .filter(find -> find.isRightLocation.equals(isRightLocation) && find.isRightStep.equals(isRightStep))
                    .findAny().get().OutputMessage;
            System.out.println(outputMessage);
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> stepResult, List<String> bridge) {
        String lastStep = stepResult.get(stepResult.size()-1);
        String lastBridge = bridge.get(stepResult.size()-1);

        printUpMap(stepResult);
        PrintLastElement.getMessage(lastStep, lastBridge, "U");

        printDownMap(stepResult);
        PrintLastElement.getMessage(lastStep, lastBridge, "D");
    }

    public void printUpMap(List<String> stepResult) {
        System.out.print("[");
        stepResult.subList(0, stepResult.size()-1)
                .stream().map(el -> el.equals("U") ? " O |":"   |")
                .forEach(now -> System.out.print(now));
    }

    public void printDownMap(List<String> stepResult) {
        System.out.print("[");
        stepResult.subList(0, stepResult.size()-1)
                .stream().map(el -> el.equals("D") ? " O |":"   |")
                .forEach(now -> System.out.print(now));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
