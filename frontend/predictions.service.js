(function() {
    angular.module('app').service('PredictionsService', ['$http', PredictionsService])

    function PredictionsService($http) {
        this.postPredictions = postPredictions;

        return this;

        function postPredictions(predictions) {
            return $http.post(
                'http://localhost:8080/predictions',
                predictions,
                {
                    headers: { 'Content-Type': 'text/plain'}
                }
            );
        }
    }
})()
