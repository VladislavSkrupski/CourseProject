import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTextureComponent } from './create-texture.component';

describe('CreateTextureComponent', () => {
  let component: CreateTextureComponent;
  let fixture: ComponentFixture<CreateTextureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTextureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTextureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
