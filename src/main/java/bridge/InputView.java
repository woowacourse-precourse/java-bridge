package bridge;

import java.util.ArrayList;
import java.util.List;


import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */



    public static int readBridgeSize(){
        String input = readLine();
        int inputToint = Integer.parseInt(input);
        if(inputToint > 2 && inputToint < 21){

            return inputToint;
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(List<Integer> player) {
        String readMovingToString = readLine();
        for (int index = 0; index < player.size(); index++) {
            if (player.equals("U")) {
                readMovingToString.contains("U");
            }
            if (player.equals("D")) {
                readMovingToString.contains("D");
                System.out.println(readMovingToString);
            }
        }
        return readMovingToString;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(List<String> player) {

        String readGameCommandInput = readLine();
        if(!readGameCommandInput.matches("(R|Q){1}")){
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.");
        }
        return readGameCommandInput;
    }
}
