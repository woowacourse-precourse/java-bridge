package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final Validation validation;
    private final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public InputView(Validation validation) {
        this.validation = validation;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        Integer size = -1;
        while(size == -1) {
            try {
                String bridgeSize = Console.readLine();
                validation.bridgeLen(bridgeSize);
                size = Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String command = "init";
        while(command.equals("init")) {
            try {
                String temp = Console.readLine();
                validation.moveCommand(temp);
                command = temp;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            return command;
        }
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        String command = "init";
        while(command.equals("init")) {
            try {
                String temp = Console.readLine();
                validation.retryCommand(temp);
                command = temp;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            return command;
        }
        return command;
    }
}
