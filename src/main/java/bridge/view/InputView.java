package bridge.view;


import bridge.service.InputHandlerImpl;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    InputHandlerImpl inputHandler;
    public InputView() {
        this.inputHandler = new InputHandlerImpl();
    }

    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n\n");
        System.out.println("다리의 길이를 입력해주세요.");
        String rawInput = Console.readLine();
        return inputHandler.getBridgeSize(rawInput);
    }


    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String rawInput = Console.readLine();
        return inputHandler.getMovingCommand(rawInput);
    }


    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String rawInput = Console.readLine();
        return inputHandler.getGameCommand(rawInput);
    }
}
