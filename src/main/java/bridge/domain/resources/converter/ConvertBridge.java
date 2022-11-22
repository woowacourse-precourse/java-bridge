package bridge.domain.resources.converter;

import bridge.constant.Constant;

public class ConvertBridge {

    public static String toUpOrDown(final Integer input) {
        if (input == 1)
            return Constant.UP.getValue();
        if (input == 0)
            return Constant.DOWN.getValue();
        return null;
    }

}

