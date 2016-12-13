(function () {
    angular.module('app').controller('ExamplesController', ['ExamplesService', 'LoadingService', ExamplesController]);

    function ExamplesController(ExamplesService, LoadingService) {
        var vm = this;
        vm.learnDataSet = "";
        vm.dataSet = "";
        vm.getLearnDataSet = getLearnDataSet;
        vm.getDataSet = getDataSet;
        vm.learnFeatures = [
            {key: "len", value: false},
            {key: "topWord", value: false},
            {key: "posWordsCount", value: false},
            {key: "negWordsCount", value: false},
            {key: "bigrams", value: false}
        ];
        vm.features = angular.copy(vm.learnFeatures);

        function getLearnDataSet() {
            LoadingService.switchOn();
            ExamplesService.getDataSet(true, vm.learnFeatures
                .filter(function (feature) {
                    return feature.value;
                })
                .map(function (feature) {
                    return feature.key;
                })
                .join())
                .then(function successCallback(response) {
                    vm.learnDataSet = response.data;
                }, function errorCallback(response) {
                    vm.learnDataSet = response.data;
                }).finally(function finalCallback() {
                    LoadingService.switchOff();
                });
        }

        function getDataSet() {
            LoadingService.switchOn();
            ExamplesService.getDataSet(false, vm.features
                .filter(function (feature) {
                    return feature.value;
                })
                .map(function (feature) {
                    return feature.key;
                })
                .join())
                .then(function successCallback(response) {
                    vm.dataSet = response.data;
                }, function errorCallback(response) {
                    vm.dataSet = response.data;
                }).finally(function () {
                    LoadingService.switchOff();
                });
        }
    }
})();
