package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeMap {
    private static final String BLANK = " ";
    private static final String SUCCESS_CODE = "O";
    private static final String FAIL_CODE = "X";
    private static final String DELIMITER = "|";
    private static final String PREFIX_BRACKET = "[";
    private static final String SUFFIX_BRACKET = "]";

    private String top;
    private String bottom;

    public BridgeMap(List<String> userBridgeHistroy, boolean hasMoved) {
        makeMap(userBridgeHistroy, hasMoved);
    }

    private void makeMap(List<String> userBridgeHistroy, boolean hasMoved) {
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        for (int i = 0; i < userBridgeHistroy.size(); i++) {
            addHistory(top, bottom, userBridgeHistroy.get(i));
        }
        checkResult(top, hasMoved);
        checkResult(bottom, hasMoved);
        this.top = toMap(top);
        this.bottom = toMap(bottom);
    }

    public List<String> getMap() {
        List<String> map = new ArrayList<>();
        map.add(top);
        map.add(bottom);
        return map;
    }

    private String toMap(CharSequence result) {
        String map = sperateByDelimiter(result, DELIMITER);
        map = addBracket(map, PREFIX_BRACKET, SUFFIX_BRACKET);
        return sperateByDelimiter(map, BLANK);

    }

    public String sperateByDelimiter(CharSequence charSequence, String delimiter) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for (int i = 0; i < charSequence.length(); i++) {
            stringJoiner.add(String.valueOf(charSequence.charAt(i)));
        }
        return stringJoiner.toString();
    }

    public String addBracket(CharSequence charSequence, String prefix, String suffix) {
        return prefix + charSequence + suffix;
    }

    private void addHistory(StringBuilder top, StringBuilder bottom, String moving) {
        if (moving.equals(Direction.Code.UP.getName())) {
            top.append(SUCCESS_CODE);
            bottom.append(BLANK);
        }
        if (moving.equals(Direction.Code.DOWN.getName())) {
            top.append(BLANK);
            bottom.append(SUCCESS_CODE);
        }
    }

    private void checkResult(StringBuilder line, boolean didmove) {
        int endIndex = line.length() - 1;
        if (!didmove && String.valueOf(line.charAt(endIndex)).equals(SUCCESS_CODE)) {
            line.replace(endIndex, endIndex + 1, FAIL_CODE);
        }
    }
}

