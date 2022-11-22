package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        gameController.getSizeAndMakeBridge();

        System.out.println("테스트를 위한");
        System.out.println(gameController.getbridge());
        for(int i=0;i< gameController.getbridgeLength();i++){
            boolean res = gameController.getMovingResult(i);
            gameController.printMap();
            if(!res){
                boolean isRetry = gameController.isRetryProcessor();
                if(isRetry){
                    i=-1;
                }
                if(!isRetry){
                    gameController.setSuccess(false);
                    break;
                }


            }
        }
        gameController.printResult();
    }
}
