(function() {
    angular.module('app').controller('MainController', ['PredictionsService', MainController])

    function MainController(PredictionsService) {
        vm = this
        vm.predictions= "";
        vm.response= "";
        vm.postPredictions = postPredictions
        vm.calcColor = calcColor

        function postPredictions() {
            PredictionsService.postPredictions(vm.predictions)
            .then(function successCallback(response) {
                vm.response = response.data
            }, function errorCallback(response) {
                vm.response = response.data
            })
        }

        function calcColor(diff) {
            var d = Math.abs(diff.grade - diff.predictedGrade)
            if (d < 1) {
                return "lightgreen";
            } else if (d < 2) {
                return "yellow";
            } else if (d < 3) {
                return "orange";
            } else {
                return "red";
            }
        }
    }
})()
