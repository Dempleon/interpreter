package interpreter;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class RunTimeStack {

  private Stack<Integer> framePointers;
  // This may not be the right parameterized type!!
  private Vector<Integer> runStack;

  public RunTimeStack() {
    runStack = new Vector<>();
    framePointers = new Stack<>();

    //add framepointer for main
    framePointers.add(0);
  }

  /**
   * The purpose of this function is to dump the RunTimeStack for the 
   * purpose of debugging.
   */
  public void dump() {

    //System.out.println("debugging :: RunTimeStack dump method");
    //System.out.println(framePointers);

    Iterator iterator = framePointers.iterator();

    for(int i = 1; i < runStack.size(); i++){

        System.out.print("," + runStack.get(i));

    }
    System.out.println(framePointers);

  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() {
    if(runStack.isEmpty()){
      System.out.println("Runtimestack empty (peek):");
      return 0;
    }
    return runStack.lastElement();
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() {
    if(runStack.isEmpty()){
      System.out.println("RunTimeStack is empty (pop)");
      System.exit(-1);
    }
    return runStack.remove(runStack.size() - 1);
  }

  /**
   * Push an item on to the runtime stack, returning the item that was just 
   * pushed.
   */
  public int push(int item) {
    runStack.add(item);
    return item;
  }

  /**
   * This second form with an Integer parameter is used to load literals onto the
   * stack.
   */
  public Integer push(Integer i) {
    runStack.add(i);
    return i;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots
   * down from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {
    framePointers.push(runStack.size()-offset);
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() {
    int topFrame = peek();
    while(runStack.size() > framePointers.peek()) {
      runStack.remove(runStack.size() - 1);
    }
    framePointers.pop();
    runStack.add(topFrame);
  }

  /**
   * Used to store into variables.
   */
  public int store(int offset) {
    if(runStack.isEmpty()) {
      System.out.println("runtimestack is empty (store)");
      System.exit(-9);
    }
    int top = this.pop();
    runStack.set(framePointers.peek() + offset, top);
    return top;
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {
    if(runStack.isEmpty()){
      System.out.println("runtimestack is empty (load)");
      System.exit(-10);
    }
    int loadValue = runStack.get(framePointers.peek() + offset);
    push(loadValue);
    return loadValue;
  }
}