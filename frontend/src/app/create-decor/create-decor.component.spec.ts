import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDecorComponent } from './create-decor.component';

describe('CreateDecorComponent', () => {
  let component: CreateDecorComponent;
  let fixture: ComponentFixture<CreateDecorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDecorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDecorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
