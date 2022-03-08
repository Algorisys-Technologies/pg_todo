import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private _http: HttpClient) { }

  getTodo(){
    let URL="/api/todo";
    return this._http.get(URL)
  }

  postTodo(todoData) {
    let url = '/api/todo/add';
    return this._http.post<any>(url, todoData)
  }

 

  putTodo(todoData){
    let url = '/api/todo';
   return this._http.put<any>(url,todoData)
  }


  getTodoById(id : String){
    let url="/api/todo/"+id;
    return this._http.get(url)
  }

  getTodoByApiId(userid : String){
    let url="/api/todo/id/"+userid;
    return this._http.get(url)
  }

  getTodoByEmail(email:String){
    let url="/api/todo/email/"+email;
    return this._http.get(url);
  }

  deleteTodo(id){
    let url="/api/todo/cancel/"+id;
    return this._http.delete(url)
  }

}
