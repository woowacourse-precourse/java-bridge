package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 */
public class InputView   {

    private final String errorMsg = "[ERROR]";

    private OutputView outputView;


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        int result;
        try {
            result =  Integer.parseInt(bridgeSize);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(errorMsg + " 숫자만 입력 가능");
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * U, D
     */
    public String readMoving(int bridgeSize){

        String result = "";

        // 리스트 List<String> 같은 형태로 필요
        // U 또는 D를 읽을 때마다 한번씩 출력해준다.
        for(int i = 0; i < bridgeSize; ++i){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String position = Console.readLine();

            // U, D인 경우
            if(position.charAt(0) == 'U' && position.length()  == 1){
                result += "U";
                outputView.printMap();

            } else if (position.charAt(0) == 'D' && position.length()  == 1) {
                result += "D";
                outputView.printMap();

            }else{
                throw new IllegalArgumentException(errorMsg + " 위: U, 아래: D 만 입력 가능");

            }
        }

        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
