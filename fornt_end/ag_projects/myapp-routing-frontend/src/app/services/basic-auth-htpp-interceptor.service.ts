import { HttpInterceptorFn } from '@angular/common/http';

export const basicAuthInterceptor: HttpInterceptorFn = (req, next) => {
  const username = sessionStorage.getItem('username');
  const authHeader = sessionStorage.getItem('basicauth');

  if (username && authHeader) {
    req = req.clone({
      setHeaders: {
        Authorization: authHeader
      }
    });
  }

  return next(req);
};