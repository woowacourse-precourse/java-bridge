# 미션 - 다리 건너기

# 📝 기능 목록

## I. Application
- bridge 의 size 를 입력받아 GameController 로 전달하여 게임을 시작
- try/catch 를 통해 어플리케이션 도중 생성된 에러를 최종적으로 관리

## II. GameController
- 게임이 시작된뒤 게임의 과정과 끝을 관장
- while 문을 사용해 게임중, 게임오버, 게임종료 상태에 따라 게임의 과정을 관리

## III. BridgeGame
- 게임이 진행되는 상태를 관리
- 생성된 bridge 와 move 에 따라 현재좌표를 나타내는 currentCoordinate 를 비교하는 bridgeCheck 매서드를 통해 게임의 상태를 gameOver 변수로 관리  

## IV. BridgeMaker
- BridgeNumberGenerator 인스턴스로 입력받은 size 로 같은 크기의 0-1난수로 이루어진 list를 생성
- bridgeParse 매서드를 통해 생성된 list 를 게임에서 사용하는 String 으로 변환

## V. InputView
- 유저에게 값을 입력받는 메서드를 관리
- 입력받은 값은 Validator 클래스의 매서드를 사용해 검증한 후 잘못된 입력값이 있을 시 에러를 전달

## VI. OutputView
- 유저에게 값을 출력하는 메서드를 관리
- 게임에서 사용되는 bridge 의 list 를 지정된 모양으로 변환
- BoilerPlates 클래스에 저장된 상용구를 통해 출력
