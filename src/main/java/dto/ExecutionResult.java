package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Наташа on 04.04.2015.
 */
public class ExecutionResult {
    private Object[] values;

//    public ExecutionResult(Object[] values){
//        this.values = (Object[])values;
//    }

    public ExecutionResult(Object value){
        if(value instanceof Object[]){
            this.values = (Object[])value;
        }else if(value instanceof int[]){
            int[] array = (int[]) value;
            this.values = new Object[array.length];
            for(int i = 0; i < array.length; ++i){
                this.values[i] = new Integer(array[i]);
            }
        }else if(value instanceof char[]){
            char[] array = (char[]) value;
            this.values = new Object[array.length];
            for(int i = 0; i < array.length; ++i){
                this.values[i] = new Character(array[i]);
            }
        }else if(value instanceof boolean[]){
            boolean[] array = (boolean[]) value;
            this.values = new Object[array.length];
            for(int i = 0; i < array.length; ++i){
                this.values[i] = new Boolean(array[i]);
            }
        }else if(value instanceof double[]){
            double[] array = (double[]) value;
            this.values = new Object[array.length];
            for(int i = 0; i < array.length; ++i){
                this.values[i] = new Double(array[i]);
            }
        }else if(value instanceof float[]){
            float[] array = (float[]) value;
            this.values = new Object[array.length];
            for(int i = 0; i < array.length; ++i){
                this.values[i] = new Float(array[i]);
            }
        }
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
