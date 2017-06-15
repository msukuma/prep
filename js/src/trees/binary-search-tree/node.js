import {Node} from '../../node/node'

class BstNode extends Node{
  constructor(args) {
      super(args.value);
      this.left = args.left || null;
      this.right = args.right || null;
  }

  getLeft(){
    return this.left;
  }

  getRight(){
    return this.right;
  }

  add(value){
    if(value < this.value){
      if(!this.left){
        this.left = new BstNode({value: value});
      }
      else {
        this.left.add(value);
      }
    }
    else if (value > this.value){
      if(!this.right){
        this.right = new BstNode({value: value});
      }
      else {
        this.right.add(value);
      }
    }
  }

  print(){
    if (this.left) {
      this.left.print();
    }

    console.log(this.value);

    if (this.right) {
      this.right.print()
    }
  }
}
