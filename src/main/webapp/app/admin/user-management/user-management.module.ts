import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JooaeSharedModule } from 'app/shared/shared.module';
import { UserMgmtComponent } from './user-management.component';
import { UserMgmtDetailComponent } from './user-management-detail.component';
import { UserMgmtUpdateComponent } from './user-management-update.component';
import { UserMgmtUpdateJooaeComponent } from './user-management-update-jooae.component';

import { UserMgmtDeleteDialogComponent } from './user-management-delete-dialog.component';
import { userManagementRoute } from './user-management.route';

@NgModule({
  imports: [JooaeSharedModule, RouterModule.forChild(userManagementRoute)],
  declarations: [
    UserMgmtComponent,
    UserMgmtDetailComponent,
    UserMgmtUpdateComponent,
    UserMgmtUpdateJooaeComponent,
    UserMgmtDeleteDialogComponent
  ],
  entryComponents: [UserMgmtDeleteDialogComponent]
})
export class UserManagementModule {}
