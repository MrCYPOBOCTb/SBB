angular
    .module('SBB')
    .controller("indexController", function ($window,$location,$scope) {
        $scope.haltEdit = function () {
            document.getElementById('fahrplanContainer').style.display='none';
            document.getElementById('haltestelleContainer').style.display='block'
        }

        $scope.fahrplanEdit = function () {
            document.getElementById('haltestelleContainer').style.display='none';
            document.getElementById('fahrplanContainer').style.display='block'
        }

    });
