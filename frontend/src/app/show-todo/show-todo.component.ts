import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoService } from '../services/todo.service';


@Component({
  selector: 'app-show-todo',
  templateUrl: './show-todo.component.html',
  styleUrls: ['./show-todo.component.css']
})
export class ShowTodoComponent implements OnInit {

  todoList: any[] = [];

  constructor(private _todoservice: TodoService,
    private router: Router) { }

  ngOnInit(): void {
    this.showTodo();
  }

  showTodo() {
    this._todoservice.getTodo().subscribe((data: any[]) => {
      this.todoList = data;
    }, error => {
      console.error(error);
    })
  }

  async removeTodo(id) {
    let con = confirm("Do you want to delete Todo ?");
    if (con) {
      await this._todoservice.deleteTodo(id).toPromise();
      this.showTodo();
    }
  }

   updateTodo(id) {
    this.router.navigate(['edit',id]);
   }

}
