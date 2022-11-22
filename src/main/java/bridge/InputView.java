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
            int size = Integer.parseInt(bridgeSize);
            validateSizeRange(size);
            return false;
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 다리 길이는 숫자여야 합니다.");
            return true;
        }catch (IllegalArgumentException e){
            return true;}
    }

    private static void validateSizeRange(int size) {
        if (size <3 || size >20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String command = readLine();
        validateCommand(command);
        return readLine();
    }

    private void validateCommand(String command) {
        if(command.equals("U") || command.equals("D")){
            System.out.println("U 또는 D를 입력해");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }


}
