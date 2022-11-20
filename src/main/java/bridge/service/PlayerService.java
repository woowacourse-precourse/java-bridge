package bridge.service;

import bridge.domain.player.Player;
import bridge.repository.PlayerRepository;

import static bridge.domain.player.MovedDistance.INIT_DISTANCE;

public class PlayerService {
    private final static int INIT_ATTEMPT_COUNT = 1;

    private static final PlayerRepository playerRepository = PlayerRepository.getInstance();

    public void initPlayer() {
        playerRepository.update(Player.of(INIT_DISTANCE, INIT_ATTEMPT_COUNT));
    }

    public int getAndIncreaseMovedDistance() {
        Player player = playerRepository.get();
        int currentDistance = player.getMovedDistance();
        playerRepository.update(player.increaseMovedDistance());

        return currentDistance;
    }

    public void backToStartPoint() {
        Player player = playerRepository.get();
        playerRepository.update(player.makeNewAttempt());
    }

    public int getAttemptCount() {
        Player player = playerRepository.get();
        return player.getAttemptCount();
    }
}
