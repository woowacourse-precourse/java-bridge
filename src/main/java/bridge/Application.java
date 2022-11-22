package bridge;

public class Application {
    private static InputView iv;
    private static int cnt = 1;
    public static int choose(BridgeGame bg){
        if(bg.move() == 0)//틀려서 끝남
            if(iv.readGameCommand().equals("R")) {
                bg.retry();
                cnt++;
                return 1;
            } else return 0;
        if(bg.curidx == bg.curbridge.size()) return 2;
        return 1; //맞춤
    }
    public static void main(String[] args) {
        try{
        iv = new InputView();
        BridgeGame bg = new BridgeGame(iv.readBridgeSize());
        int flag = 0;
        while(true){
            int c = choose(bg);
            if(c == 0) {flag = 1; break;}
            else if(c == 2){flag = 0; break;}
        }
        //최종 결과 출력
        OutputView ov = new OutputView(bg.curidx,bg.curbridge,bg.curmov);
        ov.printResult(flag,cnt);
        } catch(Exception e) {System.out.println("[ERROR]");}
    }
}
