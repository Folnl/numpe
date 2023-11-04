import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import IFuelingOrder from 'src/app/models/IFuelingOrder';

@Component({
	selector: 'app-register-page',
	templateUrl: './register-page.component.html',
	styleUrls: ['./register-page.component.scss'],
})
export class RegisterPageComponent {
	form: FormGroup;

	constructor(private formBuilder: FormBuilder) {
		this.form = this.formBuilder.group<{}>({
			vehiclePlate: ['', Validators.required],
			vehicleMileage: [0, Validators.required],
			price: [0, Validators.required],
			timestamp: ['', Validators.required],
		});
	}

	onSubmit() {
		console.log(this.form.value);
	}
}
