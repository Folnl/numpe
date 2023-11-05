import { dateToISOString } from 'src/app/helpers/functions';

export interface IFuelingOrder {
	id?: number;
	vehicleMileage: number;
	vehiclePlate: string;
	price: number;
	timestamp: Date;
}

export const FuelingOrderMapper = {
	toSave(model: IFuelingOrder): IFuelingOrder {
		return {
			vehicleMileage: model.vehicleMileage,
			vehiclePlate: model.vehiclePlate,
			price: model.price,
			timestamp: new Date(dateToISOString(model.timestamp))
		};
	}
} 
