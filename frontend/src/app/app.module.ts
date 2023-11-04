import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import '@angular/common/locales/global/pt';
import { DeleteFuelingOrderDialogComponent } from './pages/home-page/dialogs/delete-fueling-order-dialog/delete-fueling-order-dialog.component';

@NgModule({
	declarations: [AppComponent, HomePageComponent, RegisterPageComponent, DeleteFuelingOrderDialogComponent],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		FormsModule,
		ReactiveFormsModule,
		MatFormFieldModule,
		MatInputModule,
		MatSelectModule,
		MatDatepickerModule,
		MatNativeDateModule,
		MatButtonModule,
		MatListModule,
		MatDividerModule,
		MatIconModule,
		MatCardModule,
		MatDialogModule,
		FlexLayoutModule,
	],
	providers: [
		{ provide: LOCALE_ID, useValue: 'pt-BR' },
		{ provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' },
	],
	bootstrap: [AppComponent],
})
export class AppModule {}
