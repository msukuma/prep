'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _error = require('./error');

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var BinarySearchTree = function () {
  function BinarySearchTree(args) {
    _classCallCheck(this, BinarySearchTree);

    this.value = args && args.value || null;
    this.left = args && args.left || null;
    this.right = args && args.right || null;
    this.parent = args && args.parent || null;
  }

  _createClass(BinarySearchTree, [{
    key: 'add',
    value: function add(value) {
      if (!this.value) {
        this.value = new BinarySearchTree({ value: value });
      } else {
        if (value < this.value) {
          if (!this.left) {
            this.left = new BinarySearchTree({ value: value, parent: this });
          } else {
            this.left.add(value);
          }
        } else {
          if (!this.right) {
            this.right = new BinarySearchTree({ value: value, parent: this });
          } else {
            this.right.add(value);
          }
        }
      }
    }
  }, {
    key: 'addAll',
    value: function addAll() {
      for (var i = 0; i < arguments.length; i++) {
        this.add(arguments[i]);
      }
    }
  }, {
    key: 'addSubTree',
    value: function addSubTree(subTreeRoot) {
      if (!this.value) {
        // if this is the root
        this.value = subTreeRoot.value;
        this.left = subTreeRoot.left;
        this.right = subTreeRoot.right;
        this.parent = null;
      } else {
        if (subTreeRoot.value < this.value) {
          if (!this.left) {
            this.left = subTreeRoot;
            subTreeRoot.parent = this;
          } else {
            this.left.addSubTree(subTreeRoot);
          }
        } else {
          if (!this.right) {
            this.right = subTreeRoot;
            subTreeRoot.parent = this;
          } else {
            this.right.addSubTree(subTreeRoot);
          }
        }
      }
    }
  }, {
    key: 'find',
    value: function find(value) {

      if (!this.value) {
        throw new _error.NotFoundError(value);
      }

      if (this.value === value) {
        return this;
      } else if (value < this.value) {
        if (this.left) {
          return this.left.find(value);
        }
        throw new _error.NotFoundError(value);
      } else {
        if (this.right) {
          return this.right.find(value);
        }
        throw new _error.NotFoundError(value);
      }
    }
  }, {
    key: 'onLeftOfParent',
    value: function onLeftOfParent() {
      if (this.parent !== null || this.parent !== undefined) {
        return this.parent.value > this.value;
      }
      return false;
    }
  }, {
    key: 'isRoot',
    value: function isRoot() {
      return this.parent === null;
    }
  }, {
    key: 'remove',
    value: function (_remove) {
      function remove(_x) {
        return _remove.apply(this, arguments);
      }

      remove.toString = function () {
        return _remove.toString();
      };

      return remove;
    }(function (value) {
      var toRemove = void 0;

      try {
        toRemove = this.find(value);

        if (toRemove.left && toRemove.right) {
          toRemove.right.addSubTree(toRemove.left);
          //where is toRemove relative to its parent
          if (toRemove.isRoot()) {
            toRemove.value = toRemove.right.value;
            toRemove.left = toRemove.right.left;
            toRemove.right = toRemove.right.right;
            toRemove.parent = toRemove.right.parent;
          }
          if (toRemove.onLeftOfParent()) {
            toRemove.parent.left = toRemove.right;
          } else {
            toRemove.parent.right = toRemove.right;
          }
        } else if (toRemove.left) {
          if (onLeft(toRemove.parent, toRemove)) {}
        } else if (remove.right) {}

        if (toRemove.parent) {
          toRemove.parent.left = toRemove.right;
        }

        return true;
      } catch (e) {
        if (e.name === 'NotFoundError') {
          return true;
        }

        throw e;
      }
    })
  }, {
    key: 'print',
    value: function print() {
      if (this.left) {
        this.left.print();
      }
      console.log(this.value);

      if (this.right) {
        this.right.print();
      }
    }
  }]);

  return BinarySearchTree;
}();

var bst = new BinarySearchTree();
bst.addAll(5, 1, 6, 3, 8, 2, 9, -5, 50, -7, 32);
bst.print();
bst.remove(8);
bst.print();