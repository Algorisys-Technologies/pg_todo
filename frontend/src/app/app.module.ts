import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTodoComponent } from './create-todo/create-todo.component';
import { ShowTodoComponent } from './show-todo/show-todo.component';
import { EditTodoComponent } from './edit-todo/edit-todo.component';
import { UserComponent } from './user/user.component';
import { ShowUsertodoComponent } from './show-usertodo/show-usertodo.component';
import { UserRegisterComponent } from './user-register/user-register.component';

import { ProfileComponent } from './profile/profile.component';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { HighlightDirective } from './directives/highlight.directive';
import { TdhighlightDirective } from './directives/tdhighlight.directive';
import { SearchHighlightPipe } from './pipes/search-highlight.pipe';
import { AdBannerComponent } from './adShowFolder/ad-banner.component';
import { AdDirective } from './adShowFolder/ad.directive';

@NgModule({
  declarations: [
    AppComponent,
    CreateTodoComponent,
    ShowTodoComponent,
    EditTodoComponent,
    UserComponent,
    ShowUsertodoComponent,
    UserRegisterComponent,
    ProfileComponent,
    SearchHighlightPipe,
    HighlightDirective,
    TdhighlightDirective,
    AdDirective,
    AdBannerComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  
  providers:[authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
