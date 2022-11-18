package bridge;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 * 패키지, 메서드의 시그니처(인자, 이름)와 반환 타입 변경 및 메서드를 추가 가능.
 */
public class InputView {
    private Scanner sc = new Scanner(System.in);

    static int bridgeLength;

    public void readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n" + "다리의 길이를 입력해주세요.");
        String bridgeLength = sc.nextLine();
        bridgeSizeCheck(bridgeLength);
        this.bridgeLength = Integer.parseInt(bridgeLength);
    }
    public void bridgeSizeCheck(String bridgeLength){
        if(bridgeLength.equals("")){
            throw new IllegalArgumentException("[ERROR]");
        }
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
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = sc.next();
            movingCheck(moving);
            return moving;
    }
    public String movingCheck(String moving) {
            if (moving.equals("")) {
                throw new IllegalArgumentException("[ERROR]");
            }
            if (!moving.equals("U") && !moving.equals("D")) {
                throw new IllegalArgumentException("[ERROR]");
            }
        return moving;
    }

        public String readGameCommand () {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String retry = sc.next();
            retryCheck(retry);
            return retry;
        }
    public void retryCheck(String retry) {
            if(retry.equals("")){
                throw new IllegalArgumentException("[ERROR]");
            }
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
