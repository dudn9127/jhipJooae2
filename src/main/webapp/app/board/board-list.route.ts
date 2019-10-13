import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';

import { Board } from 'app/core/board/board.model';
import { BoardService } from 'app/core/board/board.service';
import { BoardListComponent } from 'app/board/board-list.component';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { BoardListWriteComponent } from 'app/board/board-list-write.component';

@Injectable({ providedIn: 'root' })
export class BoardListResolve implements Resolve<any> {
  constructor(private service: BoardService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return new Board();
  }
}

export const boardListRoute: Routes = [
  {
    path: '',
    component: BoardListComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      pageTitle: 'Board',
      defaultSort: 'id,asc'
    }
  },
  {
    path: 'new',
    component: BoardListWriteComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    }
  }
];
