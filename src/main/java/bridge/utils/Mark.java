package bridge.utils;

import java.util.stream.Stream;

public enum Mark {
    UP_MATCH("U", "O", true),
    UP_WRONG("U", "X", false),
    DOWN_MATCH("D", "O", true),
    DOWN_WRONG("D", "X", false);

    private final String direction;
    private final String mark;
    private final boolean right;

    Mark(String direction, String mark, boolean right) {
        this.direction = direction;
        this.mark = mark;
        this.right = right;
    }

    public String getDirection() {
        return direction;
    }

    public String getMark() {
        return mark;
    }

    public boolean isRight() {
        return right;
    }

    public static Mark toMark(String inputDirection, boolean result) {
        return Stream.of(Mark.values())
                .filter(m -> m.getDirection().equals(inputDirection))
                .filter(i -> i.isRight() == result)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
