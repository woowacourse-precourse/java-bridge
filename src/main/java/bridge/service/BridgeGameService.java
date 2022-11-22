package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Command;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;
    private List<String> userMoving;
    private final String RESTART = "R";
    private final String EMPTY = "";

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
    * 게임을 위한 다리를 생성하는 메서드
     * @return List<String>
    * */
    public List<String> initializeGame() {
        OutputView.printStart();
        return bridgeMaker.makeBridge(getSize());
    }

    private int getSize() {
        int size = 0;
        while (size == 0) {
            try {
                OutputView.printInputBridgeSize();
                size = InputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return size;
    }

    /**
    * 사용자의 입력을 받으면서 다리 건너기 게임을 진행하는 메서드
     * @return Status
    * */
    public Status proceedGame(List<String> bridge) {
        userMoving = new ArrayList<>();
        while (bridge.size() > userMoving.size()) {
            userMoving.add(getMoving());
            OutputView.printMap(bridge, userMoving);
            if (!isSuccess(bridge, userMoving)) {
                return Status.FAIL;
            }
        }
        return Status.SUCCESS;
    }

    private String getMoving() {
        String moving = EMPTY;
        while (moving.equals(EMPTY)) {
            try {
                OutputView.printInputMoving();
                moving = InputView.readMoving();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return moving;
    }

    private boolean isSuccess(List<String> bridge, List<String> userMoving) {
        for (int index = 0; index < userMoving.size(); index++) {
            String bridgeValue = bridge.get(index);
            String userValue = userMoving.get(index);

            if (!bridgeValue.equals(userValue)) {
                return false;
            }
        }
        return true;
    }

    /**
    * 게임 재시도 여부를 입력받는 메서드
     * @return Command
    * */
    public Command restartGame() {
        if (getCommand().equals(RESTART)) {
            return Command.RESTART;
        }
        return Command.QUIT;
    }

    private String getCommand() {
        String command = EMPTY;
        while (command.equals(EMPTY)) {
            try {
                OutputView.printInputCommand();
                command = InputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return command;
    }

    /**
    * 최종 결과를 출력할 때 사용하는 메서드
    * */
    public void printResult(Status status, List<String> bridge, int attempt) {
        OutputView.printFinalGameResult();
        OutputView.printResult(bridge, userMoving);
        OutputView.printGameStatus(status);
        OutputView.printAllAttempts(attempt);
    }
}
