angular.module('SBB').controller('HaltestelleController', [
    '$scope', 'HaltService', function ($scope, HaltService) {
        var self = this;
        self.haltestelle = {id: null, uic:parseInt(uic,10), name: '', bemerkung: ''};
        self.haltestellen = [];
        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;

        fetchAllHaltestelle();

        function fetchAllHaltestelle() {
            HaltService.fetchAllHaltestelle()
                .then(
                    function (d) {
                        self.haltestellen = d;
                    },
                    function (errResponse) {
                        console.error('Halt_Controller: Error while fetching Haltestellen');
                    }
                );
        }

        function addHaltestelle(haltestelle) {
            HaltService.addHaltestelle(haltestelle)
                .then(
                    fetchAllHaltestelle,
                    function (errResponse) {
                        console.error('Halt_Controller: Error while creating new Haltestelle');
                    }
                );
        }

        function updateHalt(haltestelle, id) {
            HaltService.updateHalt(haltestelle, id)
                .then(
                    fetchAllHaltestelle,
                    function (errResponse) {
                        console.error('Halt_Controller: Error while updating Haltestelle');
                    }
                );
        }

        function deleteHalt(id) {
            HaltService.deleteHalt(id)
                .then(
                    fetchAllHaltestelle,
                    function (errResponse) {
                        console.error('Halt_Controller: Error while deleting Haltestelle');
                    }
                );
        }

        function submit() {
            if (self.haltestelle.id === null) {
                console.log('Saving New Halt', self.haltestelle);
                addHaltestelle(self.haltestelle);
            } else {
                updateHaltestelle(self.haltestelle, self.haltestelle.id);
                console.log('Haltestelle updated with id ', self.haltestelle.id);
            }
            reset();
        }

        function edit(id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.haltestellen.length; i++) {
                if (self.haltestellen[i].id === id) {
                    self.haltestelle = angular.copy(self.haltestellen[i]);
                    break;
                }
            }
        }

        function remove(id) {
            console.log('id to be deleted', id);
            if (self.haltestelle.id === id) {//clean form if the user to be deleted is shown there.
                reset();
            }
            deleteHalt(id);
        }


        function reset() {
            self.haltestelle = {id: null, uic: null, name: '', bemerkung: ''};
            $scope.haltForm.$setPristine(); //reset Form
        }


    }
])