package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Read in an integer: ");
        Scanner scanner = new Scanner(System.in);
        int scannedInt = scanner.nextInt();
        vm.vmPush(scannedInt);
    }

    @Override
    public void init(ArrayList args) {

    }
}
