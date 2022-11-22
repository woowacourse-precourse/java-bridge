package bridge;

import bridge.enums.MoveCommand;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, int idx) {
        printUp(bridgeGame, idx);
        printDown(bridgeGame, idx);
    }

    public void printWrongMap(BridgeGame bridgeGame, int idx, String moving) {
        printWrongUp(bridgeGame, idx, moving);
        printWrongDown(bridgeGame, idx, moving);
    }

    public void printWrongUp(BridgeGame bridgeGame, int idx, String moving) {
        String up = "[";
        for (int i = 0; i < idx; i++) {
            up += addUp(bridgeGame.getBridge().get(i));
            if (i < idx-1) {
                up += "|";
            }
        }
        printWrongUpResult(up, moving);
    }

    public void printWrongDown(BridgeGame bridgeGame, int idx, String moving) {
        String down = "[";
        for (int i = 0; i < idx; i++) {
            down += addDown(bridgeGame.getBridge().get(i));
            if (i < idx-1) {
                down += "|";
            }
        }
        printWrongDownResult(down, moving);
    }

    private String addBar(String st) {
        if (st.length() > 1) {
            return st + "|";
        }

        return st;
    }

    private void printWrongUpResult(String up, String moving) {
        if (moving.equals(MoveCommand.UP.getCommand())) {
            up = addBar(up);
            System.out.println(up + " X " + "]");
            return;
        }
        up = addBar(up);
        System.out.println(up + "   " + "]");
    }

    private void printWrongDownResult(String down, String moving) {
        if (moving.equals(MoveCommand.DOWN.getCommand())) {
            down = addBar(down);
            System.out.println(down + " X " + "]");
            return;
        }
        down = addBar(down);
        System.out.println(down + "   " + "]");
    }

    private void printUp(BridgeGame bridgeGame, int idx) {
        String up = "[";
        for (int i = 0; i < idx; i++) {
            up += addUp(bridgeGame.getBridge().get(i));
            if (i < idx-1) {
                up += "|";
            }
        }
        printUpResult(up);
    }

    private void printUpResult(String up) {
        System.out.println(up + "]");
    }

    private void printDown(BridgeGame bridgeGame, int idx) {
        String down = "[";
        for (int i = 0; i < idx; i++) {
            down += addDown(bridgeGame.getBridge().get(i));
            if (i < idx-1) {
                down += "|";
            }
        }
        printDownResult(down);
    }

    private void printDownResult(String down) {
        System.out.println(down + "]");
    }

    private String addUp(String curr) {
        if (curr.equals(MoveCommand.UP.getCommand())) {
            return " O ";
        }

        return "   ";
    }

    private String addDown(String curr) {
        if (curr.equals(MoveCommand.DOWN.getCommand())) {
            return " O ";
        }

        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, int idx) {
        printMap(bridgeGame, idx);
    }
}
