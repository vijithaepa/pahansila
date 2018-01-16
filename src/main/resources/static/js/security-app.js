/**
 * Created by vepa on 12/10/17.
 */
(function () {

    'user strict'
    var app = angular.module('app', []);

    app.constant('API_URL', 'http://localhost:3000');
    
    app.controller('MainCtrl', function MainCtrl(RandomUserFactory, UserFactory) {

        'user strict'
        var ctrl = this;

        ctrl.getRandomUser = getRandomUser;
        ctrl.login = login;

        function getRandomUser() {
            RandomUserFactory.getUser().then(function success(response){
               ctrl.randomUser = response.data;
            }, handleError);
        }

        function login(username, password) {
            UserFactory.login(username, password).then(function success(response) {
                ctrl.user = response.data;
            }, handleError);
        }

        function handleError(response) {
            alert('Error : ' + response.data);
        }
    });

    app.factory('RandomUserFactory', function ($http, API_URL) {
        'use strict'
        return {
            getUser : getUser
        };

        function getUser() {
            return $http.get(API_URL + '/random-user');
        };
    });

    app.factory('UserFactory', function ($http, API_URL) {
        'use strict'
        return {
            login : login
        };

        function login(username, password) {
            return $http.post(API_URL + '/login', {
                username: username,
                password: password
            });
        };
    });

})();
