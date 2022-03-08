import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;

  constructor(private _token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this._token.getUser();
  }

  @Input() titleName = "";
  @Output() newItemEvent = new EventEmitter<string>();

  @Input() size: any;
  @Output() sizeChange = new EventEmitter<number>();

  addNewItem(value: string) {
    this.newItemEvent.emit(value);
  }

  dec(){
    this.resize(-1);
  }

  inc(){
    this.resize(+1);
  }

  resize(delta: number) {
    this.size = this.size + delta;
    this.sizeChange.emit(this.size)
  }

}