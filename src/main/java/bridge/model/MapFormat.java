package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public enum MapFormat {

    FORMAT("[ ", " | ", " ]");
    private final String start;
    private final String delimiter;
    private final String end;

    MapFormat(String start, String delimiter, String end) {
        this.start = start;
        this.delimiter = delimiter;
        this.end = end;
    }

    public List<String> convertToFormatStrings(List<List<String>> maps) {
        return maps.stream()
                .map(this::convertToFormatString)
                .collect(Collectors.toList());
    }
    private String convertToFormatString(List<String> map) {
        return start + String.join(delimiter, map) + end;
    }
}
