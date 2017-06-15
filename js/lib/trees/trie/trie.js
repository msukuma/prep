'use strict';

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _treeNode = require('./tree-node');

var _constants = require('./constants');

var _loader = require('./loader');

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Trie = function () {
  function Trie() {
    _classCallCheck(this, Trie);

    this.parentNode = new _treeNode.TreeNode({ value: 'start' });
    this.initChildren();
  }

  _createClass(Trie, [{
    key: 'initChildren',
    value: function initChildren() {
      var children = [],
          char = void 0;

      for (var i = _constants.constants.aCharCode; i <= _constants.constants.zCharCode; i++) {
        char = String.fromCharCode(i);
        children.push(new _treeNode.TreeNode({ value: char }));
      }
      this.parentNode.setChildren(children);
    }
  }, {
    key: 'addWord',
    value: function addWord(word) {
      word = word.toLowerCase();
      this.validate(word);

      var curr = this.parentNode,
          char = void 0,
          childNode = void 0;

      for (var i = 0; i < word.length; i++) {
        char = word[i];

        if (curr.hasChild(char)) {
          curr = curr.getChild(char);
        } else {
          childNode = new _treeNode.TreeNode({ value: char, parent: curr });
          curr.addChild(childNode);
          curr = childNode;
        }
      }
      // console.log(`${word} child: ${curr.value}`);
      curr.setEndsWord();
    }
  }, {
    key: 'hasWord',
    value: function hasWord(word) {
      word = word.toLowerCase();
      this.validate(word);

      var curr = this.parentNode,
          char = void 0;

      for (var i = 0; i < word.length; i++) {
        char = word[i];

        if (!curr.hasChild(char)) {
          return false;
        }
        curr = curr.getChild(char);
      }

      return curr.endsWord();
    }
  }, {
    key: 'findPartial',
    value: function findPartial(partial) {
      partial = partial.toLowerCase();
      this.validate(partial);

      var curr = this.parentNode,
          char = void 0,
          children = void 0,
          words = [],
          queue = [];

      for (var i = 0; i < partial.length; i++) {
        char = partial[i];

        if (!curr.hasChild(char)) {
          return words;
        }
        curr = curr.getChild(char);
      }

      queue.push(curr);
      while (queue.length) {
        curr = queue.shift();

        if (curr.endsWord()) {
          words.push(this.buildWord(curr));
        }

        curr.getChildren().forEach(function (child) {
          if (child) queue.push(child);
        });
      }

      return words;
    }
  }, {
    key: 'buildWord',
    value: function buildWord(node, prefix) {
      if (!node) {
        throw new Error('Node can not be null or undefined');
      }

      if (!node.value) {
        throw new Error('node must have a value');
      }

      var curr = node,
          word = '';

      while (curr !== null) {
        word = curr.getValue() + word;
        curr = curr.getParent();
      }

      return prefix ? prefix + word : word;
    }
  }, {
    key: 'validate',
    value: function validate(word) {
      if (word.length < 2) {
        throw new Error('a word must be at least two characters long');
      }

      if (!(typeof word === 'undefined' ? 'undefined' : _typeof(word)) === 'string') {
        throw new Error('can only add a string');
      }

      if (!this.validWord(word)) {
        throw new Error('can only add a string with alphabetic characters');
      }
    }
  }, {
    key: 'validWord',
    value: function validWord(word) {
      for (var i = 0; i < word.length; i++) {
        if (word.codePointAt(i) < _constants.constants.aCharCode || word.codePointAt(i) > _constants.constants.zCharCode) {
          return false;
        }
      }
      return true;
    }
  }]);

  return Trie;
}();

trie = new Trie();

_loader.Loader.load(trie, '/usr/share/dict/words', function () {
  console.log(trie.hasWord('stream'));
  console.log(trie.findPartial('mean'));
});