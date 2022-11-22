package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int count;
    private int location;
    private Boolean result;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.count = 0;
        this.location = 0;
        this.result = true;
    }

    public List<String> getBridge() {
        return this.bridge;
    }
    public int getCount() {
        return this.count;
    }
    public int getLocation() {
        return this.location;
    }
    public Boolean getResult() {
        return this.result;
    }

    public void checkMovable(String moving) {
        if (this.bridge.get(location).equals(moving)) {
            OutputView.printMap(this);
            move();
        }
        else {
            this.result = false;
            OutputView.printMap(this);
            retry(InputView.readGameCommand());
        }
    }

    private void checkEnd() {
        if (this.bridge.size() == location) {
            this.count++;
            this.location--;
            System.out.println("최종 게임 결과");
            OutputView.printMap(this);
            OutputView.printResult(this);
        }
        else {
            checkMovable(InputView.readMoving());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        this.location++;
        checkEnd();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if(gameCommand.equals("R")){
            this.result = true;
            this.count++;
            checkMovable(InputView.readMoving());
        }
        else if (gameCommand.equals("Q")){
            System.out.println("최종 게임 결과");
            OutputView.printMap(this);
            OutputView.printResult(this);
        }
    }
}
