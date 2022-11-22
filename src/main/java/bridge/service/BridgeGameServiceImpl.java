package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.dao.BridgeGameDao;
import bridge.data.dao.BridgeGameDaoImpl;
import bridge.data.dto.requestDto.FailMenuRequestDto;
import bridge.data.dto.requestDto.FinalResultRequestDto;
import bridge.data.dto.requestDto.GameInitRequestDto;
import bridge.data.dto.requestDto.InGameCommandRequestDto;
import bridge.data.dto.responseDto.FailMenuResponseDto;
import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.GameInitResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;
import bridge.data.entity.BridgeGame;
import java.util.List;

public class BridgeGameServiceImpl implements BridgeGameService {

    private final BridgeGameDao bridgeGameDao;

    public BridgeGameServiceImpl() {
        this.bridgeGameDao = new BridgeGameDaoImpl();
    }

    @Override
    public GameInitResponseDto initGame(GameInitRequestDto requestDto) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(requestDto.getBridgeSize());
        BridgeGame savedBridgeGame = bridgeGameDao.insertBridgeGame(new BridgeGame(bridge));
        return new GameInitResponseDto(savedBridgeGame.getSessionId());
    }

    @Override
    public InGameCommandResponseDto playGame(InGameCommandRequestDto requestDto) {
        BridgeGame selectedBridgeGame = bridgeGameDao.selectBridgeGame(requestDto.getSessionId());
        selectedBridgeGame.move(requestDto.getCommand());
        BridgeGame savedBridgeGame = bridgeGameDao.insertBridgeGame(selectedBridgeGame);
        return new InGameCommandResponseDto(savedBridgeGame.getBridgeMap(), savedBridgeGame.getMoves());
    }

    @Override
    public FailMenuResponseDto askRetry(FailMenuRequestDto requestDto) {
        BridgeGame selectedBridgeGame = bridgeGameDao.selectBridgeGame(requestDto.getSessionId());
        selectedBridgeGame.retry(requestDto.getCommand());
        BridgeGame savedBridgeGame = bridgeGameDao.insertBridgeGame(selectedBridgeGame);
        return new FailMenuResponseDto(requestDto.getCommand());
    }

    @Override
    public FinalResultResponseDto getResult(FinalResultRequestDto requestDto) {
        BridgeGame selectedBridgeGame = bridgeGameDao.selectBridgeGame(requestDto.getSessionId());
        InGameCommandResponseDto inGameCommandResponseDto =
                new InGameCommandResponseDto(selectedBridgeGame.getBridgeMap(), selectedBridgeGame.getMoves());
        return new FinalResultResponseDto(inGameCommandResponseDto, selectedBridgeGame.getTryCount());
    }
}
