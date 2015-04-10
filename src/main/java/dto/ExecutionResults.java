package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Наташа on 04.04.2015.
 */
public class ExecutionResults {
    private ExecutionResult[] values;

    public ExecutionResults(Object[] values){
        ExecutionResult[] results = new ExecutionResult[values.length];
        for(int i = 0; i < results.length; i++){
            results[i] = new ExecutionResult(values[i]);
        }
        this.values = results;
    }

    public ExecutionResults(Object value){
        Object[] array = new Object[0];
        array[0] = value;
        new ExecutionResult(array);
    }

    public Object[] getValues(){
        return this.values;
    }

    public String toJSONObject(){
        GsonBuilder gson = new GsonBuilder();
        gson.enableComplexMapKeySerialization();
        Gson g = gson.create();
        return g.toJson(this);
    }
}
