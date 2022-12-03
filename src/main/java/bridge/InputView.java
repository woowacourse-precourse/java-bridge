package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int bridge_min = 3;
    private static final int bridge_max = 20;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int bridge_size = 0;
        try{
            bridge_size = stringToInt(input);
            validBridgeLength(bridge_size);
        }catch (Exception e){
            this.readBridgeSize();
        }
        return bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        try {
            validMovingInput(input);
        } catch (Exception e){
            this.readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        try{
            validReadGameCommand(input);
        } catch (Exception e){
            this.readGameCommand();
        }
        return input;
    }

    private int stringToInt(String input){
        try{
            return Integer.valueOf(input);
        } catch (Exception e){
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validBridgeLength(int bridge_size){
        if(bridge_size < bridge_min || bridge_max < bridge_size){
            System.out.println("[ERROR] 다리 길이는 3이상 20이하만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validMovingInput(String input){
        if (!input.equals("U") && !input.equals("D")){
            System.out.println("[ERROR] 이동할 칸은 U와 D만 입력 가능합니다.");
        }
    }

    private void validReadGameCommand(String input){
        if (!input.equals("R") && !input.equals("Q")){
            System.out.println("[ERROR] R과 Q만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
