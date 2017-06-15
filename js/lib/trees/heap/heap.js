'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var MinHeap = function () {
  function MinHeap() {
    _classCallCheck(this, MinHeap);

    this.list = [];
  }

  _createClass(MinHeap, [{
    key: 'size',
    value: function size() {
      return this.list.length;
    }
  }, {
    key: 'isEmpty',
    value: function isEmpty() {
      return this.size() > 0;
    }
  }, {
    key: 'verifySize',
    value: function verifySize() {
      if (this.isEmpty()) {
        throw new Error('heap is empty');
      }
    }
  }, {
    key: 'verifyIndex',
    value: function verifyIndex(index) {
      if (typeof index !== 'number') {
        throw new Error('index is not an int');
      }

      if (index < 0 || index >= this.size()) {
        throw new Error('index out of range');
      }
    }
  }, {
    key: 'getParentIndex',
    value: function getParentIndex(childIndex) {
      this.verifyIndex(childIndex);

      return Math.round((childIndex - 1) / 2);
    }
  }, {
    key: 'getLeftChildIndex',
    value: function getLeftChildIndex(parentIndex) {
      this.verifyIndex(parentIndex);

      return 2 * parentIndex + 1;
    }
  }, {
    key: 'getRightChildIndex',
    value: function getRightChildIndex(parentIndex) {
      this.verifyIndex(parentIndex);

      return 2 * parentIndex + 2;
    }
  }, {
    key: 'hasParent',
    value: function hasParent(childIndex) {
      return this.getParentIndex(childIndex) >= 0;
    }
  }, {
    key: 'hasLeftChild',
    value: function hasLeftChild(parentIndex) {
      return this.getLeftChildIndex(parentIndex) < this.size();
    }
  }, {
    key: 'hasRightChild',
    value: function hasRightChild(parentIndex) {
      return this.getRightChildIndex(parentIndex) < this.size();
    }
  }, {
    key: 'getValueAt',
    value: function getValueAt(index) {
      this.verifyIndex(index);
      return this.list[index];
    }
  }, {
    key: 'setValueAt',
    value: function setValueAt(index, value) {
      this.verifyIndex(index);
      this.list[index] = value;
    }
  }, {
    key: 'swap',
    value: function swap(indexA, indexB) {
      var valueAtA = this.getValueAt(indexA);
      this.setValueAt(indexA, this.getValueAt(indexB));
      this.setValueAt(indexB, valueAtA);
    }
  }, {
    key: 'peak',
    value: function peak() {
      this.verifySize();
      return getValueAt(0);
    }
  }, {
    key: 'poll',
    value: function poll() {
      this.verifySize();
      var value = getValueAt(0);

      setValueAt(0, getValueAt(this.size() - 1));
      heapifyDown();

      return value;
    }
  }, {
    key: 'add',
    value: function add(value) {
      this.list.add(value);
      heapifyUp();
    }
  }, {
    key: 'heapifyUp',
    value: function heapifyUp() {
      var currentIndex = this.size() - 1;

      while (this.hasParent(currentIndex) && this.getValueAt(this.getParentIndex(currentIndex)) > getValueAt(currentIndex)) {
        this.swap(this.getParentIndex(currentIndex), currentIndex);
        currentIndex = this.getParentIndex(currentIndex);
      }
    }
  }, {
    key: 'heapifyDown',
    value: function heapifyDown() {
      var currentIndex = 0,
          smallerChildIndex = void 0;;

      while (this.hasLeftChild(currentIndex)) {
        smallerChildIndex = this.getLeftChildIndex(currentIndex);

        if (hasRightChild(currentIndex) && this.getValueAt(this.geRightChildIndex(currentIndex)) < this.getValueAt(smallerChildIndex)) {
          smallerChildIndex = this.getRightChildIndex(currentIndex);
        }

        if (this.getValueAt(currentIndex) > getValueAt(smallerChildIndex)) {
          this.swap(smallerChildIndex, currentIndex);
        } else {
          break;
        }

        currentIndex = getLeftChildIndex(currentIndex);
      }
    }
  }]);

  return MinHeap;
}();