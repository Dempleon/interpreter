package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private int offset;
    private String id = "";

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmLoad(offset);
        if(vm.getDumpStatus()){
            System.out.println("LOAD " + offset + " " + id);
        }
    }

    @Override
    public void init(ArrayList args) {

//        System.out.println("debug loadCode");
//        System.out.println(args.get(0));
//        System.out.println(args.get(1));
        if(args.size() > 1) {
            id = (String) args.get(args.size() - 1);
        }
        this.offset = Integer.parseInt((String) args.get(0));
    }
}
