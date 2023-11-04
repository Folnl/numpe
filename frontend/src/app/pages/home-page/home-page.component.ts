import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import IFuelingOrder from 'src/app/models/IFuelingOrder';
import { DeleteFuelingOrderDialogComponent } from 'src/app/pages/home-page/dialogs/delete-fueling-order-dialog/delete-fueling-order-dialog.component';

function fueling(plate: string): IFuelingOrder {
	return {
		id: 1,
		vehiclePlate: plate,
		vehicleMileage: 200000,
		price: 43.9,
		timestamp: new Date(),
	};
}
@Component({
	selector: 'app-home-page',
	templateUrl: './home-page.component.html',
	styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent {
	fuelingOrders: IFuelingOrder[] = [
		fueling('ABC-1234'),
		fueling('ABC-1234'),
		fueling('ABC-1234'),
		fueling('CBA-4321'),
		fueling('CBA-4321'),
		fueling('CBA-4321'),
		fueling('CBA-4321'),
	];

	constructor(public dialog: MatDialog) {}

	openDeleteFuelingOrderDialog(fuelingOrderToDelete: IFuelingOrder) {
		this.dialog.open(DeleteFuelingOrderDialogComponent, {
			data: fuelingOrderToDelete,
		});
	}

	vehiclePlatesMap = () => {
		return this.fuelingOrders.reduce(
			(accumulator, current) => {
				if (!accumulator[current.vehiclePlate]) {
					accumulator = {
						...accumulator,
						[current.vehiclePlate]: [current],
					};
				} else {
					accumulator[current.vehiclePlate].push(current);
				}

				return accumulator;
			},
			{} as {
				[key: string]: IFuelingOrder[];
			}
		);
	};

	vehiclePlates = () => {
		return Object.values(this.vehiclePlatesMap());
	};
}
