(function() {
    angular.module('app').service('ReviewsService', ['$http', ReviewsService]);

    function ReviewsService($http) {
        this.getReview = getReview;

        return this;

        function getReview(id) {
            return $http.get(
                'http://localhost:8080/reviews/' + id
            );
        }
    }
})();
