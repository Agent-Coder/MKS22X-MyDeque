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
    //System.out.println("-->"+this.size);
    String s="{";
    if(data[this.start]==null){
      return s+"}";
    }
    if(this.start>this.end){
      for(int i=this.start;i<data.length;i++){
        //System.out.println(i);
        s+=data[i]+" ";
        //System.out.println(s);
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
  public void resize(){
    E[] copy=(E[])new Object[2*data.length+1];
    if(this.start>this.end){
      int k=0;
      for(int i=this.start;i<data.length;i++){
        copy[k]=data[i];
        k++;
      }
      for(int i=0;i<=this.end;i++){
        copy[k]=data[i];
        k++;
      }
    }
    else{
      int k=0;
      for(int i=this.start;i<=this.end;i++){
        copy[k]=data[i];
        k++;
      }
    }
    data=copy;
    this.start=0;
    this.end=this.size-1;
  }
  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(data[this.start]==null){
      data[this.start]=element;
    }
    else{
      if(this.size==data.length){
        this.resize();
        //System.out.println("resized to"+data.length);
      }
      if(this.start==0){
        this.start=data.length-1;
      }
      else{
        this.start--;
      }
      data[this.start]=element;
    }
    //System.out.println("first"+this.start);
    //System.out.println("last"+this.end);
    this.size++;
    //System.out.println(size);
    //System.out.println("yes"+Arrays.toString(data));
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
    else{
      if(this.size==data.length){
        this.resize();
      }
      if(end==data.length-1){
        this.end=0;
      }
      else{
        this.end++;
      }
      data[this.end]=element;
    }
    this.size++;
  }
  public E removeFirst(){
    //System.out.println(this.start);
    E r=data[this.start];
    if(r==null){
      System.out.println(this.start);
      System.out.println(Arrays.toString(data));
      //System.out.println("1");
      throw new NoSuchElementException();
    }
    //System.out.println("start is at"+this.start);
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
      //System.out.println("2");
      throw new NoSuchElementException();
    }
    if(this.end==0){
      this.end=data.length-1;
    }
    else{
      this.end--;
    }
    this.size--;
    return r;
  }
  public E getFirst(){
    if(data[this.start]==null){
      //System.out.println("3");
      throw new NoSuchElementException();
    }
    return data[this.start];
  }
  public E getLast(){
    if(data[this.end]==null){
      //System.out.println("4");
      throw new NoSuchElementException();
    }
    return data[this.end];
  }
  public int getF(){
    return this.start;
  }
  //public void
  /*public static void main(String[] args) {
    MyDeque<Integer> deque = new MyDeque<>();
    for (int i = 0; i <= 10; i++) {
      deque.addLast(i);
    }
    System.out.println(deque);
    deque.removeLast();
    System.out.println(deque);
  }*/
}
