package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<List<String>> bridges;
    private static List<String> bridgeUp = new ArrayList<>();
    private static List<String> bridgeDown = new ArrayList<>();

    public BridgeGame() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String square, String choice) {

        String result = moveOne(square, choice);

        resultAdd(choice,result);
        return bridges;
    }

    private String moveOne(String square, String choice) {
        if(square.equals(choice)) {
            return "O";
        }
        return "X";
    }

    private void resultAdd(String choice,String result){
        this.bridgeUp = this.bridges.get(0);
        this.bridgeDown = this.bridges.get(1);

        if(choice.equals("U")){
            this.bridgeUp.add(result);
            this.bridgeDown.add(" ");
        }
        if(choice.equals("D")){
            this.bridgeDown.add(result);
            this.bridgeUp.add(" ");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(List<String> bridge : this.bridges){
            sb.append("[ ");
            sb.append(bridgeToString(bridge));
            sb.append(" ]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public String bridgeToString(List<String> bridge){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<bridge.size();i++){
            sb.append(bridge.get(i));
            if(i < bridge.size() -1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String reply,int attempt) {
        if(reply.equals("R")){
            attempt++;
            return attempt;
        }
        return attempt;
    }

    public void reset() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }
}
