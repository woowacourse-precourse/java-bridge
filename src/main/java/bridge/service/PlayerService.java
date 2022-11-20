package bridge.service;

import bridge.domain.player.Player;
import bridge.repository.PlayerRepository;

import static bridge.domain.player.MovedDistance.INIT_DISTANCE;

public class PlayerService {
    private final static int INIT_ATTEMPT_COUNT = 0;

    private static final PlayerRepository playerRepository = PlayerRepository.getInstance();

    public void initPlayer() {
        playerRepository.update(Player.of(INIT_DISTANCE, INIT_ATTEMPT_COUNT));
    }

    public int getMovedDistance() {
        Player player = playerRepository.get();
        return player.getMovedDistance();
    }

    public void increaseMovedDistance() {
        Player player = playerRepository.get();
        playerRepository.update(player.increaseMovedDistance());
    }

    public void backToStartPoint() {
        Player player = playerRepository.get();
        playerRepository.update(player.makeNewAttempt());
    }
}
