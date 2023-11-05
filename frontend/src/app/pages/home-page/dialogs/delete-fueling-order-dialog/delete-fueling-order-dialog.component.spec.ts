import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteFuelingOrderDialogComponent } from './delete-fueling-order-dialog.component';

describe('DeleteFuelingOrderDialogComponent', () => {
  let component: DeleteFuelingOrderDialogComponent;
  let fixture: ComponentFixture<DeleteFuelingOrderDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeleteFuelingOrderDialogComponent]
    });
    fixture = TestBed.createComponent(DeleteFuelingOrderDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
