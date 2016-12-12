(function() {
    angular.module('app').controller('LoadingController', ['LoadingService', LoadingController]);

    function LoadingController(LoadingService) {
        var vm = this;
        vm.isLoading = isLoading;

        function isLoading() {
            return LoadingService.isLoading();
        }
    }
})();
