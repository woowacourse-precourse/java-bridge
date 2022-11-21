package bridge.model;

public class MapElement {
    public static final String START = "[";
    public static final String END = "]";
    public static final String SEPARATOR = "|";
    public static final String CROSS = " O ";
    public static final String FAIL = " X ";
    public static final String SPACE = "   ";

    private final StringBuilder upperBuilder;
    private final StringBuilder lowerBuilder;

    public MapElement() {
        this.upperBuilder = new StringBuilder(START);
        this.lowerBuilder = new StringBuilder(START);
    }

    public void appendSeparator() {
        upperBuilder.append(SEPARATOR);
        lowerBuilder.append(SEPARATOR);
    }

    public void appendEnd() {
        upperBuilder.append(END);
        lowerBuilder.append(END);
    }

    public void appendCross(Direction direction) {
        if (direction == Direction.U) {
            upperBuilder.append(CROSS);
            lowerBuilder.append(SPACE);
        }
        if (direction == Direction.D) {
            upperBuilder.append(SPACE);
            lowerBuilder.append(CROSS);
        }
    }

    public void appendFail(Direction direction) {
        if (direction == Direction.U) {
            upperBuilder.append(FAIL);
            lowerBuilder.append(SPACE);
        }
        if (direction == Direction.D) {
            upperBuilder.append(SPACE);
            lowerBuilder.append(FAIL);
        }
    }

    public String getMap() {
        return upperBuilder.toString() + System.lineSeparator() + lowerBuilder.toString();
    }
}
