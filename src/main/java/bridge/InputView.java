package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Constant constant = new Constant();
    RandomNumber randomNumber = new RandomNumber();


    /**
     * 다리의 길이를 입력받는다.
     * 3이상 20이하
     */
    public List<Integer> readBridgeSize() {


        String inputUser = Console.readLine();
        int userNumber = Integer.parseInt(inputUser);

        if (userNumber < 3 || userNumber > 20) {
            throw new IllegalArgumentException(constant.getError());
        }

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < userNumber; i++) {
            number.add(randomNumber.randomNumber(userNumber));

        }

        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * 올바른값 아니면 예외
     */
    public String readMoving() {

        System.out.println(constant.getMoving());
        String inputUser = Console.readLine();


        if (inputUser == "U") {

            return "U";
        } else if (inputUser == "D") {

            return "D";
        }


        throw new IllegalArgumentException(constant.getError());


    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * 올바른값 아니면 예외
     */
    public boolean readGameCommand() {
        System.out.println(constant.getReGame());
        String inputUser = Console.readLine();
        char column = inputUser.charAt(0);
        if (column == 'R') {

            return true;

        }
        if (column == 'Q') {

            return false;
        }

        throw new IllegalArgumentException(constant.getError());
    }

}
