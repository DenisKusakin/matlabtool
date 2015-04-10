import dto.ExecutionResults;

/**
 * Created by Denis on 28.03.2015.
 */
public interface FunctionExecuter {
    ExecutionResults executeFunction(String functionName, int numberOfReturningArguments, Object... arguments) throws ExecuteException;
    void executeCommand(String command) throws ExecuteException;
}
