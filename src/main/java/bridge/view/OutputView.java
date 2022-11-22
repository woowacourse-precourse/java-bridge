package bridge.view;

import bridge.enums.OutputText;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String DELIMITER = " | ";
    private static final int UP_INDEX = 0;
    private static final int DOWN_INDEX = 1;
    private static final int START_INDEX = 0;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String>[] map) {
        System.out.println(convertForm(map[UP_INDEX]));
        System.out.println(convertForm(map[DOWN_INDEX]));
    }
    private String convertForm(List<String> result) {
        StringBuilder convertedForm = new StringBuilder();
        for (int i = START_INDEX; i < result.size(); i++) {
            convertedForm.append(convertElement(result.get(i), i, result.size()));
        }
        insertStartEndSymbol(convertedForm);
        return convertedForm.toString();
    }
    private String convertElement(String element, int index, int resultSize) {
        if (index != resultSize - 1) {
            element += DELIMITER;
        }
        return element;
    }
    private void insertStartEndSymbol(StringBuilder convertedForm) {
        convertedForm.insert(START_INDEX, OutputText.START_SYMBOL.getValue());
        convertedForm.insert(convertedForm.length(), OutputText.END_SYMBOL.getValue());
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String>[] map, boolean isFail, int tryCount) {
        System.out.println(OutputText.FINAL_RESULT.getValue());
        printMap(map);
        String result = OutputText.SUCCESS.getValue();
        if (isFail) {
            result = OutputText.FAIL.getValue();
        }
        System.out.println(OutputText.SUCCESS_TEXT.getValue() + result);
        System.out.println(OutputText.TRY_COUNT_TEXT.getValue() + tryCount);
    }
}
