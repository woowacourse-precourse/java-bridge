## 기능목록

```
<구현 목표>
1. 클래스(객체)를 분리하는 연습
2. 리팩터링
3. 도메인 로직에 대한 단위 테스트를 작성하는 연습
```

1. 입력
    - 입력값 검증
        - 다리의 길이
          - 3 ~ 20의 숫자만 입력 가능 -> 아닌 경우 예외처리
            - 소수의 경우 -> 예외처리
          - 숫자가 아닌 경우 -> 예외처리
        - 라운드마다 플레이어가 이동할 칸 입력
          - U / D 만 입력 가능 -> 아닌 경우 예외처리
          - 숫자 입력 시 예외처리
        - 게임 재시작/종료 여부 입력 
          - R / Q 만 입력 가능 -> 아닌 경우 예외처리
          - 숫자 입력 시 예외처리
2. 게임 로직 구현
   - Enum 정의
     - 게임의 답 (Answer)
       - 성공(true) / 실패(false)
     - 이동
       - UP(U, 1) / DOWN(D, 0)
   - Bridge Game 클래스
     - [함수] 게임 시작 Play()
   - Game 클래스
     - [변수] private int 게임 횟수 카운팅
     - [변수] private Answer 게임 최종 결과
     - [함수] 게임 횟수 카운팅 올리는거 
     - [함수] 게임 최종 결과 setter 하는거
3. 예외 클래스 작성
    - static final 상수 -> `"[ERROR]"` 생성
    - 잘못된 값 입력(validate error) -> `IllegalArgumentException`
        - 각 예외 던질 때 붙여서 전달
4. 기능 구현을 바탕으로 4layer architecture 로 리팩토링
    - 도메인 단위의 기능을 명확히 하기 위함
    - 도메인 정의
    - 각 controller, domain, service, view의 할 일 정의
---

### 기능적 요구사항
- 프로그램 종료 시 System.exit()를 사용 금지
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현. 2까지만 허용
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 3항 연산자를 사용 금지
- 기능 목록이 정상 동작함을 테스트 코드로 확인
- InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현
  - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현
  - InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받도록 함
  - BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

### 비기능적 요구사항
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현
- 메서드의 파라미터 개수는 최대 3개까지만 허용
- Java Enum을 적용
- 도메인 로직에 단위 테스트를 구현
- 


## 커밋 컨벤션

- 영어로 작성
- `type: detail text` 형태로 작성
- type
    - feat (feature)
    - fix (featrue fix and bugfix)
    - docs (documentation)
    - style (formatting, missing semi colons, …)
    - refactor
    - test (when adding missing tests)
