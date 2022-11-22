package bridge.Vaildator;

public class VaildatorUpDown {

    public static String userInputUpDown;
    public VaildatorUpDown(String userInputUpDown) {
        this.userInputUpDown = userInputUpDown;
        vaildate();
    }

    private void vaildate() {
        vaildateUD();

    }

    private void vaildateUD() {
        if (!(userInputUpDown.equals("U")|| userInputUpDown.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.");
        }

    }
}
