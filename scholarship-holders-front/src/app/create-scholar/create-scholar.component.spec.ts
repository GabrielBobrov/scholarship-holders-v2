import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateScholarComponent } from './create-scholar.component';

describe('CreateScholarComponent', () => {
  let component: CreateScholarComponent;
  let fixture: ComponentFixture<CreateScholarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateScholarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateScholarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
