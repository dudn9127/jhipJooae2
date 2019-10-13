import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JooaeSharedModule } from 'app/shared/shared.module';
import { BoardListComponent } from 'app/board/board-list.component';
import { BoardListWriteComponent } from 'app/board/board-list-write.component';
import { boardListRoute } from 'app/board/board-list.route';

@NgModule({
  imports: [JooaeSharedModule, RouterModule.forChild(boardListRoute)],
  declarations: [BoardListComponent, BoardListWriteComponent],
  entryComponents: []
})
export class BoardListModule {}
