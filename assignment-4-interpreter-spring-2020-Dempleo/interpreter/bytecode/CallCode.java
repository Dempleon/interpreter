package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String labelName;
    private int targetAddress;

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushAddress(targetAddress);
        if(vm.getDumpStatus()){
            System.out.println("CALL " + labelName);
        }
    }

    @Override
    public void init(ArrayList args) {
        labelName = (String) args.get(0);
    }

    public void setTargetAddress (int target) {
        this.targetAddress = target;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getTargetAddress() {
        return this.targetAddress;
    }
}
