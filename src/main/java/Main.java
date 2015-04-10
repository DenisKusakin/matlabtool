import dto.ExecutionResults;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Denis on 28.03.2015.
 */
public class Main {
    public static void main(String[] args){
        FunctionExecuter matlabExecuter = new MatlabExecuter();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                String command = br.readLine();
                System.out.println("command: " + command);
                ExecutionResults result = matlabExecuter.executeFunction(command, 1, 1);
                System.out.println(result.toJSONObject());
            }catch(ExecuteException e){
                System.out.println("Error: " + e.toString());
                return;
            }catch(IOException e){

            }
        }
    }
}
