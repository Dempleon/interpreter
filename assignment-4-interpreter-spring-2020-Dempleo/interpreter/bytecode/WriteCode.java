package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        int peekValue = vm.vmPeek();
        System.out.println("Write");
        System.out.println(peekValue);
    }

    @Override
    public void init(ArrayList args) {
    }
}
