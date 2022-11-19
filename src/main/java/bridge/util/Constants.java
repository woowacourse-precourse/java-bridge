package bridge.util;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern BRIDGE_SIZE_REGEX = Pattern.compile("^[0-9]*$");

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

}
