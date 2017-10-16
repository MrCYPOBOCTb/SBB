angular.module('SBB').factory('HaltService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8079/sbb-js/haltestelle/';

    var factory = {
        fetchAllHaltestelle:fetchAllHaltestelle,
        addHaltestelle: addHaltestelle,
        updateHalt: updateHalt,
        deleteHalt: deleteHalt
    };
    return factory;

     function fetchAllHaltestelle() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Halt_Service: Error while getting Haltestelle');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function addHaltestelle(haltestelle) {
        var deferred = $q.defer();

        $http.post(REST_SERVICE_URI, haltestelle)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Halt_Service: Error while creating Haltestelle');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function updateHalt(haltestelle, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, haltestelle)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Halt_Service: Error while updating Haltestelle');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteHalt(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Halt_Service: Error while deleting Haltestelle');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }



}]);