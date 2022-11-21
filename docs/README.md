## 🚀 기능 목록
- ## 컨트롤러
  - [ ] 다리 건너기 게임 컨트롤러
- ## 데이터
  - DTO
    - RequestDto 및 ResponseDto
      - [X] 게임 초기화 명령어
      - [ ] 게임 진행 명령어
      - [ ] 실패 메뉴 명령어
      - [ ] 게임 최종 결과
  - DAO
    - [X] 게임 정보 Dao
  - Repository
    - [X] 게임 정보 Repository
  - Entity
    - [ ] 다리 건너기 게임
- ## 서비스
  - [X] 다리 제작
  - [ ] 다리 건너기 게임
- ## 뷰
  - ### 입력
    - [X] `3 ~ 20` 다리 길이
    - [ ] `U` or `D` 이동할 칸
    - [ ] `R` or `Q` 재시작/종료 여부
  - ### 출력
    - [X] 게임 시작 문구
      - 시작 메시지, 길이 입력 메시지
    - [ ] 게임 진행 문구
      - 진행 입력 메시지, 지도
    - [ ] 게임 재시작 문구
      - 재시작 질문 메시지
    - [ ] 게임 종료 문구
      - 종료 메시지, 지도, 성공 여부, 시도 횟수
    - [ ] 에러 문구
- ## 타입
  - [X] 게임 일반 상수 타입
  - [X] 게임 상태 타입 (INIT, PLAY, FAIL, RESULT, DONE)
  - [X] 게임 지도 구성 요소 타입
  - [X] 진행 명령어 타입
  - [X] 메뉴 명령어 타입
  - [X] 게임 진행 메시지 타입
  - [X] 에러 메시지 타입

## ✏ 과제를 진행하며 배운 점
- IllegalArgumentException 과 IllegalStateException은 어떤 상황에 발생시키 오류인가?[[참조](https://stackoverflow.com/questions/20169127/what-is-illegalstateexception)]
  - IllegalStateException 이란?
    - 메서드가 호출 되면 안되는 때에 호출 됐을 때 발생시키는 런타임 익셉션의 한 종류.
    - 실행 중에 일어날 수 없는 일을 일으키려 할 때 발생 시키는 것이다.
    ```java
    public class Game {
      private boolean isFinished;
      
      public Game() {
      isFinished = false;
      }  
    
      public void terminate() {
          if (isFinished == true) {
              throw new IllegalStateException("게임이 이미 종료되었습니다.");
          }
          this.isFinished = true;
      }
    
      public static void main(String[] args) {
          Game game = new Game();
          game.terminate();
          game.terminate();
        }
    }
    ```
  - IllegalArgumentException 이란?
    - 잘못된 인자값이 주어졌을 때 발생시키는 런타임 익셉션의 한 종류.
    - 들어온 인자값의 타입은 맞는데, 값이 이상할 때(범위 문제나 포맷 문제, Null 문제 등) 발생 시키는 것이다.
    ```java
    public class Person {
      private int age;

      public void setAge(int age) {
          if (age < 0) {
              throw new IllegalArgumentException("나이는 0보다 커야합니다.");
          }
          this.age = age;
      }
    
      public static void main(String[] args) {
          Person person = new Person();
          person.setAge(-1);
        }
    }
    ```

## 고민했던 점
- 하나의 DTO가 어디까지 쓰여도 괜찮은가?

  ```
  DTO란, 레이어간 데이터 교환을 위해 사용하는 객체이다. 
  레이어를 오가며 DTO에 들어있는 정보가 바뀔 염려가 있기 때문에, 
  저장이 필요할 땐 DTO를 Entity로 변환해 저장한다.
  ```
  
  라는 건 지난 주 과제를 Layered Architecture로 구현해보며 배웠다. 하지만 아직도 의문이 드는 건, 
  
  *"그럼 View에서 만들어진 DTO가 Controller를 거쳐 Service 까지 갔다가, 다시 Controller로 돌아와서 View로 가는 것이 괜찮은가?"*
  
  라는 점이다. 
  
  일단, Service에서 사용된 DTO를 그대로 반환해 View까지 가져가는 것이 안좋다는 것은 알겠다. 
  DTO가 하나 혹은 여러 개의 Service를 돌아다니며 인스턴스에 저장된 값은 언제든 변할 수 있기도 하고,
  한 Service에서 사용했던 값이 다른 Service나 View에는 필요 없는데도 불구하고 접근할 수 있는 권한이 생기기 때문이다.
  
  그럼 View - Controller - Service 이 세 레이어에서는 같은 DTO를 사용해도 괜찮을까?
  
  처음에는 '사용해도 상관 없다'고 생각했었다. Controller는 오직 Service를 매핑해 줄 뿐, DTO를 수정하지 않는다고 생각했었다.
  하지만 [이 글](https://techblog.woowahan.com/2711/)을 보고 그게 아니라는 것을 깨달았다.
  
  > 사용자 요청의 파라미터를 통해 외부 API를 여러번 호출한 이후 Service 레이어를 호출하는 경우, Controller가 받은 Web DTO와 Service가 받아야 할 DTO가 달라집니다.
  
  만약 이렇게 될 경우, Controller에서 필요한 값과 Service에서 필요한 값이 달라지게 된다. 따라서 이렇게 외부 API를 사용하는 경우는, Controller에서 사용할 DTO를 새로 정의해 주는 게 좋겠다.
  
  하지만 현재 진행하는 과제들은 확실히 그런 확장성이 배제된 상태이다. 그런 상황에 외부 API 사용 같은 특정 상황을 고려해 새로운 DTO를 만들어 반복되는 코드를 집어 넣는 게 옳은가에 대해 생각해보면 또 아니라고 할 수 있겠다.
  
  결론은, 이런 DTO의 사용 범위는 '100% 이거다!' 라고 할 수는 없고, 프로젝트의 규모와 아키텍쳐의 방향 등을 종합적으로 고려해서 고민할 문제인 것 같다.

- 패키지 구조는 어떻게 설계해야 하는가?
  