package bridge;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public int move(int turn) {
        turn++;
        return turn;
    }
    public int retry(String restart) {
        int cnt=0;
        if(!restart.equals("R")){
            return cnt;
        }
        return 1;
    }
}
