import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoService } from '../services/todo.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-show-usertodo',
  templateUrl: './show-usertodo.component.html',
  styleUrls: ['./show-usertodo.component.css'],
  // encapsulation:ViewEncapsulation.Emulated
})
export class ShowUsertodoComponent implements OnInit {

  userTodoList: any[] = [];
  userid: any;
  todoFind: any[] = [];
  word: string;
  notSearch: boolean;
  title = 'todo';
  row: any;
  pageSize: number = 3;
  pageCount: number;
  pageCountArray: any;
  paginationList: any[];

  tableHeader = [{
    key: 'todo',
    value: 'TODO'
  }, {
    key: 'id',
    value: 'ID'
  }, {
    key: 'userid',
    value: 'User Id'
  }];

  constructor(private _todoservice: TodoService,
    private router: Router,
    private _route: ActivatedRoute,
    private _tokenStorageService: TokenStorageService,
    private token: TokenStorageService) {
    let USER_KEY = this.token.getUser();
    this.userid = USER_KEY.id;
  }

  ngOnInit(): void {
    this.showUserTodo();
  }

  showUserTodo() {
    this._todoservice.getTodoByApiId(this.userid).subscribe((data: any[]) => {
      this.userTodoList = data;
      this.pageCount = Math.ceil(this.userTodoList.length / this.pageSize);
      this.paginationList = this.userTodoList.slice(0, this.pageSize)
      this.pageCountArray = new Array(this.pageCount);
      this.notSearch = true;
    }, error => {
      console.error(error);
    })
  }

  pagination(i) {
    this.paginationList = this.userTodoList.slice(i * this.pageSize, ((i * this.pageSize) + this.pageSize))
    let span = document.querySelectorAll('span');
    span.forEach((e, index) => {
      if (index == i) {
        span[i].style.backgroundColor = "yellow";
      } else {
        e.style.backgroundColor = "white"
      }
      return e;
    });
  }

  async removeTodo(id) {
    let confirmMassage = confirm("Do you want to delete Todo ?");
    if (confirmMassage) {
      await this._todoservice.deleteTodo(id).toPromise();
      this.showUserTodo();
    }
  }

  updateTodo(id) {
    this.router.navigate(['edit', id]);
  }

  logout() {
    this._tokenStorageService.signOut();
    this.router.navigate(['user-login']);
    // window.location.reload();
  }

  search(event: any) {
    this.word = event.target.value.toLowerCase();
    this.todoFind = this.userTodoList.filter(value => { return value.todo.toLowerCase().includes(this.word) });
    this.notSearch = false;

    if (!this.word) {
      this.notSearch = true;
    }
  }

  start(event: any) {
    this.row = event.target;
  }

  dragover(event: any) {
    event.preventDefault();
    let children = Array.from(event.target.parentNode.parentNode.children);
    if (children.indexOf(event.target.parentNode) > children.indexOf(this.row)) {
      event.target.parentNode.after(this.row);
    }
    else {
      event.target.parentNode.before(this.row);
    }
  }
}

