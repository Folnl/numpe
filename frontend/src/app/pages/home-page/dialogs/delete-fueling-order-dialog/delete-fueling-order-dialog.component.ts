import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import IFuelingOrder from 'src/app/models/IFuelingOrder';

@Component({
	selector: 'delete-fueling-order-dialog',
	templateUrl: './delete-fueling-order-dialog.component.html',
	styleUrls: ['./delete-fueling-order-dialog.component.scss'],
})
export class DeleteFuelingOrderDialogComponent {
	constructor(@Inject(MAT_DIALOG_DATA) public fuelingOrder: IFuelingOrder) {}
}
