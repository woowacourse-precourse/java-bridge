package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String size = readLine();
        if(!validateSize(size)){
            return Integer.parseInt(size);
        }while(true){
            String resize = readLine();
            if (!validateSize(resize)){
                return Integer.parseInt(resize);}
        }
    }

    private boolean validateSize(String bridgeSize) {
        try{
            try {
                Integer.parseInt(bridgeSize);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();}
            validateSizeRange(Integer.parseInt(bridgeSize));
            return false;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return true;}}

    private static void validateSizeRange(int size) {
        if (size <3 || size >20){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String command = readLine();
        if(validateCommand(command)){
            return command;
        }while(true){
            String retryCommand = readLine();
            if (validateCommand(retryCommand)){
                return retryCommand;}}
    }

    private boolean validateCommand(String command) {
        try {
            if (command.equals("U") || command.equals("D")) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U 또는 D를 입력해주세요.");
            return false;}
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }


}
