package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int args;

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmNewFrame(args);
        if(vm.getDumpStatus()){
            System.out.println("ARGS " + args );
        }
    }

    @Override
    public void init(ArrayList args) {
        this.args = Integer.parseInt( (String) args.get(0));
    }
}
