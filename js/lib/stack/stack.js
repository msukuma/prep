// const LinkedList = require('../linked-list/linked-list');
//
// function Stack(maxSize){
//   this.list = new LinkedList();
//   this.maxSize = maxSize || 20;
// }
//
// Stack.prototype.push = function (value) {
//   if (this.size() >= this.maxSize) {
//     throw new Error('This Stack is full')
//   }
//
//   this.list.addFirst(value);
// };
//
// Stack.prototype.pushAll = function (args) {
//     for (var i = 0; i < arguments.length; i++) {
//       this.push(arguments[i]);
//     }
// };
//
// Stack.prototype.pop = function () {
//   return this.list.removeFirst();
// };
//
// Stack.prototype.peek = function () {
//   return this.list.getFirst();
// };
//
// Stack.prototype.size = function () {
//   var l = this.list;
//   return this.list.length();
// };
//
// Stack.prototype.toString = function () {
//   var s = '-';
//   var i = this.list.iterator()
//   var curr = i.next();
//
//   while(!curr.done){
//       s+= '\n'+ curr.value;
//       curr = i.next();
//   }
//   s += '\n-'
//
//   console.log(s);
//   return s;
// };
//
// if (require.main === module) {
//   var s = new Stack(5);
//   s.pushAll(1,2,3,4,5);
//   s.toString()
//   console.log(s.peek());
//   console.log(s.pop());
//   s.toString();
// }
"use strict";