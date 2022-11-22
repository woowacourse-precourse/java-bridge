package bridge;
import java.util.*;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder printUp;
    private StringBuilder printDown;

    OutputView(){
        this.printUp = new StringBuilder();
        this.printDown = new StringBuilder();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String user, boolean isDraw, int index) {
        printUp.append(printFirstMap(index));
        printDown.append(printFirstMap(index));
        printUp.append(printUpMap(user,isDraw));
        printDown.append(printDownMap(user,isDraw));
        StringEnum.SQUAREBRACKET_RIGTH.printGameResult(printUp.toString(),printDown.toString());
    }
    public String printUpMap(String user, boolean isDraw){
        if(!user.equals(StringEnum.UP.getStr())) return StringEnum.BLANK.getStr();
        return printUserMap(isDraw);
    }
    public String printDownMap(String user, boolean isDraw){
        if(!user.equals(StringEnum.DOWN.getStr())) return StringEnum.BLANK.getStr();
        return printUserMap(isDraw);

    }
    public String printFirstMap(int index){
        if(index ==0) return StringEnum.SQUAREBRACKET_LEFT.getStr();
        return StringEnum.MIDDLE.getStr();
    }
    public String printUserMap(boolean isDraw){
        if(isDraw) return StringEnum.O.getStr();
        return StringEnum.X.getStr();
    }
    public void removePrintMap(){
        this.printUp = new StringBuilder();
        this.printDown = new StringBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(StringEnum.GAME_RESULT_FINAL.getStr());
        StringEnum.SQUAREBRACKET_RIGTH.printGameResult(printUp.toString(),printDown.toString());
    }
    public void printSuccessOrFailure(boolean bridgeGameResult, int attempts) {
        System.out.print(StringEnum.GAME_RESULT.getStr());
        StringEnum.GAME_RESULT.gameResult(bridgeGameResult);
        System.out.print(StringEnum.GAME_RESUTL_ATTEMPTS.getStr()+attempts);
    }
}
