package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";


    private int moveCount;
    private List<String> choice;
    private List<String> bridge;

    public Player(List<String> bridge) {
        moveCount = 1;
        choice = new ArrayList<String>();
        this.bridge = bridge;
    }

    public void move() {
        String moving = new InputView().readMoving();
        validateMoving(moving);
        choice.add(moving);
        OutputView.printMap(choice, this.bridge);
    }

    public boolean isSuccess() {
        int idx = choice.size() - 1;
        if ((choice.get(idx)).equals(this.bridge.get(idx))) {
            return true;
        }
        return false;
    }

    public boolean isCompleted() {
        if (choice.size() == this.bridge.size()) {
            return true;
        }
        return false;
    }

    public String retry() {
        String gameCommand = new InputView().readGameCommand();
        validateGameCommand(gameCommand);
        if (gameCommand.equals(RESTART)) {
            moveCount++;
            choice = new ArrayList<String>();
            return gameCommand;
        }
        return gameCommand;
    }

    public void complete() {
        OutputView.printGuide("최종 게임 결과");
        OutputView.printMap(choice, this.bridge);
        if (isSuccess()) {
            OutputView.printResult("성공", moveCount);
        }
        if (!isSuccess()) {
            OutputView.printResult("실패", moveCount);
        }

    }

    private void validateMoving(String moving) {
        if (!moving.equals(UP) && !moving.equals(DOWN)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D여야 합니다.");
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RESTART) && !gameCommand.equals(QUIT)) {
            throw new IllegalArgumentException("[ERROR] 재시도: R, 종료: Q 외에 다른 값을 입력했습니다.");
        }
    }
}
