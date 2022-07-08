package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    private int value;
    private String functionId = "";

    @Override
    public void execute(VirtualMachine vm) {
        vm.vmPopFrame();
        vm.setPc(vm.vmPopReturnAddresses());
        value = vm.vmPeek();

        if(vm.getDumpStatus()){
            System.out.println("RETURN " + functionId);
        }
    }

    @Override
    public void init(ArrayList args) {
        if(args.isEmpty()){
            //debug
            //System.out.println("empty args return code");
        }
        else {
            functionId= (String) args.get(0);
        }
    }
}
