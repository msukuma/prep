
import {Node} from '../node/node'
import {constants} from './constants'

export class TreeNode extends Node {

  constructor(args) {
    if (!args.value) {
      throw new Error('A TreeNode must have a value');
    }
    super(args.value);
    this.parent = args.parent || null;
    this.children = new Array(constants.numAlphabets);
    this.wordEnder = args.endsWord || false;
  }

  childIndex(char){
    let charCode = char.charCodeAt(0);
    return charCode - constants.aCharCode;
  }

  hasChild(char){
    return this.children[this.childIndex(char)] !== undefined;
  }

  addChild(node){
    this.children[this.childIndex(node.value)] = node;
  }

  getChild(char){
    if(this.hasChild(char)){
      return this.children[this.childIndex(char)];
    }
    else {
      return null;
    }
  }

  getChildren(){
    return this.children;
  }

  getParent(){
    return this.parent;
  }

  endsWord(){
    return this.wordEnder;
  }

  setEndsWord(){
    this.wordEnder = true;
  }

  setChildren(children){
    this.children = children;
  }
}
