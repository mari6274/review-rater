(function() {
    angular.module('app').service('LoadingService', [LoadingService]);

    function LoadingService() {
        var service = this;
        service.loadingCounter = 0;
        service.isLoading = isLoading;
        service.switchOn = switchOn;
        service.switchOff = switchOff;

        return service;

        function isLoading() {
            return service.loadingCounter !== 0;
        }

        function switchOn() {
            service.loadingCounter++;
        }

        function switchOff() {
            service.loadingCounter--;
        }

    }
})();
