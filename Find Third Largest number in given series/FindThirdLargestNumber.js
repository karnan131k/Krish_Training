
function thirdLargest(arr, arr_size)
{
    if (arr_size < 3)
    {
        console.log(" Invalid Input ");
        return;
    }
    var first = arr[0], second = -1000000000, third = -1000000000;
    for (var i = 1; i < arr_size ; i ++)
    {
        if (arr[i] > first)
        {
            third = second;
            second = first;
            first = arr[i];
        }
        else if (arr[i] > second)
        {
            third = second;
            second = arr[i];
        }
        else if (arr[i] > third)
            third = arr[i];
    }
    console.log("The third Largest element is "+ third);
}
const prompt = require('prompt-sync')();
const numberString = prompt('Enter your numbers using comma seperator ? ');
var numberArray = numberString.split(',').map(function(item) {
    return parseInt(item, 10);
});
console.log(numberArray);
let numbers = [];
numbers=numberArray;
var n = numberArray.length;
thirdLargest(numbers, n);