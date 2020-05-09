import { TestBed } from '@angular/core/testing';

import { MenuItemServiceService } from './menu-item-service.service';

describe('MenuItemServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuItemServiceService = TestBed.get(MenuItemServiceService);
    expect(service).toBeTruthy();
  });
});
