package bridge.convertor;

import bridge.message.ErrorMessage;

public class InputConvertor {
    public static int inputParseNumber(String data) throws IllegalArgumentException {
        return Integer.parseInt(data);
    }
}
