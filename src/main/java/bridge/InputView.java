package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outView = new OutputView();
    public int sizeValidate(){

        int size;

        try {
            size = Integer.parseInt(readLine());
            checkSize(size);

        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해주세요.");
        }
        return size;
    }

    public void checkSize(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 수만 가능합니다.");
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size;
        System.out.println("다리의 길이를 입력해 주세요.");
        size = sizeValidate();

        return size;
    }

    public void MoveCheck(String word){
        if (word.charAt(0) != 'U' && word.charAt(0) != 'D') {
            throw new IllegalArgumentException("[ERROR] 올바르게 입력해 주세요.");
        }
    }
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String word = readLine();
        System.out.println(word);
        try {
            MoveCheck(word);
        }
        catch (IllegalArgumentException e){
            outView.printMessage(e.getMessage());
            return readMoving();
        }
        return word;
    }
    public void checkRegameException(String regame){
        if ((!regame.equals("R")) && (!regame.equals("Q"))){
            throw new IllegalArgumentException("[ERROR] 다시 입력해 주세요.");
        }
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
            outView.printMessage(e.getMessage());
            return readGameCommand();
        }
        return regame;
    }

    public void printReGameMessage(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
