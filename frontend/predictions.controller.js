(function() {
    angular.module('app').controller('PredictionsController', ['PredictionsService', 'LoadingService', 'ReviewsService', PredictionsController]);

    function PredictionsController(PredictionsService, LoadingService, ReviewsService) {
        var vm = this;
        vm.predictions= "";
        vm.response= "";
        vm.postPredictions = postPredictions;
        vm.calcColor = calcColor;
        vm.getReview = getReview;

        function postPredictions() {
            LoadingService.switchOn();
            PredictionsService.postPredictions(vm.predictions)
            .then(function successCallback(response) {
                vm.response = response.data;
            }, function errorCallback(response) {
                vm.response = response.data;
            }).finally(function () {
                LoadingService.switchOff();
            });
        }

        function calcColor(diff) {
            var d = Math.abs(diff.grade - diff.predictedGrade);
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
        
        function getReview(id) {
            ReviewsService.getReview(id)
                .then(function successCallback(response) {
                    alert(response.data.review)
                }, function errorCallback(response) {
                    alert("Error");
                });
        }
    }
})();
