package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outview = new OutputView();

    public void printInputSizeMessage(){
        System.out.println("다리의 길이를 입력해 주세요.");
    }

    private void throwCheckSizeException(int size){
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[ERROR]다리의 길이는 3이상 20이하의 수만 가능합니다.");
    }

    private int changeSizefomat(){
        int size;
        String bridgeSize;

        bridgeSize = readLine();
        try {
            size = Integer.parseInt(bridgeSize);
            throwCheckSizeException(size);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]다리의 길이를 숫자로 입력해주세요.");
        }
        return size;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size;

        printInputSizeMessage();
        try {
            size = changeSizefomat();
        }
        catch (IllegalArgumentException e){
            outview.printMessage(e.getMessage());
            return readBridgeSize();
        }
        return size;
    }

    private void throwMoveException(String move){
        if (move.charAt(0) != 'U' && move.charAt(0) != 'D') {
            throw new IllegalArgumentException("[ERROR]이동할 칸을 올바르게 입력해 주세요.");
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move;

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        move = readLine();
        System.out.println(move);
        try {
            throwMoveException(move);
        }
        catch (IllegalArgumentException e){
            outview.printMessage(e.getMessage());
            return readMoving();
        }
        return move;
    }

    public void checkRegameException(String regame){
        if ((!regame.equals("R")) && (!regame.equals("Q"))){
            throw new IllegalArgumentException("[ERROR] 다시 입력해 주세요.");
        }
    }
    public void printRegameMessage(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String regame;

        regame = readLine();
        try {
            checkRegameException(regame);
        }
        catch (IllegalArgumentException e){
            outview.printMessage(e.getMessage());
            return readGameCommand();
        }
        return regame;
    }
}
