(function() {
    angular.module('app').controller('ExamplesController', ['ExamplesService', ExamplesController]);

    function ExamplesController(ExamplesService) {
        var vm = this;
        vm.learnDataSet= "";
        vm.dataSet= "";
        vm.getLearnDataSet = getLearnDataSet;
        vm.getDataSet = getDataSet;

        function getLearnDataSet() {
            ExamplesService.getDataSet(true)
            .then(function successCallback(response) {
                vm.learnDataSet = response.data
            }, function errorCallback(response) {
                vm.learnDataSet = response.data
            })
        }

        function getDataSet() {
            ExamplesService.getDataSet(false)
            .then(function successCallback(response) {
                vm.dataSet = response.data
            }, function errorCallback(response) {
                vm.dataSet = response.data
            })
        }
    }
})();
