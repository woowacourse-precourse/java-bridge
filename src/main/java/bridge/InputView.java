package bridge;
import camp.nextstep.edu.missionutils.Console;



public class InputView {
    private static final String START_BRIDGE_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String CHOOSE_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위 : U, 아래 : D)";
    private static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private int bridgeSize = 0;
    private String input = "";
    private String retry = "";
    private String moving = "";

    public void readBridgeSize() {
        System.out.println(START_BRIDGE_MESSAGE);
        while(true) {
            try {
                System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
                input = Console.readLine();
                checkCorrectLength(input);
                this.bridgeSize = Integer.parseInt(input);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    public void checkCorrectLength(String input) {
        int tempNum = Integer.parseInt(input);

        if(tempNum < 3 || tempNum > 20) {
            throw new IllegalArgumentException("[ERROR] 길이는 3이상 20 이하여야 합니다.");
        }
        for(int i = 0; i < input.length();i++) {
            char tmp = input.charAt(i);
            if(Character.isDigit(tmp) == false) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }


    public void readMoving() {
        while(true) {
            try {
                System.out.println(CHOOSE_MOVING_MESSAGE);
                this.moving = Console.readLine();
                checkCorrectMoving(this.moving);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
        }
    }

    public void checkCorrectMoving(String moving) {
        if(moving.indexOf(0) != 'U' || moving.indexOf(0) != 'D') {
            throw new IllegalArgumentException("[ERROR] U나 D가 입력되어야 합니다.");
        }
    }

    public String getReadMoving() {
        return this.moving;
    }

    public void readGameCommand() {
        while(true) {
            try {
                System.out.println(RETRY_MESSAGE);
                this.retry = Console.readLine();
                checkCorrectRetry(this.retry);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("다시 입력해 주세요.");
                continue;
            }
        }
    }

    public void checkCorrectRetry(String retry) {
        if(retry.indexOf(0) != 'R' || retry.indexOf(0) != 'Q') {
            throw new IllegalArgumentException("[ERROR] R이나 Q가 입력되어야 합니다");
        }
    }

    public String getReadGameCommand() {
        return this.retry;
    }
}
