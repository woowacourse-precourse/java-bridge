package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static Validation validation = new Validation();
    private final static String startMessage = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";
    private final static String bridgeSizeErrorMessage = "[ERROR] 3 ~ 20 사이의 값을 입력해야 합니다. 다시 입력해주세요.";
    private final static String moveCommandErrorMessage = "[ERROR] 입력값은 U, D 만 입력 가능합니다. 다시 입력해주세요.(위: U, 아래: D )";
    private final static String moveSelectMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String retryMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String retryErrorMessage = "[ERROR] 입력값은 R, Q 만 입력 가능합니다. 다시 입력해주세요.(재시도: U, 종료: D )";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println(startMessage);
        boolean reInput = true;
        String bridgeSize = "";

        while (reInput) {
            bridgeSize = Console.readLine();
            reInput = checkValidationOfBridgeSize(bridgeSize);
        }
        return Integer.parseInt(bridgeSize);
    }

    public boolean checkValidationOfBridgeSize(String bridgeSize) {
        try {
            validation.checkIntegrationBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(bridgeSizeErrorMessage);
            return true;
        } catch (NullPointerException e) {
            System.out.println(bridgeSizeErrorMessage);
            return true;
        }
        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        System.out.println(moveSelectMessage);
        boolean reInput = true;
        String inputMoveCommand = "";
        while (reInput) {
            inputMoveCommand = Console.readLine();
            reInput = checkValidationOfMoveCommand(inputMoveCommand);
        }

        return inputMoveCommand;
    }

    public boolean checkValidationOfMoveCommand(String inputMoveCommand) {

        try {
            validation.checkIntegrationMoveCommand(inputMoveCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(moveCommandErrorMessage);
            return true;
        } catch (NullPointerException e) {
            System.out.println(moveCommandErrorMessage);
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        System.out.println(retryMessage);
        boolean reInput = true;
        String inputGameCommand = "";
        while (reInput) {
            inputGameCommand = Console.readLine();
            reInput = checkValidationOfGameCommand(inputGameCommand);
        }
        return inputGameCommand;
    }

    public boolean checkValidationOfGameCommand(String inputGameCommand) {
        try {
            validation.checkIntegrationGameCommand(inputGameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(retryErrorMessage);
            return true;
        } catch (NullPointerException e) {
            System.out.println(retryErrorMessage);
            return true;
        }
        return false;
    }
}