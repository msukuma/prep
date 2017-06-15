'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.TreeNode = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _node = require('../node/node');

var _constants = require('./constants');

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var TreeNode = exports.TreeNode = function (_Node) {
  _inherits(TreeNode, _Node);

  function TreeNode(args) {
    _classCallCheck(this, TreeNode);

    if (!args.value) {
      throw new Error('A TreeNode must have a value');
    }

    var _this = _possibleConstructorReturn(this, (TreeNode.__proto__ || Object.getPrototypeOf(TreeNode)).call(this, args.value));

    _this.parent = args.parent || null;
    _this.children = new Array(_constants.constants.numAlphabets);
    _this.wordEnder = args.endsWord || false;
    return _this;
  }

  _createClass(TreeNode, [{
    key: 'childIndex',
    value: function childIndex(char) {
      var charCode = char.charCodeAt(0);
      return charCode - _constants.constants.aCharCode;
    }
  }, {
    key: 'hasChild',
    value: function hasChild(char) {
      return this.children[this.childIndex(char)] !== undefined;
    }
  }, {
    key: 'addChild',
    value: function addChild(node) {
      this.children[this.childIndex(node.value)] = node;
    }
  }, {
    key: 'getChild',
    value: function getChild(char) {
      if (this.hasChild(char)) {
        return this.children[this.childIndex(char)];
      } else {
        return null;
      }
    }
  }, {
    key: 'getChildren',
    value: function getChildren() {
      return this.children;
    }
  }, {
    key: 'getParent',
    value: function getParent() {
      return this.parent;
    }
  }, {
    key: 'endsWord',
    value: function endsWord() {
      return this.wordEnder;
    }
  }, {
    key: 'setEndsWord',
    value: function setEndsWord() {
      this.wordEnder = true;
    }
  }, {
    key: 'setChildren',
    value: function setChildren(children) {
      this.children = children;
    }
  }]);

  return TreeNode;
}(_node.Node);