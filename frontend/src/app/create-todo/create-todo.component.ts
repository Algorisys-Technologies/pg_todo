import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TodoService } from '../services/todo.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-create-todo',
  templateUrl: './create-todo.component.html',
  styleUrls: ['./create-todo.component.css']
})
export class CreateTodoComponent implements OnInit {

  createtodoForm: FormGroup
  message: String;
  routerid: string;

  constructor(private _fb: FormBuilder,
    private _todoservice: TodoService,
    private _router: Router,
    private token: TokenStorageService) {
    let USER_KEY = this.token.getUser();
    this.routerid = USER_KEY.id
  }


  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.createtodoForm = this._fb.group({
      todo: ['', [Validators.required]],
    })
  }

  get todo() {
    return this.createtodoForm.get("todo");
  }

  onSubmit() {
    let formValue = this.createtodoForm.getRawValue();
    formValue.userid = this.routerid;
    this._todoservice.postTodo(formValue).subscribe(data => {
      this._router.navigate(['showTodo']);
    });
    this.message = "One todo Created successfully!";
  }

}


