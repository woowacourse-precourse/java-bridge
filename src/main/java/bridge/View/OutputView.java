package bridge.View;

import bridge.Constant.Constant;

public class OutputView {
    public static StringBuilder up = new StringBuilder();
    public static StringBuilder down = new StringBuilder();

    public void printMap(String state, boolean stop) {
        if (state.equals(Constant.Up)) moveUp(stop);
        if (state.equals(Constant.Down)) moveDown(stop);

        System.out.println(Constant.Front + up + Constant.Back);
        System.out.println(Constant.Front + down + Constant.Back);

        up.append(Constant.Delimiter);
        down.append(Constant.Delimiter);
    }
    
    public void printResult(boolean stop, int count) {
        System.out.println(Constant.Result_of_game);
        System.out.println(Constant.Front + up.substring(0, up.length() - 1) + " " + Constant.Back);
        System.out.println(Constant.Front + down.substring(0, up.length() - 1) + " " + Constant.Back);
        if (!stop) System.out.println(Constant.Result_of_try + Constant.Win);
        if (stop) System.out.println(Constant.Result_of_try + Constant.Lose);
        System.out.println(Constant.Total_Try + count);
    }

    public void moveUp(boolean stop) {
        if (stop) {
            down.append(Constant.Fail + Constant.Space);
            up.append(Constant.Space + Constant.Space);
        }

        if (!stop) {
            up.append(Constant.Success + Constant.Space);
            down.append(Constant.Space + Constant.Space);
        }
    }

    public void moveDown(boolean stop) {
        if (stop) {
            up.append(Constant.Fail + Constant.Space);
            down.append(Constant.Space + Constant.Space);
        }

        if (!stop) {
            down.append(Constant.Success + Constant.Space);
            up.append(Constant.Space + Constant.Space);
        }
    }

    public void ResetAll() {
        up.delete(0, up.length());
        down.delete(0, down.length());
    }
}
