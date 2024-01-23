import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateScholarComponent } from './update-scholar.component';

describe('UpdateScholarComponent', () => {
  let component: UpdateScholarComponent;
  let fixture: ComponentFixture<UpdateScholarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateScholarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateScholarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
