import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { IFuelingOrder } from 'src/app/models/IFuelingOrder';
import { DeleteFuelingOrderDialogComponent } from 'src/app/pages/home-page/dialogs/delete-fueling-order-dialog/delete-fueling-order-dialog.component';
import { FuelingOrderService } from 'src/app/services/fueling-order.service';

@Component({
	selector: 'app-home-page',
	templateUrl: './home-page.component.html',
	styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
	fuelingOrders: IFuelingOrder[] = [];

	loadingDialog: Boolean = false;
	isDialogOpen: Boolean = false;

	constructor(
		private service: FuelingOrderService,
		private dialog: MatDialog
	) { }

	ngOnInit(): void {
		this.listFuelingOrders();
	}

	listFuelingOrders() {
		this.service.list().subscribe({
			next: (fuelingOrders) => {
				this.fuelingOrders = fuelingOrders;
			},
			error: console.log,
		});
	}

	openDeleteFuelingOrderDialog(fuelingOrderToDelete: IFuelingOrder) {
		this.dialog.open(DeleteFuelingOrderDialogComponent, {
			data: {
				fuelingOrder: fuelingOrderToDelete,
				onConfirm: () => {
					this.listFuelingOrders();
				},
			},
			disableClose: true,
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
