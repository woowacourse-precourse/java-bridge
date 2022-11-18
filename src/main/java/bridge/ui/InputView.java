package bridge.ui;


import static java.lang.Integer.parseInt;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String readLine;

    public InputView() {

        this.readLine = new ReadLineGenerator().generate();
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = parseInt(readLine);

        return size;

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        if (readLine.equals("Q")) {
            readLine = "Q";
        }
        if (readLine.equals("R")) {
            readLine = "R";
        }

        return readLine;
    }

}
