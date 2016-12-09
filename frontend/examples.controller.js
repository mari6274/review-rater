(function () {
    angular.module('app').controller('ExamplesController', ['ExamplesService', ExamplesController]);

    function ExamplesController(ExamplesService) {
        var vm = this;
        vm.learnDataSet = "";
        vm.dataSet = "";
        vm.getLearnDataSet = getLearnDataSet;
        vm.getDataSet = getDataSet;
        vm.learnFeatures = [
            {key: "len", value: false},
            {key: "topWord", value: false}
        ];
        vm.features = [
            {key: "len", value: false},
            {key: "topWord", value: false}
        ];

        function getLearnDataSet() {
            ExamplesService.getDataSet(true, vm.learnFeatures
                .filter(function (feature) {
                    return feature.value;
                })
                .map(function (feature) {
                    return feature.key;
                })
                .join())
                .then(function successCallback(response) {
                    vm.learnDataSet = response.data
                }, function errorCallback(response) {
                    vm.learnDataSet = response.data
                })
        }

        function getDataSet() {
            ExamplesService.getDataSet(false, vm.features
                .filter(function (feature) {
                    return feature.value;
                })
                .map(function (feature) {
                    return feature.key;
                })
                .join())
                .then(function successCallback(response) {
                    vm.dataSet = response.data
                }, function errorCallback(response) {
                    vm.dataSet = response.data
                })
        }
    }
})();
