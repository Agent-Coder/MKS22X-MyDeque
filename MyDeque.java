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
      for(int i=this.start;i<data.length;i++){
        s+=data[i]+" ";
      }
      for(int i=0;i<=data.end;i++){
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
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){
    return data[this.start];
  }
  public E getLast(){
    return data[this.end];
  }
}
