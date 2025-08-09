define([], function () {
  const server_url = "http://localhost:8080/"; // Spring Boot base URL

  async function callGetService(serviceName) {
    return fetch(server_url + serviceName, {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    }).then(resp => resp.json());
  }

  return {
    callGetService
  };
});