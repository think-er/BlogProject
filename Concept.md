1. GET 요청
<br> http://localhost:8000/blog/user?username=ssar
<br> 특징 : 요청 시에 바디로 데이터를 담아 보내지 않는다.

2. POST(INSERT), PUT(UPDATE), DELETE 요청 (데이터를 변경)
<br>
- 데이터를 담아보내야 할 것이 많음.
- ex) userName, password, email, address, gender, createDate
- form 태그 method = 'POST' 
- form 태그 -> GET 요청, POST 요청 밖에 못한다. (Key = Value)
- PUT, DELETE 요청을 할 때는 fomr 태그를 사용하지 못함. -> 자바스크립트로 요청을 해야함.
<br> 통일 : 자바스크립트로 ajax 요청 + 데이터는 json으로 통일하는 것이 좋다
<br> form:form 태그? -> POST, PUT, DELETE, GET 요청도 가능한 태그가 있기는 하다.

3. 오브젝트로 데이터 받기
<br> POST 방식의 Key = Value (x-www-form-urlencoded)
<br> userName = ssar (O)
<br> password2 = 1234 (X) null 값이 들어가게 될 것이다.


4. Key = value가 아닌 데이터는 어떻게 파싱할까?
<br> json 데이터나 일반 text 데이터를 스프링 컨트롤러에서 받기 위해서는 @RequestBody 라는 어노테이션 필요
<br> 기본 전략이 스프링 컨트롤러에서는 key = value 데이터를 파싱해서 받아주는 역할을 함.
<br> @RequestBody 어노테이션이 붙으면 MessageConverter를 구현한 Jackson 라이브러리가 발동하면서 json 데이터를 자바 오브젝트로 파싱해서 받아준다.

5. 그렇다면 form 태그로 json 데이터를 어떻게 전송할 수 있는가?
<br> id? 내가 아는 이 id는 css랑 관련있는데?
<br> 자바스크립트에서 이 id가 상관이 있고, 필요한 것인가?
