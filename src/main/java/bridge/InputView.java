package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int number;
        while (true) {
            try {
                number = tryInput();
                break;
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return number;
    }

    public static int tryInput(){
        int number;
        try {
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            number = Integer.parseInt(input);
            validate(number);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static void validate(int number) {
        if (number < 3 || 20 < number) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

