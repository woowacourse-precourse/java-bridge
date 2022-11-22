다리건너기 게임
-
사용자에게 다리 길이를 입력 받고 해당 길이만큼 다리를 생성 후 U,D를 이용해 앞으로 이동하는 게임 
````
🖐 기능 요구 사항 정리
    - 입력
        - 다리 길이 입력
            - 3 이상 20 이하의 숫자 ✅
            - 예외 처리
                - 숫자가 아닌 경우 ✅
                - 범위 안의 숫자가 아닌 경우 ✅
        - 이동 칸 입력
            - U(위)와 D(아래)만을 입력 ✅
            - 소문자 대문자 변경(Upper)✅
            - 예외 처리
                - 한자리가 아닌 경우 ✅
                - U와 D가 아닌 경우 ✅
        - 게임 다시 시도 입력
            - R(재시작)과 Q(종료) 중 하나의 문자 ✅
            - 소문자 대문자 변경(Upper) ✅
            - 예외 처리
                - 한자리가 아닌 경우 ✅
                - R(재시작)과 Q(종료)가 아닌 경우 ✅
    - 출력
        -시작 멘트 ✅
        -다리 길이 멘트 ✅
        -이동 경과 출력 ✅
        -최종 결과 출력 ✅
        -재시작 멘트 ✅
    - 게임 진행
        -입력 받은 길이로 다리 랜덤 생성 ✅
        -정답과 사용자 입력 문자 매칭 ✅
        -오답 시 게임 재시작 여부 ✅
````
````
🖐 프로그래밍 요구 사항
    - 사용자 입력이 잘못된 경우 IllegalArgumentException을 발생 후 다시 입력 받는다. ✅
    - 함수(메서드) 길이 10이하 ✅
    - 메서드 파라미터 최대 3개 ✅
    - BridgeGame에서 outputview, inputview 사용 금₩
    - BridgeMaker
        -BridgeMaker의 필드(인스턴스 변수)를 변경 불가
        -메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가
````
````
🖐 학습 사항
    - java.lang.String
        ‼️학습 계기
            - 다리건너기 게임의 결과를 출력할 때 '|' 구분 기호를 넣는 과정에서 학습하게 되었다.
            - 문자열 처리를 조금 더 유연하게 하기 위해서 찾아보았다.
        -문자열 처리를 돕는 클래스
        -자바의 String은 객체 인스턴스이다.
        - join, replace, indexOf 등 다양한 기능이있다.
        👉join기능을 사용해 구분자를 |로 하여 List에 들어있는 문자열들을 출력 요소로 처리해줬다.
    - 자바의 String, StringBuilder 와 StringBuffer
        ‼️학습 계기
            - 위의 API를 공부하다 추가적인 궁금증
        - 구조
            구조를 보면 StringBuffer와 StringBuilder는 AbstractStringBuilder를 상속 받고 있다.
            StringBuffer는 synchronized가 있어 동기 처리를 해준다.
            반대로 StringBuilder는 동기 지원을 하지 않는다.
        - String
            - 불변의 속성
                ex) 처음에 String s = 'hello'라는 문자열을 선언하면 메모리에 공간할당을 받는다.
                    하지만 s+='world'를 하게 되면 'helloworld'라는 문자열로 새롭게 메모리를 할당 받는다.
            - 위의 속성 때문에 문자열의 수정,추가,삭제가 빈번히 일어나면 가비지가 많아져 성능에 영향을 미치게 된다.
        - StringBuffer
            - 멀티 쓰레드 환경에서 안전하다(thread-safe) // String 또한 불변 객체이기 때문에 thread-safe하다.
        - StringBuilder
            - 동기화를 지원하지 않기 때문에 멀티 쓰레드 환경에서는 사용하지 않는게 좋다.
            - 하지만 단일 쓰레드에서는 StringBuffer보다 성능이 좋다.
        👉 문자열의 연산이 많아진다면 StringBuffer나 StringBulider를 사용하자
            쓰레드 환경에 따라 Buffer와 Builder를 선택하여 사용
    - checkedException과 UncheckedException
        ‼️학습 계기
            - Exception에 대해 찾아보다가
        - Exception
            - Exception은 비정상적인 상황이 발생 시 발생하는 것
        -   상위 클래스인 Exception을 보면 두가지로 나뉜다.
            RuntimeException과 그 외 Exception
            이 중 RuntimeException의 하위 클래스를 unchecked Exception
            그 외의 에러를 checked Exception이라 한다.
        - checked Exception
            컴파일러가 에러 확인을 하기 때문에 try~catch문을 사용하여 에러 처리를 반드시 해줘야한다.
            ex) IOException 등
        - unchecked Exception
            RuntimeException. 말그대로 실행 중 발생하는 에러를 뜻한다.
            ex) NullpointException, IllegalArgumentException 등
        👉 상위 클래스인 Exception은 runtimeException과 그 외 Exception으로 나뉜다.
            이 둘의 차이는 컴파일러가 에러를 확인 유무에 따라 나뉜다. 
            checkedExcpetion은 컴파일러가 에러를 확인 하기 때문에 에러 처리를 해주어야한다.
            uncheckedException은 에러처리를 강제하지 않는다.
        
````