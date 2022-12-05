package bridge.view;


public class OutputView {
    private final String START = "[";
    private final String DEL ="|";
    private final String END = "]";

    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public String printMap(String map) {
        StringBuffer builder = new StringBuffer();
        int len = map.length();
        builder.append(printMap(map,0,len / 2) + "\n");
        builder.append(printMap(map,len / 2  ,len));
        System.out.println(builder);
        return builder.toString();
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

    public void printResult(String map , Integer count) {
        StringBuffer builder = new StringBuffer();
        builder.append("최종 게임 결과\n");
        builder.append(printMap(map) + "\n");
        builder.append("게임 성공 여부: ");
        builder.append(isSuccess(map) + "\n");
        builder.append("총 시도한 횟수: ");
        builder.append(count + "\n");
        System.out.println(builder);
    }

    private String isSuccess(String map){
        if(map.contains("X"))return "실패";
        return "성공";
    }
}
