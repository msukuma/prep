'use strict';

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

function stringToInt(str) {
	if (!(typeof word === 'undefined' ? 'undefined' : _typeof(word)) === 'string') {
		throw new Error('input is not a string');
	}
	var isNegative = str[0] === '-';

	var num = 0;
	var i = isNegative ? 1 : 0;

	for (i; i < str.length; i++) {
		if (typeof (str[i] * 1) !== 'number') {
			throw new Error('Invalid input');
		}
		console.log(num);
		console.log(num * 10, str[i] * 1);

		num = num * 10 + str[i] * 1;
	}
	console.log('result', isNegative ? num * -1 : num);
	return isNegative ? num * -1 : num;
}

// console.log('=====');
stringToInt('492');
stringToInt('-747');