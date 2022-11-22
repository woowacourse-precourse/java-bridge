## 1. BridgeGame
> InputView, OutputView 클래스를 사용하지 않는다. <br>
> 필드 추가 가능 / 패키지 변경 가능 / 메서드 이름 변경 불가능, 인자, 반환 변경 가능 <br>
> 필요한 메서드 추가 가능

1. BridgeGame 생성자 추가

2. move() 메서드 추가

3. 스텝의 정답 여부 확인 메서드 추가

4. retry() 메서드 추가

5. 성공, 실패 여부 메서드 추가

## 2. BridgeMaker
> 필드 변경 불가능 / 메서드의 시그니처, 반환 타입 변경 불가능

1. makeBridge(size): size 만큼의 U, D 리스트 리턴

## 3. BridgeNumberGenerator
> bridge.BridgeRandomNumberGenerator의 generate() 로 난수 생성 <br>
> 코드 변경 불가능

## 4. BridgeRandomNumberGenerator
> 코드 변경 불가능

## 5. InputView
> 사용자의 입력을 받는 클래스 <br>
> 여기에서만 camp.nextstep.edu.missionutils.Console.readLine() 사용가능 <br>
> 패키지 변경 가능 / 메서드 시그니처(인자, 이름), 반환 변경 및 추가 가능

1. readBridgeSize() 입력 받기 및 예외 처리
    - null, [3, 20] 범위 체크

2. readMoving() 입력 받기 및 예외 처리
    - null, U/D만 입력

3. readGameCommand() 입력 받기 및 예외 처리
    - null, R/Q만 입력

4. 입력 예외 클래스에 예외처리 메서드 추가

## 6. OutputView
> 패키지 변경 가능 / 메서드 이름 변경 불가능, 인자와 반환 타입 변경 가능 <br>
> 값 출력을 위해 메서드 추가 가능

1. 이동한 다리 상태 출력 메서드 추가

2. 게임의 최종 결과 출력 메서드 추가


### 7. BridgeApp
1. 다리 크기를 받는 메서드
2. 다리 이동 U, D를 받는 메서드
3. 게임의 결과를 확인하는 메서드
4. 게임 실행 메서드