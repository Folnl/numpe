import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';

import { LayoutModule } from '@angular/cdk/layout';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatSelectModule } from '@angular/material/select';
import {
	MAT_SNACK_BAR_DEFAULT_OPTIONS,
	MatSnackBarConfig,
	MatSnackBarModule
} from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import '@angular/common/locales/global/pt';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
	CURRENCY_MASK_CONFIG,
	CurrencyMaskConfig,
	CurrencyMaskModule,
} from 'ng2-currency-mask';
import { NgxMaskDirective, provideEnvironmentNgxMask } from 'ngx-mask';
import { DeleteFuelingOrderDialogComponent } from './pages/home-page/dialogs/delete-fueling-order-dialog/delete-fueling-order-dialog.component';

export const customCurrencyMaskConfig: CurrencyMaskConfig = {
	align: 'left',
	allowNegative: false,
	decimal: ',',
	precision: 2,
	prefix: 'R$ ',
	suffix: '',
	thousands: '.',
};

@NgModule({
	declarations: [
		AppComponent,
		HomePageComponent,
		RegisterPageComponent,
		DeleteFuelingOrderDialogComponent,
	],
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
		MatProgressBarModule,
		MatToolbarModule,
		MatSnackBarModule,
		FlexLayoutModule,
		HttpClientModule,
		NgxMaskDirective,
		CurrencyMaskModule,
		LayoutModule,
	],
	providers: [
		{ provide: LOCALE_ID, useValue: 'pt-BR' },
		{ provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' },
		{ provide: CURRENCY_MASK_CONFIG, useValue: customCurrencyMaskConfig },
		{
			provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: {
				duration: 2500,
				horizontalPosition: 'right',
				verticalPosition: 'top'
			} as MatSnackBarConfig
		},
		provideEnvironmentNgxMask(),
	],
	bootstrap: [AppComponent],
})
export class AppModule { }
