package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        List<String> objects = new ArrayList<>();
        StringTokenizer split = new StringTokenizer(signatureString, "(, )");
        while(split.hasMoreTokens()){
            objects.add(split.nextToken());
        }
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        MethodSignature signature;
        if(objects.get(0).equals("public") || objects.get(0).equals("protected") || objects.get(0).equals("private")){
            for(int i = 3; i < objects.size(); i+=2){
                arguments.add(new MethodSignature.Argument(objects.get(i), objects.get(i + 1)));
            }
            signature = new MethodSignature(objects.get(2), arguments);
            signature.setAccessModifier(objects.get(0));
            signature.setReturnType(objects.get(1));
        } else {
            for(int i = 2; i < objects.size(); i+=2){
                arguments.add(new MethodSignature.Argument(objects.get(i), objects.get(i + 1)));
            }
            signature = new MethodSignature(objects.get(1), arguments);
            signature.setReturnType(objects.get(0));
        }
        return signature;
    }
}
