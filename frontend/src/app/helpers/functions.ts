export function zeroPadding(maxDigits: number, number: number) {
	return number.toString().padStart(maxDigits, '0');
}

export function getTimeFromDate(date: Date) {
	return `${zeroPadding(2, date.getHours())}:${zeroPadding(
		2,
		date.getMinutes()
	)}`;
}

export function offsetDate(date: Date) {
	const offset = date.getTimezoneOffset();
	return new Date(date.getTime() - offset * 60 * 1000);
}

export function dateToISOString(date: Date) {
	return offsetDate(date).toISOString();
}

export function getDateFromDateAndTime(date: Date, time: string) {
	const newDate = new Date(date);
	const splitTime = time.split(':');
	newDate.setHours(parseInt(splitTime[0]), parseInt(splitTime[1]), 0, 0);

	return newDate;
}
