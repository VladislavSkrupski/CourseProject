import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateThicknessComponent } from './create-thickness.component';

describe('CreateThicknessComponent', () => {
  let component: CreateThicknessComponent;
  let fixture: ComponentFixture<CreateThicknessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateThicknessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateThicknessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
