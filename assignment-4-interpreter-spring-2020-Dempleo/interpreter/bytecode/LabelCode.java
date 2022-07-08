package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;
    @Override
    public void init(ArrayList args) {
        this.label = (String) args.get(0);
    }
    @Override
    public void execute(VirtualMachine vm) {
        if(vm.getDumpStatus()){
            System.out.println("LABEL " + label);
        }
    }

    public String getLabel(){
        return this.label;
    }
}
