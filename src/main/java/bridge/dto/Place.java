package bridge.dto;

import bridge.util.StringUtils;

import java.util.regex.Pattern;

public class Place {
    private static final String PLACE_PATTERN = "^[U|D]$";
    private static final String BLANK_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    private static final String VALUE_EXCEPTION_MESSAGE = "U 또는 D 만 입력할 수 있습니다.";

    private final String place;

    public Place(String place) {
        validate(place);
        this.place = place;
    }

    private static void validate(final String place) {
        validateByBlank(place);
        validateByValue(place);
    }

    private static void validateByValue(final String place) {
        if (!Pattern.matches(PLACE_PATTERN, place)) {
            throw new IllegalArgumentException(VALUE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateByBlank(final String place) {
        if (StringUtils.isBlank(place)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public String getPlace() {
        return place;
    }
}
