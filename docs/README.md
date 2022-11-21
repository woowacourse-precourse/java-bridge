# 기능 구현 리스트

1. BridgeGame
    1. 사용자가 칸을 이동하는 기능
    2. 사용자가 게임을 재시작하는 기능
2. BridgeMaker
    1. 다리를 생성하는 기능
3. BridgeNumberGenerator
    1. BridgeRandomNumberGenerator에서 반드시 숫자 생성 기능을 구현하도록 하는 인터페이스
4. BridgeRandomNumberGenerator
    1. 0 혹은 1중 무작위 숫자를 생성하는 기능
5. InputView
    1. 사용자로부터 다리 길이를 입력받는 기능
    2. 사용자로부터 이동할 칸을 입력받는 기능
    3. 사용자의 게임 재시작 여부를 입력받는 기능
6. OutputView
    1. 게임 진행 상황을 보여주는 기능
    2. 게임의 최종 결과를 보여주는 기능
7. BridgeMapGenerator
   1.  bridgeMap을 생성하는 기능