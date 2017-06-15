import {NotFoundError} from './error'

class BinarySearchTree {
  constructor(args) {
    this.value = args && args.value || null;
    this.left = args && args.left || null;
    this.right = args && args.right || null;
    this.parent = args && args.parent || null;
  }

  add(value){
    if (!this.value) {
      this.value = new BinarySearchTree({value: value});
    }
    else {
      if(value < this.value){
        if (!this.left) {
          this.left = new BinarySearchTree({value: value, parent: this});
        }
        else {
          this.left.add(value);
        }
      }
      else {
        if (!this.right) {
          this.right = new BinarySearchTree({value: value, parent: this});
        }
        else {
          this.right.add(value);
        }
      }
    }
  }

  addAll(){
    for (var i = 0; i < arguments.length; i++) {
      this.add(arguments[i]);
    }
  }

  addSubTree(subTreeRoot){
    if (!this.value) {
      // if this is the root
      this.value = subTreeRoot.value;
      this.left = subTreeRoot.left;
      this.right = subTreeRoot.right;
      this.parent = null;
    }
    else {
      if(subTreeRoot.value < this.value){
        if (!this.left) {
          this.left = subTreeRoot;
          subTreeRoot.parent = this;
        }
        else {
          this.left.addSubTree(subTreeRoot);
        }
      }
      else {
        if (!this.right) {
          this.right = subTreeRoot;
          subTreeRoot.parent = this;
        }
        else {
          this.right.addSubTree(subTreeRoot);
        }
      }
    }
  }

  find(value){

    if (!this.value) {
      throw new NotFoundError(value);
    }

    if (this.value === value) {
      return this;
    }
    else if (value < this.value) {
      if (this.left) {
        return this.left.find(value);
      }
      throw new NotFoundError(value);
    }
    else {
      if (this.right) {
        return this.right.find(value);
      }
      throw new NotFoundError(value);
    }
  }

  onLeftOfParent(){
    if (this.parent !== null || this.parent !== undefined) {
      return this.parent.value > this.value;
    }
    return false;
  }

  isRoot(){
    return this.parent === null;
  }

  remove(value){
    let toRemove;

    try {
      toRemove = this.find(value);

      if (toRemove.left && toRemove.right) {
        toRemove.right.addSubTree(toRemove.left);
        //where is toRemove relative to its parent
        if (toRemove.isRoot()) {
          toRemove.value = toRemove.right.value
          toRemove.left = toRemove.right.left
          toRemove.right = toRemove.right.right
          toRemove.parent = toRemove.right.parent
        }
        if(toRemove.onLeftOfParent()){
          toRemove.parent.left = toRemove.right;
        }
        else {
          toRemove.parent.right = toRemove.right;
        }


      }
      else if (toRemove.left) {
        if (onLeft(toRemove.parent, toRemove)) {

        }
      }
      else if (remove.right) {

      }


      if (toRemove.parent) {
        toRemove.parent.left = toRemove.right;
      }

      return true;
    }
    catch (e) {
      if (e.name === 'NotFoundError') {
        return true;
      }

      throw e;
    }

  }



  print(){
    if(this.left){
      this.left.print();
    }
    console.log(this.value);

    if (this.right) {
      this.right.print();
    }
  }
}

let bst = new BinarySearchTree();
bst.addAll(5,1,6,3,8,2,9,-5,50,-7,32);
bst.print();
bst.remove(8)
bst.print()
