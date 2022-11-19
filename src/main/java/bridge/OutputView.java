package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START = "[";
    private final String DEL ="|";
    private final String END = "]";

    public void printMap(String map) {
        int len = map.length();
        System.out.println(printMap(map,0,len / 2));
        System.out.println(printMap(map,len / 2  ,len));
    }
    private String printMap(String map,int s,int e){
        StringBuffer builder = new StringBuffer();
        builder.append(START);
        for(int i = s;i < e;i++) {
            builder.append(" " + map.charAt(i) + " ");
            if(i + 1 != e)
                builder.append(DEL);
        }
        builder.append(END);
        return builder.toString();
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
