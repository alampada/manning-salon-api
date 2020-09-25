import dayjs from 'dayjs';
import customParseFormat from 'dayjs/plugin/customParseFormat'

dayjs.extend(customParseFormat);

export function validateDateFormat(dateStr, format = 'yyyy-MM-dd') {
    return dayjs(dateStr, format).isValid();
}

export function showHours(dateStr) {
    return dayjs(dateStr).format('hh:mm A');
}

export function getDayDifference(date) {
    var today = new Date();
    today.setHours(0,0,0,0);
    return dayjs(date).diff(dayjs(today), 'day');
}