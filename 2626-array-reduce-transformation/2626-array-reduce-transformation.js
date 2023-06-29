/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    return nums.reduce((previousValue, currentValue) => {
        let nextValue = fn(previousValue, currentValue);
        return nextValue; // Accumulate the values
    }, init);
};
