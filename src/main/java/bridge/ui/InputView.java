package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Validate validate = new Validate();

    public int readBridgeSize() {
        while (true){
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            if (validate.isValidBridgeSize(input)){
                return (Integer.parseInt(input));
            }
        }
    }

    public String readMoving() {
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            if (validate.isValidReadMove(input)) {
                return (input);
            }
        }
    }

    public String readGameCommand() {
        while (true){
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            if (validate.isValidRetryCommand(input)){
                return (input);
            }
        }
    }
}
