package bridge.application;

public class ViewService {
    private static ViewService instance=new ViewService();

    private ViewService(){

    }
    public static ViewService getInstance(){
        return instance;
    }

    public void printGameRunMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
