package bridge.util;

public class StringBufferUtility {

    public static void popLastCharacter(StringBuffer stringBuffer) {
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
