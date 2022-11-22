package bridge.domain;

import static bridge.domain.BridgeInfo.BRIDGE_TOP;
import static bridge.utils.Constant.CORRECT_MARK;
import static bridge.utils.Constant.SPACE_MARK;
import static bridge.utils.Constant.WRONG_MARK;

public class DrawBridge {

    private final StringBuilder top;
    private final StringBuilder bottom;

    public DrawBridge() {
        top = new StringBuilder("[");
        bottom = new StringBuilder("[");
    }

    public void draw(String nextMove, boolean correctLastPosition) {
        if (nextMove.equals(BRIDGE_TOP.getPosition())) {
            drawMark(top, correctLastPosition);
            drawSpace(bottom);
            return;
        }
        drawMark(bottom, correctLastPosition);
        drawSpace(top);
    }

    private void drawSpace(StringBuilder builder) {
        builder.append(SPACE_MARK);
    }

    private void drawMark(StringBuilder builder, boolean correctLastPosition) {
        if (correctLastPosition) {
            builder.append(CORRECT_MARK);
            return;
        }
        builder.append(WRONG_MARK);
    }

    public String printBridge() {
        StringBuilder top = new StringBuilder(this.top);
        StringBuilder bottom = new StringBuilder(this.bottom);
        top.setCharAt(top.length() - 1, ']');
        bottom.setCharAt(bottom.length() - 1, ']');
        return top + "\n" + bottom;
    }

    public void reset() {
        top.setLength(1);
        bottom.setLength(1);
    }
}
