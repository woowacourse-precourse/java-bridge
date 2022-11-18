package bridge;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 * 패키지, 메서드의 시그니처(인자, 이름)와 반환 타입 변경 및 메서드를 추가 가능.
 */
public class InputView {
    private Scanner sc = new Scanner(System.in);
    private int count = 1;

    static int bridgeLength;

    public void readBridgeSize() {
        String bridgeLength = sc.nextLine();
        bridgeSizeCheck(bridgeLength);
        this.bridgeLength = Integer.parseInt(bridgeLength);
    }
    public void bridgeSizeCheck(String bridgeLength){
        for(int i = 0; i < bridgeLength.length(); i++){
            if(!Character.isDigit(bridgeLength.charAt(i))){
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        if(Integer.parseInt(bridgeLength) < 3 || Integer.parseInt(bridgeLength) > 20){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public String readMoving() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> crossingTheBridge = bridgeMaker.makeBridge(bridgeLength);
        for(int i = 0; i < bridgeLength; i++){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            System.out.println(crossingTheBridge.get(i));
            String UpAndDown = sc.next();
            movingCheck(UpAndDown);
            if(!crossingTheBridge.get(i).equals(UpAndDown)) {
                return "실패";
            }
        }
        return "성공";
    }
    public void movingCheck(String UpAndDown){
        if(UpAndDown.length() > 1){
            throw new IllegalArgumentException("[ERROR]");
        }
        if(!UpAndDown.equals("U") && !UpAndDown.equals("D")){
            throw new IllegalArgumentException("[ERROR]");
        }

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


}
