## 🧭 구현할 기능 목록

### 다리 건너기
`Application.java`   
- [x] 다리 건너기 게임 실행  

`InputView.java`    
- [x] 입력 처리 기능 수행  
- [x] 다리 길이 입력  
- [x] 사용자 이동 칸 입력  
- [x] 게임 재시작 여부 입력  

`OutputView.java`   
- [x] 출력 처리 기능 수행  
- [x] 게임 최종 결과 출력  
- [x] 현재 이동 다리 상태 출력  
- [x] 게임 오프닝 멘트 출력
- [x] 이동할 칸 입력 요구 출력  
- [x] 재시작 여부 입력 요구 출력  

`InputVerify.java`    
- [x] 블럭 사이즈 검증  
  - [x] 공백 입력 여부 검증  
  - [x] 입력값 숫자 여부 검증  
  - [x] 입력 숫자 값 범위 검증  
- [x] 이동 명령 검증  
  - [x] 입력 문자 이동 명령 여부 검증  
- [x] 제어 명령 검증  
  - [x] 입력 문자 제어 명령 여부 검증  

`Constants.java`    
상수 클래스  

`BridgeGameException.java`    
예외 처리 메소드와 에러 메시지 상수를 담당하는 클래스 
`Constants` 클래스와 유사하지만 에러 메시지는 예외 처리를 담당하는 해당 클래스에서 처리.  
- [x] illegalArgumentException 예외 처리  

`BridgeNumberGenerator.java` 와 `BridgeRandomNumberGenerator.java`  
요구사항에 의거하여 별도 수정 없이 사용만 할 인터페이스와 클래스.  
`generate()`를 통해 0 또는 1을 받아 그에 해당하는 다리 상태를 `BrigeMaker`클래스에서 할당 예정.  

`BridgeMaker.java`  
- [x] 다리 생성 기능 수행  

`BridgeGame.java`  
- [x] 게임 실행(run) 메소드  
- [x] 게임 준비(init) 메소드  
- [x] 게임 루프 동작(loop) 메소드  
- [x] 플레이어 이동(move) 메소드  
- [x] 단계 처리(process) 메소드  
- [x] 게임 재시작(retry) 메소드  
- [x] 게임 종료(finish) 메소드  

`BridgeStage.java`  
- [x] 게임판(다리) 생성  
- [x] 다리 이동  
- [x] 다리 이동에 따른 결과 처리  
- [x] 다리 완주  
- [x] 게임 재시작  


