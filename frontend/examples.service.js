(function() {
    angular.module('app').service('ExamplesService', ['$http', ExamplesService]);

    function ExamplesService($http) {
        this.getDataSet = getDataSet;

        return this;

        function getDataSet(learn) {
            return $http.get('http://localhost:8080/examples?learn=' + learn);
        }
    }
})();
