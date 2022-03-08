import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdBannerComponent } from './adShowFolder/ad-banner.component';
import { CreateTodoComponent } from './create-todo/create-todo.component';
import { EditTodoComponent } from './edit-todo/edit-todo.component';
import { ProfileComponent } from './profile/profile.component';
import { ShowTodoComponent } from './show-todo/show-todo.component';
import { ShowUsertodoComponent } from './show-usertodo/show-usertodo.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  { path: 'create', component: CreateTodoComponent },
  { path: 'show', component: ShowTodoComponent },
  { path: 'edit/:id', component: EditTodoComponent },
  { path: 'user-login', component: UserComponent },
  { path: 'showTodo', component: ShowUsertodoComponent },
  { path: 'user-register', component: UserRegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: '', redirectTo: 'user-login', pathMatch: 'full' }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
