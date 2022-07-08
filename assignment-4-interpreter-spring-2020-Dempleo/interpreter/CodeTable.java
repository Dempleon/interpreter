package interpreter;

import java.util.HashMap;

public class CodeTable {

  private static HashMap<String, String> codeTable;
  public static void init () {
    codeTable = new HashMap<>();
    codeTable.put("HALT", "HaltCode");
    codeTable.put("POP", "PopCode");
    codeTable.put("FALSEBRANCH", "FalseBranchCode");
    codeTable.put("GOTO", "GotoCode");
    codeTable.put("STORE", "StoreCode");
    codeTable.put("LOAD", "LoadCode");
    codeTable.put("LIT", "LitCode");
    codeTable.put("ARGS", "ArgsCode");
    codeTable.put("CALL", "CallCode");
    codeTable.put("RETURN", "ReturnCode");
    codeTable.put("BOP", "BopCode");
    codeTable.put("READ", "ReadCode");
    codeTable.put("WRITE", "WriteCode");
    codeTable.put("LABEL", "LabelCode");
    codeTable.put("DUMP", "DumpCode");

  }

  public static String getClass(String key) {
    return codeTable.get(key);
  }
}