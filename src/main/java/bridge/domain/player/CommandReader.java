package bridge.domain.player;

public interface CommandReader {

	String BRIDGE_SIZE = "BridgeSize";
	String GAME_PROCEED = "GameProceed";
	String GAME_MOVEMENT = "Movement";

	Object read();
}
