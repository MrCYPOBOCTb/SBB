angular
.module('SBB')
.factory('angebotService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8079/sbb-js/angebot';
    var factory = {
        buyAngebot: buyAngebot,
        searchZug: searchZug,
        searchFahrplan: searchFahrplan,
        cancelAngebot: cancelAngebot
    };
    
    function searchFahrplan() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then();
        return deferred.promise;
        
    }
    
    function buyAngebot(angebot) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI)
            .then();
        return deferred.promise;
        
    }
    function cancelAngebot(id){
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI)
            .then();
        return deferred.promise;
    }

}
]);