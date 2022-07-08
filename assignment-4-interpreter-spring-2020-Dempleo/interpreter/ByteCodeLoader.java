package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class ByteCodeLoader {
  private BufferedReader byteSource;

  public ByteCodeLoader(String byteCodeFile) throws IOException{
    byteSource = new BufferedReader(new FileReader(byteCodeFile));
  }

  public Program loadCodes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

    CodeTable.init();
    Program program = new Program();
    ArrayList<String> args = new ArrayList<>();
    String sourceLine = byteSource.readLine();



    while(sourceLine != null) {

      //System.out.println("debug: does it get here?" + sourceLine);

      //get the className
      args.clear();
      StringTokenizer tokenizer = new StringTokenizer(sourceLine);
      String className = CodeTable.getClass(tokenizer.nextToken());
      //System.out.println("debug:: clasname = " + className);

      //get the following args
      while(tokenizer.hasMoreTokens()){
        args.add(tokenizer.nextToken());

      }

      //instantiate the bytecode
        ByteCode byteCode = (ByteCode) (Class.forName("interpreter.bytecode." + className).newInstance());
        byteCode.init(args);
        program.addByteCode(byteCode);


      //read the next line
      sourceLine = byteSource.readLine();
    }
    program.resolveSymbolicAddress();
    return program;
  }
}