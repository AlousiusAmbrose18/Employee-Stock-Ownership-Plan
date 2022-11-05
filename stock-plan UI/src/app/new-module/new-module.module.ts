import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewclassComponent } from './newclass/newclass.component';
import { NewRoutingModule } from './new-routing/new-routing.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    NewclassComponent
  ],
  imports: [
    CommonModule,
    NewRoutingModule
  ]
  
})
export class NewModuleModule { }
