package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private final Validator validator;
    private final OutputView outputView;

    public InputView(Validator validator, OutputView outputView) {
        this.validator = validator;
        this.outputView = outputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printMessage(Messages.VIEW_BRIDGE_SIZE);
        String userInput = "";

        userInput = readBridgeSizeUntilCollectFormat(userInput);

        return Integer.parseInt(userInput);
    }

    public String readBridgeSizeUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateBridgeSize(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMessage(Messages.VIEW_SELECT_UP_DOWN);
        String userInput = "";

        userInput = readMoveUntilCollectFormat(userInput);

        return userInput;
    }

    public String readMoveUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateMove(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printMessage(Messages.VIEW_RETRY);
        String userInput = "";

        userInput = readGameCommandUntilCollectFormat(userInput);

        return userInput;
    }

    public String readGameCommandUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateGameCommand(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }


    public String readInput() {
        String userInput = Console.readLine();
        return userInput;
    }
}
