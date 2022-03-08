import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowUsertodoComponent } from './show-usertodo.component';

describe('ShowUsertodoComponent', () => {
  let component: ShowUsertodoComponent;
  let fixture: ComponentFixture<ShowUsertodoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowUsertodoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowUsertodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
