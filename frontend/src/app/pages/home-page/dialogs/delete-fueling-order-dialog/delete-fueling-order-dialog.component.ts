import { Component, Inject, Input } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { delay } from 'rxjs';
import IFuelingOrder from 'src/app/models/IFuelingOrder';
import { FuelingOrderService } from 'src/app/services/fueling-order.service';

@Component({
	selector: 'delete-fueling-order-dialog',
	templateUrl: './delete-fueling-order-dialog.component.html',
	styleUrls: ['./delete-fueling-order-dialog.component.scss'],
})
export class DeleteFuelingOrderDialogComponent {
	loading = false;

	constructor(
		public dialogRef: MatDialogRef<DeleteFuelingOrderDialogComponent>,
		@Inject(MAT_DIALOG_DATA)
		public data: {
			fuelingOrder: IFuelingOrder;
			onConfirm?: () => {};
		},
		private service: FuelingOrderService
	) {}

	deleteFuelingOrderById(id: number) {
		if (!id) return console.log('ID obrigatório');

		this.loading = true;
		console.log('DELETE');
		this.service
			.deleteById(id)
			.pipe(delay(2000))
			.subscribe({
				next: () => {
					if (this.data.onConfirm) this.data.onConfirm();

					this.loading = false;
					this.dialogRef.close();
				},
				error: console.log,
			});
	}
}
