//
//
// const Node = require('../linked-list/linked-list-node');
//
// function Queue() {
//   this.first = null;
//   this.last = null;
// }
//
// Queue.prototype.enqueue = function (item) {
//   var oldLast,
//       node = new Node({value: item});
//
//   if (this.first === null) {
//     this.first = node;
//     this.last = node;
//   }
//   else {
//     oldLast = this.last;
//     this.last = node;
//     oldLast.next = node;
//   }
// };
//
// Queue.prototype.enqueueAll = function () {
//   for (var i = 0; i < arguments.length; i++) {
//     this.enqueue(arguments[i]);
//   }
// };
//
// Queue.prototype.dequeue = function () {
//   var node = this.first;
//
//   if (node) {
//     this.first = this.first.next;
//   }
//
//   return node;
// };
//
// Queue.prototype.toString = function () {
//   var curr = this.first,
//       s = '[';
//
//   while (curr !== null) {
//     if (curr.next) {
//       s += curr.value + ',';
//     }
//     else {
//       s += curr.value;
//     }
//     curr = curr.next;
//   }
//   s += ']'
//   console.log(s);
//   return s;
// };
//
// var q =  new Queue();
//
// if (require.main === module) {
//   q.enqueueAll(1,2,4);
//   q.dequeue();
//   q.toString()
// }
"use strict";