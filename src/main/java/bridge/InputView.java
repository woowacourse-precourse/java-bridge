package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize =0 ;
        try {

            bridgeSize= Integer.parseInt(Console.readLine());

            validSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        }
        return bridgeSize;
    }

    private void validSize(int brigeSize) {

        if ((brigeSize < 3) || (brigeSize > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택하주세요. (위: U, 아래: D)");
        String moving = Console.readLine();

        validChar(moving,"U","D");
        return moving;
    }

    public void validChar(String word, String valid1, String valid2){
        if(word.length()!=1){
            throw new IllegalArgumentException("[ERROR] 한 글자만 입력 가능");

        }

        if(!(word.equals(valid1))&& !(word.equals(valid2))){
            throw new IllegalArgumentException("[ERROR] "+valid1 +"와 " +valid2 +"만 입력가능!");
        }

    }



    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        validChar(command, "R","Q");
        return command;
    }


}
