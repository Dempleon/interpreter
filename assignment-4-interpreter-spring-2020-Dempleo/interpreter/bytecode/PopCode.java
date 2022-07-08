package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int popLevels;

    @Override
    public void init(ArrayList args) {
        this.popLevels = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < popLevels; i++) {
            vm.popRunStack();
        }
    }
}
