import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { User } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';
import { UserMgmtComponent } from './user-management.component';
import { UserMgmtDetailComponent } from './user-management-detail.component';
import { UserMgmtUpdateComponent } from './user-management-update.component';
import { UserMgmtUpdateJooaeComponent } from 'app/admin/user-management/user-management-update-jooae.component';

@Injectable({ providedIn: 'root' })
export class UserMgmtResolve implements Resolve<any> {
  constructor(private service: UserService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params['login'] ? route.params['login'] : null;
    if (id) {
      return this.service.find(id);
    }
    return new User();
  }
}

export const userManagementRoute: Routes = [
  {
    path: '',
    component: UserMgmtComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      pageTitle: 'Users',
      defaultSort: 'id,asc'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':login/view',
    component: UserMgmtDetailComponent,
    resolve: {
      user: UserMgmtResolve
    },
    data: {
      pageTitle: 'Users'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: UserMgmtUpdateComponent,
    resolve: {
      user: UserMgmtResolve
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'newJooae',
    component: UserMgmtUpdateJooaeComponent,
    resolve: {
      user: UserMgmtResolve
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':login/edit',
    component: UserMgmtUpdateComponent,
    resolve: {
      user: UserMgmtResolve
    },
    canActivate: [UserRouteAccessService]
  }
];
