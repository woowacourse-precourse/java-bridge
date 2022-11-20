package bridge.View;

import bridge.Model.BridgeShape;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static StringBuilder upperBuilder;
    private static StringBuilder lowerBuilder;

    private final String UP = BridgeShape.UP.getShape();
    private final String DOWN = BridgeShape.DOWN.getShape();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String currentResult, String currentInput, int progress) {
        String upperString = createUpperString(currentInput, currentResult);
        String lowerString = createLowerString(currentInput, currentResult);

        createResultByProgress(progress, upperString, lowerString);

        System.out.println(upperBuilder.toString());
        System.out.println(lowerBuilder.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isCrossable, int totalTries) { //TODO: 라인 줄이기
        StringBuilder stringBuilder = new StringBuilder();
        String result = createResult(isCrossable);

        stringBuilder.append("\n최종 게임 결과\n");
        stringBuilder.append(upperBuilder + "\n")
                .append(lowerBuilder + "\n");
        stringBuilder.append("\n게임 성공 여부: ")
                .append(result);

        stringBuilder.append("\n총 시도한 횟수: ")
                .append(totalTries);

        System.out.println(stringBuilder.toString());
    }

    private String createResult(boolean isCrossable) {
        if (isCrossable) { //TODO: enum으로 처리해보기
            return "성공";
        }

        return "실패";
    }

    private String createUpperString(String currentInput, String currentResult) {
        String upperString = "";

        if (currentInput.equals(UP)) {
            upperString = currentResult;
        }

        if (currentInput.equals(DOWN)) {
            upperString = " ";
        }

        return upperString;
    }

    private String createLowerString(String currentInput, String currentResult) {
        String lowerString = "";

        if (currentInput.equals(UP)) {
            lowerString = " ";
        }

        if (currentInput.equals(DOWN)) {
            lowerString = currentResult;
        }

        return lowerString;
    }

    private void createResultByProgress(int progress, String upperString, String lowerString) {
        if (progress == 1) {
            upperBuilder = new StringBuilder();
            lowerBuilder = new StringBuilder();
            initResult(upperString, upperBuilder);
            initResult(lowerString, lowerBuilder);
        }

        if (progress > 1) {
            appendResult(upperString, upperBuilder);
            appendResult(lowerString, lowerBuilder);
        }
    }

    private void initResult(String currentResult, StringBuilder stringBuilder) {
        stringBuilder.append("[")
                .append(" ");
        stringBuilder.append(currentResult)
                .append(" ");
        stringBuilder.append("]");
    }

    private void appendResult(String currentResult, StringBuilder stringBuilder) {
        int endIndex = stringBuilder.indexOf("]");
        stringBuilder.deleteCharAt(endIndex);

        stringBuilder.append("|")
                .append(" ")
                .append(currentResult)
                .append(" ]");
    }
}
