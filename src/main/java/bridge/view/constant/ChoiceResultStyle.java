package bridge.view.constant;

import bridge.service.constant.ChoiceResult;

import java.util.Arrays;

public enum ChoiceResultStyle {
    CORRECT("O", ChoiceResult.CORRECT),
    WRONG("X", ChoiceResult.WRONG),
    NOT_CHOSEN(" ", ChoiceResult.NOT_CHOSEN);

    private final String style;
    private final ChoiceResult choiceResult;

    public static String findStyleByChoiceResult (ChoiceResult choiceResult) {
        return Arrays.stream(ChoiceResultStyle.values())
                .filter(style -> style.getChoiceResult() == choiceResult)
                .findAny()
                .get()
                .getStyle();
    }

    private ChoiceResultStyle (String style, ChoiceResult choiceResult) {
        this.style = style;
        this.choiceResult = choiceResult;
    }

    public String getStyle() {
        return style;
    }

    public ChoiceResult getChoiceResult() {
        return choiceResult;
    }
}
