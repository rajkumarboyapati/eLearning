import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VediocomponentComponent } from './vediocomponent.component';

describe('VediocomponentComponent', () => {
  let component: VediocomponentComponent;
  let fixture: ComponentFixture<VediocomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VediocomponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VediocomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
