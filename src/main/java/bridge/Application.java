package bridge;

public class Application {
    static int i = 0;
    static GameController gameController = new GameController();
    public static boolean determineRetry(boolean isRetry){
        if(isRetry){
            i=-1;
            return false;
        }
        if(!isRetry){
            gameController.setSuccess(false);
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            gameController.getSizeAndMakeBridge();
            for (i = 0; i < gameController.getbridgeLength(); i++) {
                boolean res = gameController.getMovingResult(i);
                gameController.printMap();
                if (!res&&determineRetry(gameController.isRetryProcessor())) {
                    break;
                }
            }
            gameController.printResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
