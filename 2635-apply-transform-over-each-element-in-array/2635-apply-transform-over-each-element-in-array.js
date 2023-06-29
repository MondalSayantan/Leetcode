/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArray = [];
    arr.forEach((number, index) => {
        newArray.push(fn(number, index));
    })
    return newArray;
};