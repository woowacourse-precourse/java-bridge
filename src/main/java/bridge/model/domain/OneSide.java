package bridge.model.domain;

import java.util.ArrayList;
import java.util.List;

public class OneSide {
    private static final String RIGHT = "O ";
    private static final String WRONG = "X ";
    private static final String BLANK = "  ";
    private static final String SEPARATOR = "| ";

    private final List<String> oneSide;

    public OneSide() {
        this.oneSide = new ArrayList<>();
    }

    public void addBlank() {
        oneSide.add(BLANK);
    }

    public void addRightOrWrong(boolean isRight) {
        if (isRight) {
            oneSide.add(RIGHT);
            return;
        }

        oneSide.add(WRONG);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String s : oneSide) {
            sb.append(s);
            sb.append(SEPARATOR);
        }

        sb.setLength(Math.max(0, sb.length() - 2));

        return sb.toString();
    }
}
