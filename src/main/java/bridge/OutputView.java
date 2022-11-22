package bridge;

public class OutputView {
    public static StringBuilder up = new StringBuilder();
    public static StringBuilder down = new StringBuilder();

    public void printMap(String state, boolean stop) {
        if (state.equals(Constant.UP)) moveUp(stop);
        if (state.equals(Constant.DOWN)) moveDown(stop);

        System.out.println(Constant.FRONT + up + Constant.BACK);
        System.out.println(Constant.FRONT + down + Constant.BACK);

        up.append(Constant.DELIMITER);
        down.append(Constant.DELIMITER);
    }
    
    public void printResult(boolean stop, int count) {
        System.out.println(Constant.RESULT_OF_GAME);
        System.out.println(Constant.FRONT + up.substring(0, up.length() - 2) + Constant.BACK);
        System.out.println(Constant.FRONT + down.substring(0, up.length() - 2) + Constant.BACK);
        if (!stop) System.out.println(Constant.RESULT_OF_TRY + Constant.WIN);
        if (stop) System.out.println(Constant.RESULT_OF_TRY + Constant.LOSE);
        System.out.println(Constant.TOTAL_TRY + count);
    }

    public void moveUp(boolean stop) {
        if (stop) {
            down.append(Constant.FAIL + Constant.SPACE);
            up.append(Constant.SPACE + Constant.SPACE);
        }

        if (!stop) {
            up.append(Constant.SUCCESS + Constant.SPACE);
            down.append(Constant.SPACE + Constant.SPACE);
        }
    }

    public void moveDown(boolean stop) {
        if (stop) {
            up.append(Constant.FAIL + Constant.SPACE);
            down.append(Constant.SPACE + Constant.SPACE);
        }

        if (!stop) {
            down.append(Constant.SUCCESS + Constant.SPACE);
            up.append(Constant.SPACE + Constant.SPACE);
        }
    }

    public void resetAll() {
        up.delete(0, up.length());
        down.delete(0, down.length());
    }
}
