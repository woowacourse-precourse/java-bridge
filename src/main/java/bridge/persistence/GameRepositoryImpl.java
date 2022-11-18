package bridge.persistence;

import bridge.domain.GameRepository;

// 게임 재시도 횟수를 관리한다
public class GameRepositoryImpl implements GameRepository {

    private final GameEntity gameEntity;

    public GameRepositoryImpl() {
        this.gameEntity = new GameEntity();
    }


    @Override
    public void gameStatus() {
//        int gameEntity = gameEntity;
    }
}
