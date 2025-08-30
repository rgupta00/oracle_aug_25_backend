define(['knockout'], function(ko) {
  function ControllerViewModel() {
    var self = this;
    self.moduleConfig = ko.observable({ viewName: 'views/employee.html', viewModelFactory: function() {
      return import('viewModels/employee');
    }});
  }
  return new ControllerViewModel();
});
