import { BreakpointObserver } from '@angular/cdk/layout';
import { Component } from '@angular/core';
import {
	FormBuilder,
	FormControl,
	FormGroup,
	Validators,
} from '@angular/forms';

@Component({
	selector: 'app-register-page',
	templateUrl: './register-page.component.html',
	styleUrls: ['./register-page.component.scss'],
})
export class RegisterPageComponent {
	form: FormGroup;

	patterns = {
		['U']: {
			pattern: new RegExp('[A-Z0-9]'),
		},
	};

	constructor(
		private formBuilder: FormBuilder,
		private breakpointObserver: BreakpointObserver
	) {
		this.form = this.formBuilder.group({
			vehiclePlate: ['', Validators.required],
			vehicleMileage: ['', Validators.required],
			price: ['', Validators.required],
			timestamp: ['', Validators.required],
		});
	}

	get isMobile() {
		return this.breakpointObserver.isMatched('(max-width: 767px)');
	}

	onSubmit() {
		console.log(this.form.value);
	}
}
