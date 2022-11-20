package bridge.validator;

import java.util.regex.Pattern;

import static bridge.exception.InputException.*;

public class InputValidator {
    private static final Pattern ONLY_NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final Pattern BLOCK_FORMAT = Pattern.compile("^[UD]$");
    private static final Pattern GAME_RETRY_FORMAT = Pattern.compile("^[RQ]$");
    private static final int BLOCK_LENGTH = 1;


    private InputValidator() {
    }

    public static int checkBridgeSize(String size) {
        int bridgeSize = validateOnlyNumber(size);
        validateMinSize(bridgeSize);
        validateMaxSize(bridgeSize);
        return bridgeSize;
    }

    public static String checkBlock(String block) {
        validateOneLength(block);
        validateInputFormat(block, BLOCK_FORMAT);
        return block;
    }

    public static String checkGameRetry(String input) {
        validateOneLength(input);
        validateInputFormat(input, GAME_RETRY_FORMAT);
        return input;
    }

    private static int validateOnlyNumber(String input) {
        if (!ONLY_NUMBER_REGEX.matcher(input).matches()) {
            printNotOnlyNumberException();
        }
        return Integer.parseInt(input);
    }

    private static void validateMinSize(int size) {
        if (size < MIN_SIZE) {
            printNotMinSizeException();
        }
    }

    private static void validateMaxSize(int size) {
        if (size >= MAX_SIZE) {
            printNotMaxSizeException();
        }
    }

    private static void validateOneLength(String input) {
        if (input.length() != BLOCK_LENGTH) {
            printNotOnlyOneLengthException();
        }
    }

    private static void validateInputFormat(String block, Pattern format) {
        if (!format.matcher(block).matches()) {
            printNotFormatException();
        }
    }
}
