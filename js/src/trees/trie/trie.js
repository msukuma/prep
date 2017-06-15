import {TreeNode} from './tree-node'
import {constants} from './constants'
import {Loader} from './loader'

class Trie {
  constructor() {
    this.parentNode = new TreeNode({value: 'start'});
    this.initChildren();
  }

  initChildren(){
    let children = [],
        char;

    for (var i = constants.aCharCode; i <= constants.zCharCode; i++) {
      char = String.fromCharCode(i);
      children.push(new TreeNode({value:char}));
    }
    this.parentNode.setChildren(children);
  }

  addWord(word){
    word = word.toLowerCase();
    this.validate(word);

    let curr = this.parentNode,
        char,
        childNode;

    for (var i = 0; i < word.length; i++) {
      char = word[i];

      if(curr.hasChild(char)) {
        curr = curr.getChild(char);
      }
      else {
        childNode = new TreeNode({value: char, parent: curr});
        curr.addChild(childNode);
        curr = childNode;
      }
    }
    // console.log(`${word} child: ${curr.value}`);
    curr.setEndsWord();
  }

  hasWord(word){
    word = word.toLowerCase();
    this.validate(word);

    let curr = this.parentNode,
        char;

    for (var i = 0; i < word.length; i++) {
      char = word[i];

      if(!curr.hasChild(char)) {
        return false;
      }
      curr = curr.getChild(char);
    }

    return curr.endsWord();
  }

  findPartial(partial){
    partial = partial.toLowerCase();
    this.validate(partial);

    let curr = this.parentNode,
        char,
        children,
        words = [],
        queue = [];

    for (var i = 0; i < partial.length; i++) {
      char = partial[i];

      if(!curr.hasChild(char)) {
        return words;
      }
      curr = curr.getChild(char);
    }

    queue.push(curr);
    while(queue.length){
      curr = queue.shift();

      if (curr.endsWord()) {
        words.push(this.buildWord(curr))
      }

      curr.getChildren().forEach((child) => {
        if(child) queue.push(child);
      })
    }

    return words;
  }

  buildWord(node, prefix){
    if(!node){
      throw new Error('Node can not be null or undefined');
    }

    if (!node.value) {
      throw new Error('node must have a value');
    }

    let curr = node,
        word = '';

    while(curr !== null){
      word = curr.getValue() + word;
      curr = curr.getParent();
    }

    return prefix ? prefix+word : word;

  }

  validate(word){
    if (word.length < 2) {
      throw new Error('a word must be at least two characters long');
    }

    if (!typeof word === 'string') {
      throw new Error('can only add a string');
    }

    if (!this.validWord(word)) {
      throw new Error('can only add a string with alphabetic characters');
    }
  }

  validWord(word){
    for (var i = 0; i < word.length; i++) {
      if (word.codePointAt(i) < constants.aCharCode || word.codePointAt(i) > constants.zCharCode) {
        return false;
      }
    }
    return true;
  }
}

trie = new Trie()

Loader.load(trie, '/usr/share/dict/words', function(){
    console.log(trie.hasWord('stream'));
    console.log(trie.findPartial('mean'));
});
