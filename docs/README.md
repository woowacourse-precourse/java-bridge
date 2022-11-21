
# 프로그램 순서도

1. 다리 건너기 게임 시작 및 출력
2. 다리의 길이 입력
3. 이동할 칸 선택 입력
4. 이동한 칸에 대한 출력
5. 3번과 4번 반복
6. 성공 시 최종 게임 결과 출력 (재시도 불가)
7. 실패 시 게임 재시도 여부 출력
8. 게임 종료 출력 (게임 성공 여부, 총 시도 횟수 출력)

# 디렉터리 구조
```
bridge
    └ program
        └ BridgeGameProgram.java    
    └ domain
        ├ BridgeGame.java
        ├ BridgeMaker.java
        ├ BridgeOfComputer.java
        ├ BridgeOfUser.java
        └ common
            ├ BridgeNumberGenerator.java
            ├ BridgeRandomNumberGenerator.java
            └ Side.java
    └ utils
        └ Validator.java
    └ view
        ├ ConsoleView.java
        ├ InputView.java
        └ OutputView.java  
    └ Application.java
```

# 구현

- [x] 다리 건너기 게임 Module 생성

- 다리 건너기 게임 시작
  - [x] 게임 시작 문구 출력
  
- 다리 생성
  - 다리 길이 입력
    - [x] 다리 길이 입력 요청 문구 출력
    - [x] 다리 길이 입력 요청
        - [x] (유효성) 숫자
  - 다리 생성 로직
    - [x] BridgeRandomNumber 구현체를 이용한 BridgeMaker 생성
    - [x] 다리 길이 입력(size)만큼의 block 만들기
        - [x] (유효성) 3 이상 20 이하
    - [x] 랜덤값에 따른 블럭 채우기
        - [x] (유효성) 0 또는 1
        - [x] Side Enum 생성
      
- 게임 시작
  - 이동 블럭 입력
    - [x] 이동할 칸 입력 요청 문구 출력
    - [x] 이동할 칸 입력 요청
        - [x] (유효성) 1자리 문자
        - [x] (유효성) U or D
  - 블럭 이동
    - [x] 컴퓨터의 블럭과 일치하면 성공, 일치하지 않으면 실패
    - [x] 실패 여부 확인
      - [x] 재시도 여부 입력 요청 문구 출력
      - [x] 재시도 여부 입력 요청
        - [x] 재시도 시 게임 리셋
  - 반복
      
- 게임 결과 출력
  - [x] 게임 결과 출력 코멘트 출력
  - [x] 현재 상태 출력
  - [x] 성공 여부 와 재시도 횟수 출력
