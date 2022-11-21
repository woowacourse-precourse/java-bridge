package bridge;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        String bridgeSizeStr = Console.readLine();
        int bridgeSize = 0;
        try{
            bridgeSize = Integer.parseInt(bridgeSizeStr);
        }catch(NumberFormatException ex){
            Application.errorHandling("다리의 길이를 숫자로 입력해주세요.");
        }
        return bridgeSize;
    }

    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveChar = Console.readLine();
        if(moveChar.equals("U") || moveChar.equals("D"))
            return moveChar;
        Application.errorHandling("U와 D 중에서만 입력해주세요.");
        return null;
    }

    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String moveChar = Console.readLine();
        if(moveChar.equals("Q") || moveChar.equals("R"))
            return moveChar;
        Application.errorHandling("Q와 R 중에서만 입력해주세요.");
        return null;
    }
}
