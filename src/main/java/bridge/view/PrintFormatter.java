package bridge.view;

import static bridge.model.UpOrDown.DOWN_SIGN;
import static bridge.model.UpOrDown.UP_SIGN;

import bridge.model.Crossing;
import bridge.model.PassOrFail;
import bridge.model.UpOrDown;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PrintFormatter {

    private static final String MAP_OPEN_FORMAT = "[";
    private static final String MAP_CLOSE_FORMAT = "]";
    private static final String MAP_PARTITION_FORMAT = "|";
    private static final String PASS_SIGN = " O ";
    private static final String FAIL_SIGN = " X ";
    private static final String EMPTY_SIGN = "   ";

    public String convertToFormat(Crossing crossing) {
        String upSide = convert(crossing, new UpOrDown(UP_SIGN));
        String downSide = convert(crossing, new UpOrDown(DOWN_SIGN));

        return upSide + "\n" + downSide;
    }

    private String convert(Crossing crossing, UpOrDown upOrDown) {
        StringJoiner joiner = new StringJoiner(MAP_PARTITION_FORMAT);

        List<String> line = crossing.stream()
                .map(v -> getSign(upOrDown, v))
                .collect(Collectors.toList());

        line.forEach(joiner::add);

        return MAP_OPEN_FORMAT + joiner + MAP_CLOSE_FORMAT;
    }

    private String getSign(UpOrDown upOrDown, PassOrFail passOrFail) {
        if (passOrFail.getUpOrDown().equals(upOrDown) && passOrFail.getValue()) {
            return PASS_SIGN;
        }
        if (passOrFail.getUpOrDown().equals(upOrDown) && !passOrFail.getValue()) {
            return FAIL_SIGN;
        }
        return EMPTY_SIGN;
    }

}
