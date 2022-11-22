package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String num, String aaa) {
        if (num.equals(aaa)) {
            return 1;    //살아남음
        }
        return 0;  //추락
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String[] retry(String flag,int cnt) {
        String [] stopFlag = new String[2];
        if (flag.equals("Q")) {
            qCheck(stopFlag,cnt);
        }
        if (flag.equals("R")){
            rCheck(stopFlag);
        }
        return stopFlag;
    }
    public String[] qCheck (String[] stopFlag,int cnt) {
        System.out.println("Q");
        stopFlag[0]="종료";
        stopFlag[1]=String.valueOf(cnt);
        return stopFlag;
    }
    public String[] rCheck (String[] stopFlag) {
        System.out.println("R");
        stopFlag[0]="다시";
        return stopFlag;
    }
}
