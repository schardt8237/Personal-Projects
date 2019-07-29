function isMultipleOf(number,number2) {
	return new Promise((success,failure) => {
		if(number % number2 == 0) {
			setTimeout(() => {
				success(`${number} is a multiple of ${number2}.`);
			}, 250);
		}
		else {
			setTimeout(() => {
				failure(`${number} is not a multiple of ${number2}.`);
			}, 250);
		}
	});
}

function isMultiple(message) {
	console.log(message);
}

function isNotMultiple(message) {
	console.log(message);
}

for(let i = 1; i <= 30; i++) {
	isMultipleOf(100,i).then(isMultiple).catch(isNotMultiple);
}