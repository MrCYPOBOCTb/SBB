'use strict';

angular.module('SBB').controller("FahrplanController", [
    '$scope', 'FahrplanService', function ($scope, FahrplanService) {
        var self = this;
        self.fahrplan = {id: null, zugID: '', haltID: '', zeit:'',bemerkung: ''}
        self.fahrplaene = [];
        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;

        getAllFahrplan();

        function getAllFahrplan() {
            FahrplanService.getAllFahrplan()
                .then(
                    function (d) {
                        self.fahrplaene = d;
                    },
                    function (errResponse) {
                        console.error('FahrplanController: Error while fetching Fahrplaene');
                    }
                );
        }

        function addFahrplan(fahrplan) {
            FahrplanService.addFahrplan(fahrplan)
                .then(
                    getAllFahrplan(),
                    function (errResponse) {
                        console.error('FahrplanController: Error while creating new Fahrplan');

                    }
                );
        }

        function removeFahrplan(id) {
            FahrplanService.deleteFahrplan(id)
                .then(
                    getAllFahrplaene(),
                    function (errResponse) {
                        console.error('FahrplanController: Error while deleting Fahrplan');
                    }
                )

        }

        function updateFahrplan(fahrplan, id) {
            FahrplanService.updateFahrplan(fahrplan,id)
                .then(
                    getAllFahrplan(),
                    function (errResponse) {
                        console.error('FahrplanController: Error while updating Fahrplan');
                    }
                );
        }
        function submit() {
            if (self.fahrplan.id === null) {
                console.log('Saving New Fahrplan', self.fahrplan);
                addFahrplan(self.fahrplan);
            } else {
                updateFahrplan(self.fahrplan, self.fahrplan.id);
                console.log('Fahrplan updated with id ', self.fahrplan.id);
            }
            reset();
        }

        function edit(id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.fahrplaene.length; i++) {
                if (self.fahrplaene[i].id === id) {
                    self.fahrplaene = angular.copy(self.fahrplaene[i]);
                    break;
                }
            }
        }

        function remove(id) {
            console.log('id to be deleted', id);
            if (self.fahrplan.id === id) {//clean form if the user to be deleted is shown there.
                reset();
            }
            removeFahrplan(id);
        }


        function reset() {
            self.fahrplan = {id: null, zugID: '', haltID: '', zeit:'',bemerkung: ''};
            $scope.fahrplanForm.$setPristine(); //reset Form
        }    

}

])