package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class MapMaker {
    private static final String BLANK = " ";
    private static final String SUCCESS_CODE = "O";
    private static final String FAIL_CODE = "X";
    private static final String DELIMITER = "|";
    private static final String PREFIX_BRACKET = "[";
    private static final String SUFFIX_BRACKET = "]";


    public List<String> makeMap(List<String> movementRecord, boolean hasMoved) {
        StringBuilder topLine = new StringBuilder();
        StringBuilder bottomLine = new StringBuilder();
        for (int index = 0; index < movementRecord.size(); index++) {
            drawMovement(topLine, bottomLine, movementRecord.get(index));
        }
        replaceFailMark(topLine, hasMoved);
        replaceFailMark(bottomLine, hasMoved);
        return new ArrayList<>(Arrays.asList(toMap(topLine), toMap(bottomLine)));
    }

    private void drawMovement(StringBuilder topLine, StringBuilder bottomLine, String movement) {
        if (movement.equals(Direction.Code.UP.getName())) {
            topLine.append(SUCCESS_CODE);
            bottomLine.append(BLANK);
        }
        if (movement.equals(Direction.Code.DOWN.getName())) {
            topLine.append(BLANK);
            bottomLine.append(SUCCESS_CODE);
        }
    }

    private void replaceFailMark(StringBuilder line, boolean hasMoved) {
        int endOfLineIndex = line.length() - 1;
        if (!hasMoved && String.valueOf(line.charAt(endOfLineIndex)).equals(SUCCESS_CODE)) {
            line.replace(endOfLineIndex, endOfLineIndex + 1, FAIL_CODE);
        }
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

