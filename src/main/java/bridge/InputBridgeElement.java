package bridge;

import java.util.Arrays;

public enum InputBridgeElement {
    O(true,"O"),X(false,"X");

    final boolean isChecked;
    final String inputLetter;

    InputBridgeElement(boolean isChecked, String inputLetter) {
        this.inputLetter = inputLetter;
        this.isChecked = isChecked;
    }

    public static String inputLetterChecked (boolean isChecked){
        return Arrays.stream(InputBridgeElement.values())
                .filter(x -> x.isChecked == isChecked)
                .findAny()
                .get().inputLetter;
    }


}
