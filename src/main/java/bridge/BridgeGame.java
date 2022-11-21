package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> up = new ArrayList<>();
    private static List<String> down = new ArrayList<>();
    public int count = 0;

    public static List<String> getUp() {
        return up;
    }

    public static List<String> getDown() {
        return down;
    }

    public int getCount() {
        return count;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(String up_Down, List<String> bridgeCheck) {
        boolean check = true;
        if (up_Down.equals(bridgeCheck.get(0))) {
            make(up_Down, "O");
        }
        if (!up_Down.equals(bridgeCheck.get(0))) {
            make(up_Down, "X");
            check = false;
        }
        return check;
    }

    public void makeList(String check) {
        if (!up.isEmpty()) {
            up.add(String.format(" %s ", check));
            down.add("   ");
        }
        if (up.isEmpty()) {
            up.add(String.format("[ %s ", check));
            down.add("[   ");
        }
        this.up = up;
        this.down = down;
    }

    public void makeList2(String check) {
        if (!down.isEmpty()) {
            up.add("   ");
            down.add(String.format(" %s ", check));
        }
        if (down.isEmpty()) {
            up.add("[   ");
            down.add(String.format("[ %s ", check));
        }
        this.up = up;
        this.down = down;
    }

    public void make(String userMove, String check) {
        OutputView opv = new OutputView();
        if (userMove.equals("U")) {
            makeList(check);
        }
        if (userMove.equals("D")) {
            makeList2(check);
        }
        opv.printMap(String.join("|", up), String.join("|", down));

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        up.remove(up.size() - 1);
        down.remove(down.size() - 1);
        count++;
    }
}
