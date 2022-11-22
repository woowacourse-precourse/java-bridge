package bridge.Vaildator;

import bridge.Constant;

public class VaildatorUpDown {

    private static String userInputUpDown;

    public VaildatorUpDown(String userInputUpDown) {
        this.userInputUpDown = userInputUpDown;
        vaildate();
    }

    private void vaildate() {
        vaildateUD();

    }

    private void vaildateUD() {
        if (!(userInputUpDown.equals(Constant.UP) || userInputUpDown.equals(Constant.DOWN))) {
            throw new IllegalArgumentException(Constant.ERROR + Constant.INPUT_WRONG_UP_DOWN_SELECT);
        }

    }

    public static String getUserInputUpDown(){
        return userInputUpDown;
    }
}
