var api = "/api/talaba";
var talaba_service = {
    getAll: function (success, error) {
        return http.get(api, success, error);
    },
    getById: function (id, success, error) {
        return http.get(api + "/" + id, success, error);
    },
    create: function (data, success, error){

    }
}