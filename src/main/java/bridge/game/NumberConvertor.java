package bridge.game;

import bridge.status.UpDown;

public class NumberConvertor {

    public String convert(int number) {
        if (number == 1) {
            return UpDown.UP.getValue();
        }
        return UpDown.DOWN.getValue();
    }

}
