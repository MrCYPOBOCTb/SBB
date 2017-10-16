'use strict';

angular.module('SBB').factory('FahrplanService',['$http', '$q', function ($http, $q) {
    var REST_SERVICE_URI = 'http://localhost:8079/sbb-js/fahrplan/';
    var factory = {
        getAllFahrplan:getAllFahrplan,
        addFahrplan: addFahrplan,
        deleteFahrplan: deleteFahrplan,
        updateFahrplan: updateFahrplan
    };
    return factory;

    function getAllFahrplan() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Halt_Service: Error while getting Fahrplan');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function addFahrplan(fahrplan) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, fahrplan)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Fahrplan_Service: Error while creating Fahrplan');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function updateFahrplan(fahrplan, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, fahrplan)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Fahrplan_Service: Error while updating Fahrplan');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteFahrplan(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Fahrplan_Service: Error while deleting Fahrplan');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}
])