package bridge;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    //
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();

//        if(!isNumber(input)){
//            throw  new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
//        }
        isNumber(input);
        return Integer.parseInt(input);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if(isUpDown(input)){
            throw  new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로만 입력가능 합니다.");
        }
        return input;
    }

    // 이동할 칸 입력이 U 또는 D인지 예외처리
    private static boolean isUpDown(String input){
        if(input.equals("U") || input.equals("D")){
            return false;
        }
        return true;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();

        if(!isRestartQuit(input)){
            throw  new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q 두 가지 입력만 가능합니다.");
        }
        if(input.equals("R")){
            return true;
        }
        return false;
    }

    // 게임 재시도 여부 입력이 R 또는 Q인지 예외처리
    private static boolean isRestartQuit(String input){
        if(!input.equals("R") || !input.equals("Q")){
            return false;
        }
        return true;
    }
}
