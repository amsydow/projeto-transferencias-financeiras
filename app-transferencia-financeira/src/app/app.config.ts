import { InjectionToken } from '@angular/core';

export interface AppConfig {
  apiBaseUrl: string;
  timeoutMs: number;
}

export const APP_CONFIG = new InjectionToken<AppConfig>('app.config');

export const APP_CONFIG_VALUE: AppConfig = {
  apiBaseUrl: 'http://localhost:8080/api',
  timeoutMs: 5000
};