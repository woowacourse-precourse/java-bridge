package bridge;
import java.util.*;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> movable;
    private int attempts;
    private List<String> users;
    BridgeGame(List<String>movable){
        this.movable = movable;
        this.attempts =1;
        this.users = new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userValue, int index) {
        usersBridge(userValue,index);
        if(userValue.equals(movable.get(index))) {
            return true;
        }
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryOrNot) {
        if(retryOrNot.equals(StringEnum.Q.getStr())) {
            usersAttempts();
            retryUsers();
            return false;}
        return true;
    }
    private void usersBridge(String userValue, int index){
        this.users.add(index, userValue);
    }
    private void usersAttempts(){
        this.attempts +=1;
    }
    private void retryUsers() {
        this.users.clear();
    }
    public int getAttempts() {
        return attempts;
    }
    public boolean result(){
        if(movable.equals(users)) return true;
        return false;
    }
}
