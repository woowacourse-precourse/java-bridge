package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printBridgeSizeInput();
        String input = readLine();
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]");
        }
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20){
            throw new IllegalArgumentException("[ERROR]");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMovingInput();
        String input = readLine();
        if (!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException();}
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printGameOver();
        String input = readLine();
        if (!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException();}
        return input;
    }

}

