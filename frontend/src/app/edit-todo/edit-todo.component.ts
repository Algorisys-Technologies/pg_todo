import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoService } from '../services/todo.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-edit-todo',
  templateUrl: './edit-todo.component.html',
  styleUrls: ['./edit-todo.component.css']
})
export class EditTodoComponent implements OnInit {

  edittodoForm: FormGroup;
  id: any;
  message: string;
  routerid: string;

  constructor(private _fb: FormBuilder,
    private _todoservice: TodoService,
    private _router: Router,
    private _route: ActivatedRoute,
    private token: TokenStorageService) {
    let USER_KEY = this.token.getUser();
    this.routerid = USER_KEY.id
  }

  ngOnInit(): void {

    this.editForm();
    this.id = this._route.snapshot.params['id'];
    this._todoservice.getTodoById(this.id)
      .subscribe(data => this.edittodoForm.patchValue(data));
  }


  editForm(): void {
    this.edittodoForm = this._fb.group({
      todo: ['', [Validators.required]]
    })
  }

  get todo() {
    return this.edittodoForm.get("todo");
  }

  onSubmit() {
    let formValue = this.edittodoForm.getRawValue();
    formValue.id = this.id;
    formValue.userid = this.routerid;
    this._todoservice.putTodo(formValue).subscribe(data => {
      this._router.navigate(['/showTodo']);
    })
    this.message = "One todo Updated successfully!";
  }

}
