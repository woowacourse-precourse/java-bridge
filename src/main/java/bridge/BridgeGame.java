package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> bridge;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame(List<String> bridge) {
        this.bridge = bridge;
        int count = 0;
        while(move(new StringBuilder(), new StringBuilder()) || retry()){
            count++;
        }

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(StringBuilder up, StringBuilder down) {

        for (String now : bridge) {
            boolean tf = addUpAndDown(up, down, now);
            outputView.printMap(up, down);

            if (!tf) return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String command = inputView.readGameCommand();
        return command.equals("R");
    }


    private boolean addUpAndDown(StringBuilder up, StringBuilder down, String now) {
        String move = inputView.readMoving();
        boolean tf = move.equals(now);

        addSideBar(up, down);
        up.append(addOX("U", move, tf));
        down.append(addOX("D", move, tf));

        return tf;
    }

    private void addSideBar(StringBuilder up, StringBuilder down) {
        if (up.length() != 0) up.append("|");
        if (down.length() != 0) down.append("|");
    }

    private String addOX(String position, String move, boolean tf) {
        if (!position.equals(move)) {
            return "   ";
        }
        if (!tf) {
            return " X ";
        }
        return " O ";
    }

}
