package bridge.common.utils;

public class StringUtils {
	private static final String NUMBER_REGEX = "\\d+";
	private static final String MOVING_REGEX = "^[U|D]$";

	public static boolean hasText(final String str) {
		return (str != null && !str.isEmpty() && containsText(str));
	}

	private static boolean containsText(final CharSequence str) {
		int strLen = str.length();

		for (int i = 0; i < strLen; ++i) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	public static boolean isNumeric(final String str) {
		return str.matches(NUMBER_REGEX);
	}

	public static boolean isUpOrDown(final String str) {
		return str.matches(MOVING_REGEX);
	}
}
