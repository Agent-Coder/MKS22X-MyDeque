import java.util.*;
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
    else{
      for(int i=this.start;i<=this.end;i++){
        s+=data[i]+" ";
      }
    }
    return s.substring(0,s.length()-1)+"}";
  }
  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(data[this.start]==null){
      data[this.start]=element;
    }
    else if(this.size==data.length){
      E[] copy=(E[])new Object[2*data.length+1];
      for (int i=0;i<data.length;i++){
        copy[i]=data[i];
      }
      data=copy;
      data[this.size]=element;
      //System.out.println("new start"+this.size);
      this.start=this.size;
    }
    else{
      data[this.size]=element;
      this.start=this.size;
    }
    this.size++;
    //System.out.println(Arrays.toString(data));
    //System.out.println("start"+this.start);
    //System.out.println(this.end);
  }
  public void addLast(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(data[this.end]==null){
      data[this.end]=element;
    }
    else if(this.size==data.length){
      E[] copy=(E[])new Object[2*data.length+1];
      for (int i=0;i<=data.length;i++) {
        if(i==data.length){
          copy[i]=element;
        }
        else{
          copy[i]=data[i];
        }
      }
      data=copy;
      this.end++;
    }
    else{
      if(end==data.length-1){
        data[0]=element;
        this.end=0;
      }
      else{
        data[this.end+1]=element;
        this.end++;
      }
    }
    this.size++;
  }
  public E removeFirst(){
    E r=data[this.start];
    if(r==null){
      throw new NoSuchElementException();
    }
    if(this.start==data.length-1){
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
    if(r==null){
      throw new NoSuchElementException();
    }
    if(this.end==0){
      this.end=this.size-1;
    }
    else{
      this.end--;
    }
    this.size--;
    return r;
  }
  public E getFirst(){
    if(data[this.start]==null){
      throw new NoSuchElementException();
    }
    return data[this.start];
  }
  public E getLast(){
    if(data[this.end]==null){
      throw new NoSuchElementException();
    }
    return data[this.end];
  }

  public static void main(String[] args) {
    MyDeque<Integer> deque = new MyDeque<>();
    deque.addFirst(0);
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    deque.addFirst(5);
    deque.addFirst(6);
    deque.addFirst(7);
    deque.addFirst(8);
    deque.addFirst(9);
    deque.addFirst(10);
    System.out.println(deque);
  }
}
