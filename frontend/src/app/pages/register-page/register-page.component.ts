import { BreakpointObserver } from '@angular/cdk/layout';
import { Component } from '@angular/core';
import {
	FormBuilder,
	FormControl,
	FormGroup,
	Validators,
} from '@angular/forms';
import {
	getDateFromDateAndTime,
	getTimeFromDate
} from 'src/app/helpers/functions';
import { FuelingOrderService } from 'src/app/services/fueling-order.service';

interface IFuelingOrderForm {
	vehiclePlate: FormControl<string>;
	vehicleMileage: FormControl<number | null>;
	price: FormControl<number>;
	date: FormControl<Date>;
	time: FormControl<string>;
}

@Component({
	selector: 'app-register-page',
	templateUrl: './register-page.component.html',
	styleUrls: ['./register-page.component.scss'],
})
export class RegisterPageComponent {
	form: FormGroup<IFuelingOrderForm>;
	maxDateForTimestamp = new Date();
	loading = false;
	isFormVisible = true;

	patterns = {
		['U']: {
			pattern: new RegExp('[A-Z0-9]'),
		},
	};

	constructor(
		private service: FuelingOrderService,
		private formBuilder: FormBuilder,
		private breakpointObserver: BreakpointObserver
	) {
		this.form = this.newForm();
	}

	get isMobile() {
		return this.breakpointObserver.isMatched('(max-width: 767px)');
	}

	newForm() {
		return this.formBuilder.group<IFuelingOrderForm>({
			vehiclePlate: new FormControl('', {
				nonNullable: true,
				validators: [Validators.required],
			}),
			vehicleMileage: new FormControl(null, {
				validators: [Validators.required],
			}),
			price: new FormControl(0, {
				nonNullable: true,
				validators: [Validators.required],
			}),
			date: new FormControl(this.maxDateForTimestamp, {
				nonNullable: true,
				validators: [Validators.required],
			}),
			time: new FormControl(getTimeFromDate(this.maxDateForTimestamp), {
				nonNullable: true,
				validators: [Validators.required, Validators.minLength(5)],
			}),
		});
	}

	getTimestampFromForm(form: FormGroup<IFuelingOrderForm>) {
		const date = form.get('date')?.getRawValue() as Date;
		const time = form.get('time')?.getRawValue() as string;

		if (date && time) return getDateFromDateAndTime(date, time);
		return null;
	}

	resetForm() {
		this.isFormVisible = false;
		this.form = this.newForm();
		setTimeout(() => this.isFormVisible = true);
	}

	onSubmit() {
		if (!this.form.valid) return;

		this.loading = true;
		this.form.disable();

		this.service.create({
			vehicleMileage: this.form.value.vehicleMileage!,
			vehiclePlate: this.form.value.vehiclePlate!,
			price: this.form.value.price!,
			timestamp: this.getTimestampFromForm(this.form)!
		}).subscribe({
			next: fuelingOrder => {
				console.log(fuelingOrder.id)
				this.loading = false;
				this.resetForm();
			},
			error: console.log
		});
	}
}
