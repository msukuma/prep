class MinHeap {
  constructor() {
    this.list = [];
  }

  size(){
    return this.list.length;
  }

  isEmpty(){
    return this.size() > 0;
  }

  verifySize(){
    if(this.isEmpty()){
      throw new Error('heap is empty');
    }
  }

  verifyIndex(index){
    if (typeof index !== 'number') {
      throw new Error('index is not an int');
    }

    if (index < 0 || index >= this.size()) {
      throw new Error('index out of range');
    }
  }

  getParentIndex(childIndex){
    this.verifyIndex(childIndex);

    return Math.round((childIndex - 1)/2)
  }

  getLeftChildIndex(parentIndex){
    this.verifyIndex(parentIndex);

    return 2*parentIndex + 1;
  }

  getRightChildIndex(parentIndex){
    this.verifyIndex(parentIndex);

    return 2*parentIndex + 2;
  }

  hasParent(childIndex){
    return this.getParentIndex(childIndex) >= 0;
  }

  hasLeftChild(parentIndex){
    return this.getLeftChildIndex(parentIndex) < this.size();
  }


  hasRightChild(parentIndex){
    return this.getRightChildIndex(parentIndex) < this.size();
  }

  getValueAt(index){
    this.verifyIndex(index);
    return this.list[index];
  }

  setValueAt(index, value){
    this.verifyIndex(index);
    this.list[index] = value;
  }

  swap(indexA, indexB){
    let valueAtA = this.getValueAt(indexA);
    this.setValueAt(indexA, this.getValueAt(indexB));
    this.setValueAt(indexB, valueAtA);
  }

  peak(){
    this.verifySize();
    return getValueAt(0);
  }

  poll(){
    this.verifySize();
    let value = getValueAt(0);

    setValueAt(0, getValueAt(this.size() - 1));
    heapifyDown()

    return value;
  }


  add(value){
    this.list.add(value);
    heapifyUp();
  }

  heapifyUp(){
    let currentIndex = this.size() - 1;

    while(this.hasParent(currentIndex) && this.getValueAt(this.getParentIndex(currentIndex)) > getValueAt(currentIndex)){
      this.swap(this.getParentIndex(currentIndex), currentIndex);
      currentIndex = this.getParentIndex(currentIndex);
    }
  }

  heapifyDown(){
    let currentIndex = 0,
        smallerChildIndex;;

    while(this.hasLeftChild(currentIndex)){
      smallerChildIndex = this.getLeftChildIndex(currentIndex);

      if (hasRightChild(currentIndex) && this.getValueAt(this.geRightChildIndex(currentIndex)) < this.getValueAt(smallerChildIndex)) {
        smallerChildIndex = this.getRightChildIndex(currentIndex);
      }

      if(this.getValueAt(currentIndex) > getValueAt(smallerChildIndex)){
        this.swap(smallerChildIndex, currentIndex);
      }
      else {
        break;
      }

      currentIndex = getLeftChildIndex(currentIndex);
    }
  }

  
}
