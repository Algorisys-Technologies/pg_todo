import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { TodoService } from '../services/todo.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  // encapsulation:ViewEncapsulation.None
})
export class UserComponent implements OnInit {

  createUser: FormGroup;
  message: String;

  constructor(private _fb: FormBuilder,
    private _router: Router,
    private _authService: AuthService,
    private _tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    this.UserForm();
  }


  UserForm() {
    this.createUser = this._fb.group({
      email: ['', [Validators.required, Validators.pattern("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$")]],
      password: ['', [Validators.required]],
    })
  }

  get email() {
    return this.createUser.get("email");
  }

  get password() {
    return this.createUser.get("password");
  }

  onSubmit() {
    let formValue = this.createUser.getRawValue();
    console.log(formValue);
    this._authService.login(formValue).subscribe(data => {
      console.log(data);
      this._tokenStorage.saveToken(data.accessToken);
      this._tokenStorage.saveUser(data);
      this._router.navigate(['showTodo']);
    }, () => {
      this.message = "Please write correct Email and Password!";
    })
  }

}
