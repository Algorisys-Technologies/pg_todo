import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators, ValidatorFn } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { TodoService } from '../services/todo.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css'],
  // encapsulation:ViewEncapsulation.ShadowDom
})
export class UserRegisterComponent implements OnInit {

  userRegister: FormGroup;
  genderList: any = [];
  message: String;
  warning: String;
  isSuccessful = false;
  isSignUpFailed = false;
  hobbyList = [
    { id: 1, name: 'Spring Boot' },
    { id: 2, name: 'Nodejs' },
    { id: 3, name: 'Angular' },
    { id: 4, name: 'React' }
  ];

  constructor(private _fb: FormBuilder,
    private _todoservice: TodoService,
    private _router: Router,
    private _authservice: AuthService) {
    this.genderList = ["male", "female"]
  }

  ngOnInit(): void {
    this.UserRegisterForm();
    this.addCheckboxesToForm();
  }

  UserRegisterForm() {
    this.userRegister = this._fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.pattern("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$")]],
      password: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
      gender: ['male', [Validators.required]],
      hobbies: new FormArray([]),
      collegeName: ['', [Validators.required]]
    })
  }

  addCheckboxesToForm() {
    this.hobbyList.forEach(() => this.hobbiesFormArray.push(new FormControl()));
  }

  get hobbiesFormArray() {
    return this.userRegister.get("hobbies") as FormArray;
  }

  get name() {
    return this.userRegister.get("name");
  }

  get email() {
    return this.userRegister.get("email");
  }

  get password() {
    return this.userRegister.get("password");
  }

  get confirmPassword() {
    return this.userRegister.get("confirmPassword");
  }

  get gender() {
    return this.userRegister.get("gender");
  }

  get collegeName() {
    return this.userRegister.get("collegeName");
  }

  onSubmit() {
    let formValue = this.userRegister.getRawValue();
    const selectedHobbyName = this.userRegister.value.hobbies
      .map((checked, i) => checked ? this.hobbyList[i].name : null).filter(value => value !== null);
    formValue.hobbies = selectedHobbyName;
    console.log(formValue);
    if (formValue.password === formValue.confirmPassword) {
      this._authservice.register(formValue).subscribe(data => {
        console.log("this is register data", data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this._router.navigate(['user-login']);
      })
    } else {
      this.isSignUpFailed = true;
      this.message = "Please write Password and Confirm password same!";
    }
  }
}
