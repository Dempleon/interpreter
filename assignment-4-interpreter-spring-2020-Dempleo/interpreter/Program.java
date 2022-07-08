package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {
  private ArrayList<ByteCode> program;
  private static HashMap<String, Integer> addresses;

  Program() {
    program = new ArrayList<>();
    addresses = new HashMap<String, Integer>();
  }

  public ByteCode getCode(int programCounter) {
    return this.program.get(programCounter);
  }

  public int getProgramSize() {
    return this.program.size();
  }

  public void addByteCode(ByteCode byteCode) {
    if(byteCode instanceof LabelCode){
      LabelCode label = (LabelCode) byteCode;
      addresses.put(label.getLabel(), program.size());
    }
    program.add(byteCode);
  }

  public void resolveSymbolicAddress(){
    for(ByteCode byteCode : program) {

      if(byteCode instanceof GotoCode){
        GotoCode branch = (GotoCode) byteCode;

//        System.out.println("debug:: it ends here");
//        System.out.println("label name: "+branch.getLabelName());
//        System.out.println("targetAddress " + branch.getTargetAddress());
//        System.out.println(addresses);

        branch.setTargetAddress(addresses.get(branch.getLabelName()));
      }

      if(byteCode instanceof FalsebranchCode) {
        FalsebranchCode branch = (FalsebranchCode) byteCode;
        branch.setTargetAddress(addresses.get(branch.getLabelName()));
      }

      if(byteCode instanceof CallCode) {
        CallCode branch = (CallCode) byteCode;
        branch.setTargetAddress(addresses.get(branch.getLabelName()));
      }

    }
  }
}