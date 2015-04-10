import dto.ExecutionResults;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;

import java.io.File;

/**
 * Created by Denis on 28.03.2015.
 */
public class MatlabExecuter implements FunctionExecuter {
    private MatlabProxy proxy;

    public ExecutionResults executeFunction(String functionName, int numberOfReturningArguments,
                                    Object... arguments) throws ExecuteException {
        Object[] executionResult;
        try {
            executionResult = proxy.returningFeval(functionName, numberOfReturningArguments, arguments);
        } catch (Exception e) {
            throw new ExecuteException(e.getMessage());
        }
        return new ExecutionResults(executionResult);
    }

    public void executeCommand(String command) throws ExecuteException{
        try{
            proxy.eval(command);
        }catch(Exception e){
            throw new ExecuteException(e.getMessage());
        }
    }

    public MatlabExecuter() {
        setProxy(null);
    }

    public MatlabExecuter(String matlabProgrammPath) {
        setProxy(matlabProgrammPath);
    }

    private void setProxy(String matlabFolderPath) {
        MatlabProxyFactory factory = new MatlabProxyFactory(getMatlabProxyOptions());
        proxy = null;
        try {
            proxy = factory.getProxy();
            if(!(matlabFolderPath == null || matlabFolderPath.isEmpty())){
                addFoldersToPath(matlabFolderPath);
            }
        } catch (Exception e) {

        }
    }

    private MatlabProxyFactoryOptions getMatlabProxyOptions() {
        MatlabProxyFactoryOptions options;
        MatlabProxyFactoryOptions.Builder builder = new MatlabProxyFactoryOptions.Builder();
        builder.setHidden(true);
        //builder.setMatlabStartingDirectory(getMatlabFolder(matlabFolderPath));
        builder.setUsePreviouslyControlledSession(true);
        options = builder.build();

        return options;
    }

    private File getMatlabFolder(String path) {
        File dir = new File(path);
        return dir;
    }

    private void addFoldersToPath(String rootPath) throws ExecuteException{
        if(rootPath == null || rootPath.isEmpty()){
            return;
        }
        try{
            proxy.eval("addpath(genpath('" + rootPath + "'))");
        }catch(Exception e){
            throw new ExecuteException(e.getMessage());
        }
    }
}
