## 🌉 다리건너기 게임 🌉
### 1. Application 클래스
1. 다리길이 입력을 위해 InputView의 readBridgeSize 호출
2. 게임 실행을 위해 bridgeGameStart 메서드 실행

### 2. InputView의 ReadBridgeSize
    숫자가 아닐 시 예외처리
    3 ~ 20이 아닐 시 예외처리
숫자를 입력받고 BridgeMaker의 makeBridge로 전달하여 랜덤다리 생성

### 3. bridgeGameStart
    U, D가 아닐 시 예외처리
1. 랜덤다리 생성 
2. 입력받은 값과 다리의 값을 비교하는 movingCheck 메서드로 전달
   1. 같을 시 성공하거나 실패할 때 까지 진행
   2. 실패 시 break 후 retry문을 불러옴
3. 입력받은 값을 OutputView에도 전달하여 진행상황 출력

### 4. 성공, 실패를 확인하는 successOrFalseCheck 메서드

#### 4-1. 성공 시 : 최종값을 출력 후 종료하는 exit 메서드 실행

#### 4-1. 실패 시 : BridgeGame의 retry 호출
    R, Q가 아닐 시 예외처리
1. R 입력 시 clearAndRetry 구문 호출. 다리, output 값을 초기화 후 재시작
2. Q 입력 시 최종값을 출력 후 종료하는 exit 메서드 실행

### 5. 테스트코드 작성
### 6. 리팩토링