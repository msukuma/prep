// const LinkedListNode = require('./linked-list-node');
//
// module.exports = LinkedList;
//
// function LinkedList(){
//   this.first = null;
//   this.last = null;
//   this.size = 0;
// }
//
// LinkedList.prototype.getFirst = function () {
//   if (!this.size) {
//     return null;
//   }
//   return this.first.value;
// }
//
// LinkedList.prototype.getLast = function () {
//   if (!this.size) {
//     return null;
//   }
//   return this.last.value;
// }
//
// LinkedList.prototype.length = function () {
//   return this.size;
// };
//
// LinkedList.prototype.add = function (value) {
//   var newNode = new LinkedListNode({value: value});
//
//   if (this.first === null) {
//     this.first = newNode;
//     this.last = newNode;
//   }
//   else {
//     var oldLast = this.last;
//     oldLast.next = newNode;
//     this.last = newNode;
//     newNode.previous = oldLast;
//   }
//
//   this.size++;
// };
//
// LinkedList.prototype.addAll = function () {
//   for(var i = 0; i < arguments.length; i++){
//     this.add(arguments[i]);
//   }
// };
//
// LinkedList.prototype.addFirst = function (value) {
//   var newNode = new LinkedListNode({value: value});
//
//   if (this.first === null) {
//     this.first = newNode;
//     this.last = newNode;
//   }
//   else {
//     var oldFirst = this.first;
//     this.first = newNode;
//     newNode.next = oldFirst;
//   }
//
//   this.size++;
// };
//
// LinkedList.prototype.addLast = function (value) {
//   var newNode = new LinkedListNode({value: value});
//   var oldLast = this.last;
//
//   this.last = newNode;
//   oldLast.next = newNode;
//   newNode.previous = oldLast;
// };
//
// LinkedList.prototype.remove = function (index) {
//   var node = this.first;
//
//   if (index >= this.size) {
//     throw new Error('IndexOutOfRangeError');
//   }
//
//   for (var i = 0; i < index; i++) {
//     if (node.hasNext()) {
//       node = node.next;
//     }
//   }
//
//   if (node){
//     if(node !== this.first) {
//
//       if (node.hasNext()) {
//         node.previous.next = node.next;
//       }
//       else {
//         node.previous.next = null;
//         this.last = node.previous;
//       }
//
//     }
//     else {
//       if (this.size === 1) {
//         this.first = null;
//       }
//       else {
//         this.first = node.next
//       }
//
//     }
//
//     this.size--;
//   }
//
//   return node.value;
// };
//
// LinkedList.prototype.removeFirst = function () {
//   var first = this.first;
//
//   if (first.hasNext()) {
//       this.first = first.next;
//   }
//   else {
//     this.first = null;
//   }
//
//   this.size--;
//   return first.value;
// };
//
// LinkedList.prototype.removeLast = function () {
//   var last = this.last;
//   this.last = last.previous;
//   last.previous.next = null;
//
//   this.size--;
//   return last.value;
// };
//
// LinkedList.prototype.delete = function (node) {
//   if (node === this.first) {
//     this.first = null;
//     size--;
//   }
//   else {
//     node = node.next;
//     size--;
//   }
//
// };
//
// LinkedList.prototype.iterator = function(){
//   var self = this;
//   var curr = self.first;
//   var size = self.size;
//
//   return {
//     next: function(){
//       if (curr === null) {
//         return { done : true};
//       } else {
//         return {
//           value: function(){
//             var val = curr.value;
//             curr = curr.next;
//             return val;
//           }(),
//           done: false
//         }
//       }
//     }
//   }
// }
//
// LinkedList.prototype.contains = function (value) {
//   var curr = this.first
//
//   while(curr !== null){
//     if (curr.value === value) {
//       return true
//     }
//
//     return false;
//   }
// };
//
// LinkedList.prototype.toString = function () {
//   var node = this.first;
//   var s = '['
//
//   while (!(node === null)) {
//     if (node.hasNext()) {
//         s+= node.value + ', ';
//     }
//     else {
//       s += node.value;
//     }
//     node = node.next;
//   }
//
//   s+=']'
//   console.log(s);
//   return s;
// };
//
// if (require.main === module) {
//   var myLList = new LinkedList();
//   myLList.addAll(1,2,3,4,5,6,7,'are werr');
//   myLList.toString()
//   myLList.removeLast();
//   myLList.remove(5);
//   myLList.toString()
//   myLList.addFirst(0)
//   myLList.toString()
//   myLList.getFirst()
//   myLList.addLast('added last')
//   myLList.toString()
//   myLList.getLast()
//   console.log(myLList.size);
//   var i = myLList.iterator()
//   console.log(i.next().value);
//   console.log(i.next());
// }
