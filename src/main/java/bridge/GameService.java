package bridge;

public class GameService {
    public void playGame(){
        boolean gameStartOrNot=true;
        BridgeGame bridgeGame = new BridgeGame();

        while (gameStartOrNot){

            if(!bridgeGame.move()){
                gameStartOrNot= bridgeGame.retry();
            }
        }
    }
}
