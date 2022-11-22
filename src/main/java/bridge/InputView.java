package bridge;
import java.util.Scanner;



/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Scanner scanner= new Scanner(System.in);
    private int bridgeLength;
    String bridgeLengthSTR;
    boolean flag = false;

    /**
     * 다리의 길이를 입력받는다.
     */


    public int readBridgeSize() {
        while(true){
            System.out.println("다리의 길이를 입력해주세요.");
            try {
                ErrorCheck.isNumberCheck(bridgeLengthSTR = scanner.next());
                ErrorCheck.isbridgeLengthMinMaxCheck(Integer.valueOf(bridgeLengthSTR));
            }catch (IllegalArgumentException e) {
                continue;
            }
            return Integer.valueOf(bridgeLengthSTR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(){
        while(true){
            System.out.println("이동할 칸을 선택해주세요.(위 : U, 아래 : D)");
            String move = scanner.next();
            try {
                ErrorCheck.isMoveUporDownCheck(move);
            }catch(IllegalArgumentException e){
                continue;
            }
            return move;
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            System.out.println("게임을 다시 시도 할지 여부를 입력해주세요. (재시도 : R, 종료 : Q) ");
            String answerRetry = scanner.next();
            try {
                ErrorCheck.isAnswerRorQCheck(answerRetry);
            }catch (IllegalArgumentException e) {
                continue;
            }
            return answerRetry;
        }
    }



}

