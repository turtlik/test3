let loginApi = '/authenticate';
var loginService = {
    login(user, success, error){
        http.post(loginApi, user, function(res){
            let jwt = JSON.parse(res);
            localStorage.setItem('token', jwt.token);
            success(res);
        }, error);
    }
}