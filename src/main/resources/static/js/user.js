let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });

        $("#btn-login").on("click", () => {
            this.login();
        });
    },

    save: function () {
        let data = {
            userName: $("#userName").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        };

        $.ajax({
            type: "POST",
            url: "/api/user",
            // JSON.stringify()는 JavaScript 객체 또는 배열을 JSON 문자열로 변환하는 함수
            data: JSON.stringify(data),
            // 요청이 JSON 데이터임을 서버에게 알리는 헤더 정보
            contentType: "application/json; charset=utf-8",
            /* dataType: "text"로 지정된 경우, AJAX 요청을 통해 서버로부터 받은 응답 데이터가
            텍스트 형식으로 처리될 것으로 명시적으로 지정하는 것 */
            // 데이터타입을 json이라고 안적어줘도 알아서 던져준다.

            /*
            * 클라이언트가 요청하는 헤더에 Content-Type: application/json을 명시하면,
            * jQuery는 이를 인식하여 서버로 전송되는 데이터가 JSON 형식임을 알리게 됩니다.
            * 이에 따라 서버는 해당 요청을 JSON 데이터로 이해하고 처리하게 됩니다.
            * 서버는 클라이언트에게 응답할 때도 자동으로 Content-Type: application/json을 설정하여
            * JSON 형식으로 응답합니다.
            *
            *
            * 따라서, 클라이언트가 요청 헤더에 Content-Type: application/json을 명시하면,
            * jQuery는 서버로 요청을 보낼 때 해당 정보를 포함하고, 서버는 응답을 반환할 때 자동으로
            * Content-Type: application/json을 설정하여 JSON 형식으로 응답합니다.
            *
            *
            * */
            dataType: "json"
        }).done(function (resp) {
            alert("회원가입이 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    login: function () {
        let data = {
            userName: $("#userName").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        };

        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("로그인이 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

index.init();
