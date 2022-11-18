## 다리건너기 게임
### 1. Application 클래스
1. 다리길이 입력을 위해 InputView의 readBridgeSize 호출
2. 게임 실행을 위해 BridgeGame의 move 호출
3. 실패 시 재실행을 위한 BridgeGame의 retry 호출

### 2. InputView의 ReadBridgeSize
    --다리생성--
    숫자가 아닐 시 예외처리
    3 ~ 20이 아닐 시 예외처리
입력받은 숫자를 BridgeMaker의 makeBridge로 전달하여 랜덤다리 생성

### 3. BridgeGame의 move 호출
    한자리 문자열이 아닐 시 예외처리
    U, D가 아닐 시 예외처리
1. InputView의 readMoving을 호출, 값을 입력받음  
2. OutputView를 이용하여 진행상황 출력

### 4-1. 실패 시 BridgeGame의 retry 호출
    한자리 문자열이 아닐 시 예외처리
    R, Q가 아닐 시 예외처리
1. R 입력 시 BridgeGame의 move 재호출
2. Q 입력 시 OutputView의 printResult 출력 후 종료

### 4-2. 성공 시 
OutputView의 printResult 출력 후 종료

### 5. 리팩토링
### 6. 테스트코드 작성