let homework = {};
/*
 1. Return the nth Fibonacci number
`x`
 f(0) = 0
 f(1) = 1
 f(10) = 55 
*/
function fibonacci(n){
    if(n == 1){
        return 1;
    }
    else if (n == 0){
        return 0;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
}
homework.fibonacci = function(n){

};
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
function sort(array){
    for (i = 0; i < array.length-1; i++) {
		for (j = 0; j < array.length-i-1; j++) {
			if (array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
}
}
homework.sort = function(array) {

};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
function factorial(n){
    if(n <= 1){
        return 1;
    }
    return n * factorial(n -1);
}

homework.factorial = function(n){

};
/*

 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
function rotateLeft(array, n){
    while (times --){
        let temp = array.shift();
        array.push(temp)
    }
}
homework.rotateLeft = function(array, n) {

};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
function balancedBrackets(bracketsString){
    let stack = [];
    let map = {
        '(':')',
        '[':']',
        '{':'}'
    }
    for (let i = 0; i < bracketsString.length; i++){
        if(bracketsString[i] == '(' || bracketsString[i] == '{' || bracketsString[i] == '['){
            stack.push(bracketsString[i]);
        }
        else{
            let last = stack.pop();
        }
        if(bracketsString[i] !== map[last]){
            return false;
        }
    }
    return true;
}

homework.balancedBrackets = function(bracketsString){

};
