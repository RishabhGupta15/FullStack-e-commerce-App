import { TestBed } from '@angular/core/testing';

import { LoginSessionService } from './login-session.service';

describe('LoginSessionService', () => {
  let service: LoginSessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginSessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
