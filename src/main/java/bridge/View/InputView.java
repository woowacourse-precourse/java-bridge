package bridge.View;

import bridge.Model.WrappingType.BridgeSize;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.Command;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public BridgeSize readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String number = readLine();
        int size;
        try {
            size = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("올바른 값을 입력해주세요");
        }

        return new BridgeSize(size);
    }

    public ChoiceDirection readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String choiceDirection = readLine();

        return new ChoiceDirection(choiceDirection);
    }

    public Command readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = readLine();

        return new Command(command);
    }
}
