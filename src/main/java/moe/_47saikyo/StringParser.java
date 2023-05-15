package moe._47saikyo;
import java.util.ArrayList;
import java.util.List;

public class StringParser {
    public enum TYPE{Integer,Char,String,Array,Object,Null}

    public static List<String> delimit_Example(String value){
        List<String> ret=new ArrayList<>();
        int i=0,j;
        while (i<value.length()){
            while (i<value.length()&&value.charAt(i)!='='){
                i++;
            }
            i++;
            j=i+1;
            while (j<value.length()&&value.charAt(j)!='='){
                j++;
            }
            while (j<value.length()&&(value.charAt(j)!=']'&&value.charAt(j)!='"')){
                j--;
            }
            if(j<value.length())j++;
            ret.add(value.substring(i,j));
            i=j+1;
        }
        return ret;
    }

    public static List<String> delimit(String value) throws Exception {
        List<String> ret=new ArrayList<>();
        int i,j;
        if(value.charAt(0)=='['){
            if(value.charAt(value.length()-1)!=']'){
                throw new Exception("非法的输入格式");
            }else{
                value=value.substring(1,value.length()-1);
            }
        }
        i=0;
        while (i<value.length()){
            j=i;
            if(value.charAt(i)=='['){
                while (j<value.length()&&value.charAt(j)!=']'){
                    j++;
                }
                j++;
            }else{
                while (j<value.length()&&value.charAt(j)!=','){
                    j++;
                }
            }
            ret.add(value.substring(i,j));
            i=j+1;
        }
        return ret;
    }

    public static TYPE checkType(String value){
        if(value.length()==3&&value.charAt(0)=='\''&&value.charAt(2)=='\''){
            return TYPE.Char;
        }else if(value.charAt(0)=='"'&&value.charAt(value.length()-1)=='"'){
            return TYPE.String;
        }else if(value.charAt(0)=='['&&value.charAt(value.length()-1)==']'){
            return TYPE.Array;
        }else if(value.equals("null")){
            return TYPE.Null;
        }else{
            try{
                Integer.parseInt(value);
                return TYPE.Integer;
            }catch (Exception e){
                return TYPE.Object;
            }
        }
    }

    public static int getInt(String value) throws Exception {
        if(checkType(value)!=TYPE.Integer){
            throw new Exception("非法的数字类型");
        }
        return Integer.parseInt(value);
    }
    public static char getChar(String value) throws Exception {
        if(checkType(value)!=TYPE.Char){
            throw new Exception("非法的字符类型");
        }
        return value.charAt(1);
    }
    public static String getString(String value) throws Exception {
        if(checkType(value)!=TYPE.String){
            throw new Exception("非法的字符串类型");
        }
        return value.substring(1,value.length()-1);
    }
    public static Object[] getArray(List<String> delimited) throws Exception {
        Object[] ret=new Object[delimited.size()];
        TYPE type;

        for (int i=0;i<delimited.size();i++){
            type=checkType(delimited.get(i));
            if(type==TYPE.Null){
                ret[i]=null;
            }else if(type== TYPE.Integer){
                ret[i]=getInt(delimited.get(i));
            }else if(type== TYPE.Char){
                ret[i]=getChar(delimited.get(i));
            }else if(type== TYPE.String){
                ret[i]=getString(delimited.get(i));
            }else if(type== TYPE.Array){
                ret[i]=getArray(delimit(delimited.get(i)));
            }else{
                ret[i]=delimited.get(i);
            }
        }
        return ret;
    }

    public static Object[][] getArrays(List<String> delimited) throws Exception {
        Object[][] ret=new Object[delimited.size()][];
        List<String> list;
        for (int i=0;i<delimited.size();i++){
            list=StringParser.delimit(delimited.get(i));
            ret[i]=StringParser.getArray(list);
        }
        return ret;
    }
}
