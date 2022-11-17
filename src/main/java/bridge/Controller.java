package bridge;

public class Controller {

	public void run(){
		try{
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.play();

		} catch (IllegalArgumentException ie){
			System.out.println("error");
		}
	}
}
