# 클래스 설계
### BridgeMaker
- private final BridgeNumberGenerator bridgeNumberGenerator
- public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator)
- public List<String> makeBridge(int size)

### BridgeNumberGenerator
- int generate()

### BridgeRandomNumberGenerator
- private static final int RANDOM_LOWER_INCLUSIVE = 0;
- private static final int RANDOM_UPPER_INCLUSIVE = 1;
- public int generate()

## Domain
___
### Bridge
- private final List<String> spaces
- private final BridgeMaker bridgeMaker
- public Bridge(BridgeMaker bridgeMaker, int size)

### Result
- private List<String> moves
- private boolean isSuccess
- private int tryCount
- public void clearMoves()
- public void addTryCount()

## View
___
### InputView
- public int readBridgeSize()
- public String readMoving()
- public String readGameCommand()

### OutputView
- public void printBridgeGameStart()
- public void printMap()
- public void printResult()

## Controller
___
### BridgeGame
- public void run()
- public void makeBridge()
- public void move()
- public void retry()
- public void showResult()