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
    if(this.start>this.end){
      for(int i=this.start;i<this.size;i++){
        s+=data[i]+" ";
      }
      for(int i=0;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
    else{
      for(int i=this.start;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
    return s.substring(0,s.length()-1)+"}";
  }
  public void addFirst(E element){

  }
  public void addLast(E element){
    if(this.size==data.length){
      E[] copy=(E[])new Object[2*data.length+1];
      for (int i=0;i<data.length;i++) {
        if(i==0){
          copy[i]=element;
        }
        copy[i]=data[i-1];
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
  public E removeFirst(){ }
  public E removeLast(){ }
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
