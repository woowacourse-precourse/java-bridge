package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private List<String> up = new ArrayList<>();
    private List<String> down = new ArrayList<>();
    private int index = 0;
    private int r = 1;
    private boolean isSuccess = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (moving.equals(bridge.get(index))) {
            if (moving.equals("U")) {
                up.add("O");
                down.add(" ");
            }
            else if (moving.equals("D")) {
                up.add(" ");
                down.add("O");
            }
            index++;
            if (index >= bridge.size()) {
                outputView.printMap(up, down);
                isSuccess = true;
                return false;
            }
            outputView.printMap(up, down);
            return true;
        }
        if (moving.equals("U")) {
            up.add("X");
            down.add(" ");
        }
        else if (moving.equals("D")) {
            down.add("X");
            up.add(" ");
        }
        outputView.printMap(up, down);
        isSuccess = false;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (isSuccess) {
            System.out.println("최종 게임 결과");
            outputView.printMap(up, down);
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + r);
            return false;
        }
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = inputView.readGameCommand();
        if (command.equals("R")) {
            r++;
            up = new ArrayList<>();
            down = new ArrayList<>();
            return true;
        }
        System.out.println("최종 게임 결과");
        outputView.printMap(up, down);
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + r);

        return false;
    }
}
