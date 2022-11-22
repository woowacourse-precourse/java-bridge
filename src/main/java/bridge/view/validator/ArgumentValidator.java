package bridge.view.validator;

import bridge.view.constants.Keyword;
import bridge.view.constants.OutputFormat;

import java.util.Arrays;

/**
 * 여러 조건에 따라 인자값의 유효성을 검증하는 클래스
 */
public class ArgumentValidator {

    private static final String REGEX_INTEGER = "^(0|-?[1-9][0-9]*)$";

    private ArgumentValidator() { }

    public static void validateIntegerInRange(int value, int minimum, int maximum) {
        if (value < minimum || value > maximum) {
            throw new IllegalArgumentException(String.format("%d부터 %d 사이의 정수를 입력하세요.", minimum, maximum));
        }
    }

    public static Keyword validateMatchedKeyword(String value, Keyword[] keywords) {
        return Arrays.stream(keywords)
                .filter(keyword -> keyword.getKey().equals(value))
                .findFirst()
                .orElseThrow(() -> {throw new IllegalArgumentException("주어진 값이 지정된 키워드가 아닙니다.");});
    }

    public static void validateInteger(String value) {
        if (!value.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException("주어진 값이 정수가 아닙니다.");
        }
    }

    public static void validateContentNotNull(Object content) {
        if (content == null) {
            throw new NullPointerException("출력할 정보의 값이 null입니다.");
        }
    }

    public static void validateFormatValueNotNull(OutputFormat format) {
        validateContentNotNull(format);
        if (format.getValue() == null) {
            throw new NullPointerException("출력할 형식의 값이 null입니다.");
        }
    }
}
