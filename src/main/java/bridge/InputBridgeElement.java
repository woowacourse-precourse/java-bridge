package bridge;

import java.util.Arrays;

public enum InputBridgeElement {
    O(true,"O","성공"),X(false,"X","실패");

    final boolean isChecked;
    final String inputLetter;
    final String inputResult;

    InputBridgeElement(boolean isChecked, String inputLetter, String inputResult) {
        this.inputLetter = inputLetter;
        this.isChecked = isChecked;
        this.inputResult = inputResult;
    }

    public static String inputLetterChecked (boolean isChecked){
        return Arrays.stream(InputBridgeElement.values())
                .filter(x -> x.isChecked == isChecked)
                .findAny()
                .get().inputLetter;
    }

    public static String inputResultChecked(boolean isChecked){
        return Arrays.stream(InputBridgeElement.values())
                .filter(x -> x.isChecked == isChecked)
                .findAny()
                .get().inputResult;
    }

}
