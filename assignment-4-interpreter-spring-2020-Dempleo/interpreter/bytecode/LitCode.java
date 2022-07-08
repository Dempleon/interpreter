package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    private int value;
    private String id = "";

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmNewFrame(value);
        if(vm.getDumpStatus()){
            System.out.println("LIT " + value + " " + id);

        }
    }

    @Override
    public void init(ArrayList args) {
        this.value = Integer.parseInt((String) args.get(0));
        if(args.size() > 1) {
            id = (String) args.get(args.size() - 1);
        }
    }
}
