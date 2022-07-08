package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{

    private String dumpState;

    @Override
    public void init(ArrayList args) {
        dumpState = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(dumpState.equals("ON")){
            vm.setDumpOn();
        }
        if(dumpState.equals("OFF")){
            vm.setDumpOff();
        }
    }
}
