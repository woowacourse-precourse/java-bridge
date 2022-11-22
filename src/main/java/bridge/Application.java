package bridge;

import java.util.List;

public class Application {
    static InputView m_InputView = new InputView();
    static OutputView m_OutputView = new OutputView();
    static BridgeGame m_BridgeGame = new BridgeGame();
    static BridgeMaker m_BridgeMaker;
    static List<String> Game_Bridge;
    static String Input_history = "";
    static String Input_Current = "";
    static boolean ONE_GAME(int Bridge_Size) {
        Input_history = "";
        while (Bridge_Size > Input_history.length()) {
            Input_Current = m_InputView.readMoving().toUpperCase();
            m_OutputView.printMap(Game_Bridge, Input_history + Input_Current);
            if (!m_BridgeGame.move(Game_Bridge,Input_history + Input_Current)) break;
//            if (m_BridgeGame.move(Game_Bridge,Input_history + Input_Current)) {}
            Input_history = Input_history + Input_Current;
        }
        if (Bridge_Size > Input_history.length()) { return false; }
        return true;
    }

    public static void GAME_LOOP(int Bridge_Size) {
        int RETRY_COUNT = 0;
        boolean FLAG_GAME_REPEAT = true;
        while (FLAG_GAME_REPEAT) {
            RETRY_COUNT += 1;
            boolean GAME_RESULT = ONE_GAME(Bridge_Size);
            if (!GAME_RESULT) {FLAG_GAME_REPEAT = m_BridgeGame.retry(m_InputView.readGameCommand().toUpperCase());}
            if (!FLAG_GAME_REPEAT){Input_history = Input_history + Input_Current;}
            if (GAME_RESULT || !FLAG_GAME_REPEAT) {m_OutputView.printResult(Game_Bridge, Input_history, RETRY_COUNT); break;}
        }
    }

    public static void main(String[] args) {
        try{
            int Bridge_Size = m_InputView.readBridgeSize();
            m_BridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Game_Bridge = m_BridgeMaker.makeBridge(Bridge_Size);
            m_BridgeGame.GAME_START_MSG();
            GAME_LOOP(Bridge_Size);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
