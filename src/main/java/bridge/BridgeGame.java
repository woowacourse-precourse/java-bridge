package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> startGame() {
        Map<String, String> result = new HashMap<>();
        int count = 0;

        do {
            giveResult(result,++count);
        } while (endGame(result.get("success")));

        return result.values().stream().sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(StringBuilder up, StringBuilder down) {
        for (String now : bridge) {
            boolean same = checkUpAndDown(up, down, now);
            outputView.printMap(up, down);

            if (!same) return false;
        }

        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String command = inputView.getCommand();

        return command.equals("R");
    }

    private boolean endGame(String success) {
        if (success.equals("성공")) return false;
        return retry();
    }

    private void giveResult(Map<String, String> result, int count) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();

        result.put("success", outputView.castSuccess(move(up, down)));
        result.put("output", outputView.castMap(up, down));
        result.put("count", String.valueOf(count));
    }


    private boolean checkUpAndDown(StringBuilder up, StringBuilder down, String now) {
        String move = inputView.getMoving();
        boolean same = move.equals(now);

        addSideBar(up, down);

        up.append(addOX("U", move, same));
        down.append(addOX("D", move, same));

        return same;
    }

    private void addSideBar(StringBuilder up, StringBuilder down) {
        if (up.length() != 0) up.append("|");
        if (down.length() != 0) down.append("|");
    }

    private String addOX(String position, String move, boolean same) {
        if (!position.equals(move)) return "   ";
        if (!same) return " X ";
        return " O ";
    }

}
