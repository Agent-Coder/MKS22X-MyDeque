public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start=0;
    end=0;
    size=0;
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start=0;
    end=0;
    size=0;
  }
  public int size(){
    return this.size;
  }
  public String toString(){
    String s="{";
    if(data[this.start]==null){
      return s+"}";
    }
    if(this.start>this.end){
      for(int i=this.start;i<this.size;i++){
        s+=data[i]+" ";
      }
      for(int i=0;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
    else if(this.start<this.end){
      for(int i=this.start;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
    return s.substring(0,s.length()-1)+"}";
  }
  public void addFirst(E element){
    if(this.size==data.length){
      E[] copy=(E[])new Object[2*data.length+1];
      for (int i=0;i<data.length;i++) {
        if(i==0){
          copy[i]=element;
        }
        copy[i]=data[i-1];
      }
      this.size++;
    }
    else{
      if(start==0){
        data[data.length-1]=element;
        this.start=data.length;
      }
      else{
        data[start-1]=element;
        this.start--;
      }
      this.size++;
    }
  }
  public void addLast(E element){
    if(this.size==data.length){
      E[] copy=(E[])new Object[2*data.length+1];
      for (int i=0;i<=data.length;i++) {
        if(i==data.length){
          copy[i]=element;
        }
        else{
          copy[i]=data[i];
        }
      }
      this.end++;
      this.size++;
    }
    else{
      if(end==data.length-1){
        data[0]=element;
        this.end=0;
      }
      else{
        data[end+1]=element;
        this.end++;
      }
      this.size++;
    }
  }
  public E removeFirst(){
    E r=data[this.start];
    if(this.start==data.length){
      this.start=0;
    }
    else{
      this.start++;
    }
      this.size--;
      return r;
  }
  public E removeLast(){
    E r=data[this.end];
    if(this.end==0){
      this.end=data.length;
    }
    else{
      this.end--;
    }
    this.size--;
    return r;
  }
  public E getFirst(){
    return data[this.start];
  }
  public E getLast(){
    return data[this.end];
  }
  /*public E copy(MyDeque newest){
    String s="s";
    MyDeque ary=new MyDeque(this.data.length*2+1);
    if(this.start>this.end){
      for(int i=this.start;i<this.size;i++){
        copy[i]=this.data[i]+" ";
      }
      for(int i=0;i<=data.length;i++){
        s+=data[i]+" ";
      }
    }
    else{
      for(int i=this.start;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
  }

  */
}
