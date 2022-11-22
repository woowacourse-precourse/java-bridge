package bridge.view;

import bridge.util.ExceptionPhrases;
import bridge.util.OutputPharses;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final OutputView outputView = new OutputView();
    private int bridgeSize;
    private String playerMove;
    private String gameCommand;

    /**
     * 입력받는 다리의 사이즈 확인 후 예외 발생 시 다시 입력 받는 함수
     */
    public void readBridgeSize() {
        try {
            outputView.printInfo(OutputPharses.BRIDGE_LENGTH_MSG.getMsg());
            bridgeSize = inputBridgeSize();
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
        } catch (IllegalArgumentException exception) {
            outputView.printInfo(exception.getMessage());
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
            readBridgeSize();
        }
    }


    /**
     * 입력받는 플레이어의 이동 확인 후 예외 발생 시 다시 입력 받는 함수
     */
    public void readMoving() {
        try{
            outputView.printInfo(OutputPharses.MOVE_MSG.getMsg());
            playerMove = inputMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printInfo(exception.getMessage());
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
            readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력하여 예외 발생 시 다시 입력 받는다.
     */
    public void readGameCommand() {
        try {
            outputView.printInfo(OutputPharses.RESTART_MSG.getMsg());
            gameCommand = inputGameStatus();
        } catch (IllegalArgumentException exception) {
            outputView.printInfo(exception.getMessage());
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
            readGameCommand();
        }
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public String getGameCommand() {
        return gameCommand;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize() {
        String userInput = readUserInput();
        InputException.userInputEmptyException(userInput);
        InputException.notNumberException(userInput);

        int userInputNumber = Integer.parseInt(userInput);
        InputException.outOfBridgeSizeException(userInputNumber);
        return userInputNumber;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputMoving() {
        String userInput = readUserInput();
        InputException.userInputEmptyException(userInput);
        InputException.notMoveCommandException(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputGameStatus() {
        String userInput = readUserInput();
        InputException.userInputEmptyException(userInput);
        InputException.notGameCommandException(userInput);
        return userInput;
    }
}
