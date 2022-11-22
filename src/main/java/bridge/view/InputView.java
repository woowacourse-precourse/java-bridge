package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    /*
    public static int readBridgeSize() {
        int bridgeLen = 0;

        System.out.println("다리의 길이를 입력해주세요.");
        try{
            bridgeLen = Integer.valueOf(readLine());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            //throw new IllegalArgumentException(e);
        }
        return bridgeLen;

    }
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        while (true) {
            try {
                String bridgeLen = Console.readLine();
                if(checkInputSizeString(bridgeLen))
                    return Integer.parseInt(bridgeLen);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static boolean checkInputSizeString(String bridgeLen) {
        if(isNumber(bridgeLen) && bridgeLenRangeCheck(Integer.parseInt(bridgeLen))) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static boolean bridgeLenRangeCheck(int bridgeLen) {
        if(3 <= bridgeLen && bridgeLen <= 20) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }





    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String move = "";
        System.out.println("");
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try{
            move = readLine();
        }catch (IllegalArgumentException e){
            //System.out.println("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다.");
        }
        System.out.println(move);
        return move;
    }

    public static void moveCheck(String move){
        if(!move.equals("U") && !move.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String replay = "";
        try{
            replay = readLine();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 게임을 다시 시도시 R, 종료시 Q여야 합니다.");
        }
        return replay;

    }
    public static void replayCheck(String replay){
        if(!replay.equals("R") && !replay.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 게임을 다시 시도시 R, 종료시 Q여야 합니다.");
        }
    }


}
