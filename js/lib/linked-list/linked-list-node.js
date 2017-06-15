// const Node = require('../node/node');
// module.exports = LinkedListNode;
//
// function LinkedListNode(args) {
//   if (!args.hasOwnProperty('value')) {
//     throw new Error('value cannot be null or undefined')
//   }
//   this.node = new Node(args.value);
//   this.node.next = this.next = args.next;
//   this.value = args.value;
//   this.next = args.next || null;
//   this.previous = args.previous || null;
// }
//
// LinkedListNode.prototype.hasNext = function () {
//   return !(this.next === null)
// }
//
// LinkedListNode.prototype.hasPrevious = function () {
//   return !(this.previous === null)
// }
//
// LinkedListNode.prototype.equals = function (node) {
//   return node.value === this.value;
// }
"use strict";