import { bootstrapApplication } from '@angular/platform-browser';
import { APP_CONFIG, APP_CONFIG_VALUE } from './app/app.config';
import { provideRouter, Routes, withEnabledBlockingInitialNavigation } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app/app.component';
import { HomeComponent } from './app/components/home/home.component';
import { TransferenciaFormComponent } from './app/components/transferencia-form/transferencia-form.component';
import { TransferenciaListarComponent } from './app/components/transferencia-listar/transferencia-listar.component';
import { provideHttpClient } from '@angular/common/http';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'agendamento', component: TransferenciaFormComponent },
    { path: 'consulta', component: TransferenciaListarComponent },
    { path: '**', redirectTo: '' }
];

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(ReactiveFormsModule),
    provideHttpClient(),
    provideRouter(routes, withEnabledBlockingInitialNavigation()),
    { provide: APP_CONFIG, useValue: APP_CONFIG_VALUE },
  ]
})
.catch(err => console.error(err));