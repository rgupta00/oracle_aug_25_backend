import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserService } from '../services/user.service';

export const activateGuard: CanActivateFn = (route, state) => {
  const userService = inject(UserService);
  const router = inject(Router);

  if (userService.isAdminRight()) {
    return true;
  } else {
    alert('You do not have permission to access this page.');
    return false;
  }
};
