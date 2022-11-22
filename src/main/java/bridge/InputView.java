package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int bridgeSize = 0;
        System.out.println("다리의 길이를 입력해 주세요.");
        bridgeSize = Integer.parseInt(readUntilRightInput());
        return bridgeSize;
    }

    //  10줄 초과! 리팩토링 필요  //
    private static String readUntilRightInput(){
        while(true){
            try{
                String input = Console.readLine();
                errorBridgeSizeOverRange(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 3~20 사이의 값을 입력해야 합니다.");
            }
        }
    }

    public static void errorBridgeSizeOverRange(String input){
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < 3 || 20 < bridgeSize){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위 : U, 아래 : D)");
        String inputUpDown = Console.readLine();
        return inputUpDown;
    }

    public static String repeatInputMoving(){
        while(true){
           try{
               String input = readMoving();
               errorInputNotUOrD(input);
               return input;
           }catch (IllegalArgumentException e) {
               System.out.println("[ERROR] U 또는 D를 입력해야 합니다.");
           }
        }
    }

    public static void errorInputNotUOrD(String input){
        if(!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputCommand = Console.readLine();
        return inputCommand;
    }

    public static String repeatInputRetry(){
        while(true){
            try{
                String input = readGameCommand();
                errorInputNotROrQ(input);
                return input;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] R 또는 Q를 입력해야 합니다.");
            }
        }
    }

    public static void errorInputNotROrQ(String input){
        if(!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException();
        }
    }
}