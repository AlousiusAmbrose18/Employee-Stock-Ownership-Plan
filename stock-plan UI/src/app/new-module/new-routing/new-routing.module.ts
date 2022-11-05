import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { NewclassComponent } from '../newclass/newclass.component';

const routes : Routes=[
  {
    path:"newclass", component: NewclassComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)

  ],
  exports:[RouterModule]
})
export class NewRoutingModule { }
