define(['ojs/ojcore', 'knockout', 'ojs/ojarraydataprovider', 'ojs/ojtable'],
  function (oj, ko, ArrayDataProvider) {
    function EmployeesViewModel() {
      let self = this;

      // Sample employee data (you will later replace this with a REST API call)
      let employeeData = [
        { id: 1, name: 'John', salary: 1000 },
        { id: 2, name: 'Alice', salary: 1000 },
        { id: 3, name: 'Bob', salary: 2000}
      ];

      self.employeeObservableArray = ko.observableArray(employeeData);
      self.dataProvider = new ArrayDataProvider(self.employeeObservableArray, { keyAttributes: 'id' });
    }

    return new EmployeesViewModel();
  }
);
