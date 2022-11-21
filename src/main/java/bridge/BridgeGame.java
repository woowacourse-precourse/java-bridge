package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static StringBuilder sb1 = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();
    Application api = new Application();

    public static StringBuilder getSb1(){return sb1;}
    public static StringBuilder getSb2(){return sb2;}

    public static void spliceMoveStart(int size){
        if(size == 0){
            sb1.append("[");
            sb2.append("[");
        }
    }

    public static void spliceMoverEnd(int size, List<String> bridge){
        if(bridge.size() - 1 == size){
            sb1.append("]");
            sb2.append("]");
        }
    }

    public static void spliceMiddle(int size, List<String> bridge){
        if(bridge.size() - 1 != size)
            sb1.append("|");
            sb2.append("|");
    }

    public static void directionUp(List<String> bridge, String search, int size){
        String Oxjudge = OXjudge(bridge, search, size);
        if(bridge.get(size).equals("U")){
            if(Oxjudge.equals(" X ")){
                sb1.append("   ");
                sb2.append(Oxjudge);
            }
            if(Oxjudge.equals(" O ")){
                sb1.append(Oxjudge);
                sb2.append("   ");
            }
        }
    }

    public static void directionDown(List<String> bridge, String search, int size){
        String Oxjudge = OXjudge(bridge, search, size);
        if(bridge.get(size).equals("D")){
            if(Oxjudge.equals(" X ")){
                sb1.append(Oxjudge);
                sb2.append("   ");
            }
            if(Oxjudge.equals(" O ")){
                sb1.append("   ");
                sb2.append(Oxjudge);
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public static String move(List<String> bridge, String search, int size) {

        spliceMoveStart(size);
        spliceMoverEnd(size, bridge);
        spliceMiddle(size, bridge);
        directionUp(bridge, search, size);
        directionDown(bridge, search, size);

        String result1 = sb1.substring(0,sb1.length()-1) + "]";
        String result2 = sb2.substring(0, sb2.length()-1) + "]";
        return result1 + System.getProperty("line.separator")+result2;
    }

    public static String OXjudge(List<String> bridge, String search, int size){
        String result = "";
        if(bridge.get(size).equals(search)){    //search는 검색하고자하는 한곳을 String으로 파악하는 기능
            result = " O ";
        }
        if(!bridge.get(size).equals(search)){
            result = " X ";
        }
        return result;
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int size) {
        if(size == 0){
            sb1.delete(0, sb1.length());
            sb2.delete(0, sb2.length());
        }
        if(size != 0 ){
            sb1.delete(0, sb1.length());
            sb2.delete(0, sb2.length());
            api.size = 0;
        }

    }

    public void startGame(){
        OutputView.bridgeGameStart();
        System.out.println();
    }
    public List<String> makeBridge(int size) {
        BridgeMaker brm = new BridgeMaker(new BridgeRandomNumberGenerator());
        return brm.makeBridge(size);

    }

    public static void printResult(){
        System.out.println();
        System.out.println("최종 게임 결과");
    }

}


