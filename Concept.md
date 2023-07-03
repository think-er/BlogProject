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
