package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.print("다리 건너기 게임을 시작합니다.\n\n");
        System.out.println("다리 길이를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String result = Console.readLine();
        validationMoving(result);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String result = Console.readLine();
        validationGamieCommand(result);
        return result;
    }

    private void validationMoving(String moving){
        if(!Objects.equals(moving, "U") && !Objects.equals(moving, "D")){
            throw new IllegalArgumentException("[ERROR] 입력값이 잘못됐습니다.");
        }
    }

    private void validationGamieCommand(String gameCommand){
        if(!Objects.equals(gameCommand, "R") && !Objects.equals(gameCommand, "Q")){
            throw new IllegalArgumentException("[ERROR] 입력값이 잘못됐습니다.");
        }
    }
}
