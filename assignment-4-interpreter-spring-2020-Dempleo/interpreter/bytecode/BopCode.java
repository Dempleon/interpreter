package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class BopCode extends ByteCode {

    private String bop = "";

    @Override
    public void init(ArrayList args) {
        bop = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int topOperand = vm.popRunStack();
        int bottomOperand = vm.popRunStack();

        switch (bop) {
            case "+":
                vm.vmPush(topOperand + bottomOperand);
                break;

            case "-":
                vm.vmPush(topOperand - bottomOperand);
                break;

            case "*":
                vm.vmPush(topOperand * bottomOperand);
                break;

            case "/":
                vm.vmPush(topOperand / bottomOperand);
                break;

            case "==":
                if(topOperand == bottomOperand) {
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);
                }
                break;

            case "!=":
                if(topOperand != bottomOperand) {
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);
                }
                break;

            case "<=":
                if(bottomOperand <= topOperand){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;

            case "<":
                if(bottomOperand < topOperand){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;

            case ">=":
                if(bottomOperand >= topOperand){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;

            case ">":
                if(bottomOperand > topOperand){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;

            case "|":
                if(bottomOperand == 1 || topOperand == 1){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;

            case "&":
                if(bottomOperand == 1 && topOperand == 1){
                    vm.vmPush(1);
                }
                else {
                    vm.vmPush(0);;
                }
                break;
        }
    }

}
