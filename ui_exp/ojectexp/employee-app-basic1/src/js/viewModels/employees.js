define([
  'knockout',
  '../services/commonService',
  'ojs/ojarraydataprovider',
  'ojs/ojtable'
], function (ko, commonService, ArrayDataProvider) {
  function EmployeesViewModel() {
    var self = this;

    self.employees = ko.observableArray([]);
    self.dataProvider = new ArrayDataProvider(self.employees, { keyAttributes: 'id' });

    self.loadEmployees = function () {
      commonService.callGetService('employees')
        .then(function (response) {
          self.employees(response);
        })
        .catch(function (err) {
          console.error("Failed to load employees", err);
        });
    };

    self.connected = function () {
      self.loadEmployees();
    };
  }

  return EmployeesViewModel;
});
