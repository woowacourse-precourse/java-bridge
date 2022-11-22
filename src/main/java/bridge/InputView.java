package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR="[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_UD="[ERROR] 이동할 칸의 입력은 U,D 둘중 하나만 입력해야합니다.";
    private static final String ERROR_RQ="[ERROR] 게임의 재시작 여부 입력은 R,Q 둘중 하나만 입력해야합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
        try{
            String Input=Console.readLine();
            return checkError(Input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            continue;
        }
    }
    }

    public int checkError(String Input) {
        isNumber(Input);
        int size = Integer.parseInt(Input);
        isRange(size);
        System.out.println();
        return size;
    }

    public void isNumber(String Input) {
        try {
            Double.parseDouble(Input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public void isRange(int Size) {
        if (!(Size >= 3 && Size <= 20)) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String Input = Console.readLine();
                return isUD(Input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public String isUD(String Input) {
        if (!(Input.equals("U") || Input.equals("D"))) {
            throw new IllegalArgumentException(ERROR_UD);
        }
        return Input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true){
            try{
        String regame=Console.readLine();
        return isRQ(regame);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
    }
    }

    public String isRQ(String Input) {
        if (!(Input.equals("R") || Input.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_RQ);
        }
        return Input;
    }
}
