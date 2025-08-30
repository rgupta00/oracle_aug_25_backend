define(['knockout', 'ojs/ojbootstrap', 'ojs/ojarraydataprovider'],
 function(ko, Bootstrap, ArrayDataProvider) {

  function EmployeeViewModel() {
    let self = this;

    self.employees = ko.observableArray([]);
    self.emp = ko.observable({ id: '', name: '', email: '' });

    const BASE_URL = "http://localhost:8080/api/employees";

    self.loadEmployees = function () {
      fetch(BASE_URL)
        .then(res => res.json())
        .then(data => self.employees(data));
    };

    self.saveEmployee = function () {
      const empData = ko.toJS(self.emp());

      let method = empData.id ? 'PUT' : 'POST';
      let url = empData.id ? `${BASE_URL}/${empData.id}` : BASE_URL;

      fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(empData)
      }).then(() => {
        self.emp({ id: '', name: '', email: '' });
        self.loadEmployees();
      });
    };

    self.editEmployee = function(emp) {
      self.emp({ ...emp });
    };

    self.deleteEmployee = function(emp) {
      fetch(`${BASE_URL}/${emp.id}`, { method: 'DELETE' })
        .then(() => self.loadEmployees());
    };

    self.loadEmployees();
  }

  return EmployeeViewModel;
});
