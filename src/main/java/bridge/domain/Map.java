package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Map {
    private static final String BLANK = " ";
    private static final String SUCCESS_CODE = "O";
    private static final String FAIL_CODE = "X";
    private static final String DELIMITER = "|";
    private static final String PREFIX_BRACKET = "[";
    private static final String SUFFIX_BRACKET = "]";

    private static final int NOT_EXIST = -1;

    private StringBuilder topLine = new StringBuilder();
    private StringBuilder bottomLine = new StringBuilder();


    public void drawMovement(String movement) {
        if (movement.equals(Direction.Code.UP.getName())) {
            topLine.append(SUCCESS_CODE);
            bottomLine.append(BLANK);
        }
        if (movement.equals(Direction.Code.DOWN.getName())) {
            topLine.append(BLANK);
            bottomLine.append(SUCCESS_CODE);
        }
    }

    public void replaceLastToFailMark(boolean hasMoved) {
        int endOfLineIndex = topLine.length() - 1;
        if (!hasMoved && String.valueOf(topLine.charAt(endOfLineIndex)).equals(SUCCESS_CODE)) {
            topLine.replace(endOfLineIndex, endOfLineIndex + 1, FAIL_CODE);
        }
        if (!hasMoved && String.valueOf(bottomLine.charAt(endOfLineIndex)).equals(SUCCESS_CODE)) {
            bottomLine.replace(endOfLineIndex, endOfLineIndex + 1, FAIL_CODE);
        }
    }

    public int getLength() {
        return topLine.length();
    }

    public void clear() {
        topLine.setLength(0);
        bottomLine.setLength(0);
    }

    public boolean hasFailMark() {
        if (topLine.indexOf(FAIL_CODE) == NOT_EXIST) {
            return false;
        }
        if (bottomLine.indexOf(FAIL_CODE) == NOT_EXIST) {
            return false;
        }
        return true;
    }

    public List<String> getMap() {
        List<String> map = new ArrayList<>();
        map.add(toMap(topLine));
        map.add(toMap(bottomLine));
        return map;
    }

    public String toMap(CharSequence result) {
        String map = sperateByDelimiter(result, DELIMITER);
        map = addBracket(map, PREFIX_BRACKET, SUFFIX_BRACKET);
        return sperateByDelimiter(map, BLANK);

    }

    public String sperateByDelimiter(CharSequence charSequence, String delimiter) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for (int index = 0; index < charSequence.length(); index++) {
            stringJoiner.add(String.valueOf(charSequence.charAt(index)));
        }
        return stringJoiner.toString();
    }

    public String addBracket(CharSequence charSequence, String prefix, String suffix) {
        return prefix + charSequence + suffix;
    }

}
