import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map } from 'rxjs';
import IFuelingOrder from 'src/app/models/IFuelingOrder';

interface IResponse<T> {
	status: number;
	success: boolean;
	data: T;
}

@Injectable({
	providedIn: 'root',
})
export class FuelingOrderService {
	constructor(private http: HttpClient) {}

	list(): Observable<IFuelingOrder[]> {
		return this.http
			.get<IResponse<IFuelingOrder[]>>(
				'http://localhost:8080/fueling_orders'
			)
			.pipe(
				map((response) => {
					if (response.success) return response.data;
					else return response.data;
				}),
				catchError(({ error }) => {
					throw error.message;
				})
			);
	}

	deleteById(id: number) {
		return this.http
			.delete<IResponse<null>>(
				`http://localhost:8080/fueling_orders/${id}`
			)
			.pipe(
				map((response) => {
					if (response.success) return response.data;
					else return response.data;
				}),
				catchError(({ error }) => {
					throw error.message;
				})
			);
	}
}
