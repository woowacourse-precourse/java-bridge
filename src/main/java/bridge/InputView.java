package bridge;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 * 패키지, 메서드의 시그니처(인자, 이름)와 반환 타입 변경 및 메서드를 추가 가능.
 */
public class InputView {
    static int bridgeLength;

    public void readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n" + "다리의 길이를 입력해주세요.");
        String bridgeLength = Console.readLine();
        bridgeIntCheck(bridgeLength);       //숫자가 아닐 시 예외처리
        bridgeSizeCheck(bridgeLength);      //3 ~ 20 사이의 수가 아닐 시 예외처리
        this.bridgeLength = Integer.parseInt(bridgeLength);
    }

    public String readMoving() {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = Console.readLine();
            movingCheck(moving);             //U, D가 아니면 예외처리
            return moving;
    }

        public String readGameCommand () {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String retry = Console.readLine();
            retryCheck(retry);                 //R, Q가 아니면 예외처리
            return retry;
        }

    public void bridgeIntCheck(String bridgeLength){
        if(bridgeLength.equals("")){
            throw new IllegalArgumentException("[ERROR] : 숫자를 입력해주세요");
        }
        for(int i = 0; i < bridgeLength.length(); i++){
            if(!Character.isDigit(bridgeLength.charAt(i))){
                throw new IllegalArgumentException("[ERROR] : 숫자를 입력해주세요");
            }
        }
    }
    public void bridgeSizeCheck(String bridgeLength){
        if(Integer.parseInt(bridgeLength) < 3 || Integer.parseInt(bridgeLength) > 20){
            throw new IllegalArgumentException("[ERROR] : 3 ~ 20 사이의 숫자를 입력해주세요");
        }
    }
    public String movingCheck(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] : U, D만 입력 가능합니다");
        }
        return moving;
    }
    public void retryCheck(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] : R, Q만 입력 가능합니다");
        }
    }
}
