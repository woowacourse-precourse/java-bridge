package bridge;

import camp.nextstep.edu.missionutils.Console;

import javax.sound.midi.SysexMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        try {
            size = Integer.parseInt(Console.readLine());


        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력가능 합니다.");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String choice = Console.readLine();
        ChoiceCheck(choice);
        return choice;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String Retry = Console.readLine();
        RetryCheck(Retry);
        return Retry;
    }

    private void ChoiceCheck (String choice) {
        if (!choice.equals("U") && !choice.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해야 합니다.");
        }
    }

    private void RetryCheck (String Retry) {
        if (!Retry.equals("R") && !Retry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야 합니다.");
        }
    }
}
