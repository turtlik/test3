var api = "/api/talaba/";
var talaba_service = {
    getAll: function (success, error) {
        return http.get(api, success, error);
    },
    getById: function (id, success, error) {
        return http.get(api + "/" + id, success, error);
    },
    create: function (data, success, error){
        return http.post(api, data, success, error);
    },
    update: function (data, success, error){
         return http.put(api, data, success, error);
    },
    deleteById: function(id, success, error) {
    return http.delete(api + "/" + id, success, error);
    }
}