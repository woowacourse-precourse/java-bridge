package bridge.View;

import bridge.Model.BridgeShape;

public class OutputView {

    private static StringBuilder upperBuilder;
    private static StringBuilder lowerBuilder;

    private final String UP = BridgeShape.UP.getShape();
    private final String DOWN = BridgeShape.DOWN.getShape();

    public void printMap(String currentResult, String currentInput, int progress) {
        String upperString = createUpperString(currentInput, currentResult);
        String lowerString = createLowerString(currentInput, currentResult);

        createMapByProgress(progress, upperString, lowerString);

        System.out.println(upperBuilder.toString());
        System.out.println(lowerBuilder.toString());
    }

    public void printResult(boolean isCrossable, int totalTries) {
        String result = createResult(isCrossable);
        StringBuilder stringBuilder = createResultMessage(result, totalTries);

        System.out.println(stringBuilder.toString());
    }

    private String createResult(boolean isCrossable) {
        if (isCrossable) {
            return "성공";
        }

        return "실패";
    }

    private StringBuilder createResultMessage(String result, int totalTries) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n최종 게임 결과\n");
        stringBuilder.append(upperBuilder + "\n")
                .append(lowerBuilder + "\n");
        stringBuilder.append("\n게임 성공 여부: ")
                .append(result);
        stringBuilder.append("\n총 시도한 횟수: ")
                .append(totalTries);

        return stringBuilder;
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

    private void createMapByProgress(int progress, String upperString, String lowerString) {
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
