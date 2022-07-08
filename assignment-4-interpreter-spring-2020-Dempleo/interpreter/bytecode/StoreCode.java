package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private String id = "";
    private int offset;

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmStore(offset);
        if(vm.getDumpStatus()){
            System.out.println("STORE " + offset + id);
        }
    }

    @Override
    public void init(ArrayList args) {
        offset = Integer.parseInt((String) args.get(0));
        if(args.size() > 1) {
            id = (String) args.get(args.size() - 1);
        }
    }
}
