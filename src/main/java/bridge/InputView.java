package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try{
            int textCheckedSize = checkBridgeSizeText(Console.readLine());
            int sizeCheckedSize = checkBridgeSize(textCheckedSize);
            return sizeCheckedSize;
        }catch(IllegalArgumentException e){
            return readBridgeSize();
        }
    }

    public int checkBridgeSize(int size) throws IllegalArgumentException{
        if(size >= 3 && size <= 20){
            return size;
        }
        System.out.println("[ERROR]: 다리의 크기가 유효하지 않습니다.");
        throw new IllegalArgumentException();
    }

    public int checkBridgeSizeText(String size) throws IllegalArgumentException{
        try{
            int sizeToInt = Integer.parseInt(size);
            return sizeToInt;
        }catch (Exception e){
            System.out.print("[ERROR]: 다리의 크기에 대한 입력 값이 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try{
            String moving = checkInputOfMoving(Console.readLine());
            return moving;
        }catch (IllegalArgumentException e){
            return readMoving();
        }
    }

    public String checkInputOfMoving(String moving) throws IllegalArgumentException{
        try{
            List<String> commend = new ArrayList<>();
            commend.add("U");
            commend.add("D");
            return checkInputInCommend(moving, commend);
        }catch (IllegalArgumentException e){
            System.out.print("[ERROR]: 유효하지 않은 이동입니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();

        return gameCommand;
    }
}
