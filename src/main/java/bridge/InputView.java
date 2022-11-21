package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeLength = "";
        while(true){
            System.out.println("다리의 길이를 입력해주세요.");
            bridgeLength = Console.readLine();
            if(bridgeTypeCheck(bridgeLength)&&bridgeNullCheck(bridgeLength)&&bridgeSizeCheck(Integer.parseInt(bridgeLength)))
                break;
        }
        return Integer.parseInt(bridgeLength);
    }

    public boolean bridgeTypeCheck(String bridgeLength) {
            try {
                bridgeTypeException(bridgeLength);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
                return false;
            }
    }

    public boolean bridgeSizeCheck(int bridgeLength){
        try {
            bridgeSizeException(bridgeLength);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3이상 20이하의 숫자를 입력해주세요.");
            return false;
        }
    }

    public boolean bridgeNullCheck(String bridgeLength){
        try{
            bridgeNullException(bridgeLength);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 아무 입력을 하지 않았습니다.");
            return false;
        }
    }

    public void bridgeTypeException(String bridgeLength){
        char check[] = bridgeLength.toCharArray();
        for(int i=0;i<check.length;i++){
            if(!Character.isDigit(check[i]))
                throw new IllegalArgumentException();
        }
    }
    public void bridgeSizeException(int bridgeLength){
        if(bridgeLength<3||bridgeLength>20)
            throw new IllegalArgumentException();
    }

    public void bridgeNullException(String bridgeLength){
        if(bridgeLength.equals("")||bridgeLength.equals(null))
            throw new IllegalArgumentException();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveBridge = "";
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        moveBridge = Console.readLine();
        return moveBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = "";
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        gameCommand = Console.readLine();
        return gameCommand;
    }
}
