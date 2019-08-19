package com.joysrun.java.compiler.examples;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: sin
 * time: 2019-08-19 14:26
 */
public class JavaCompilerTest {

    @Test
    public void loaderClassTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classPath = "Temp";
        Class tempClass = ToolProvider.getSystemToolClassLoader().loadClass(classPath);
        Object tempObject = tempClass.newInstance();

        for (Method method : tempClass.getDeclaredMethods()) {
            System.err.println(method);
        }

        Method callMethod = tempClass.getMethod("call", String.class);
        callMethod.invoke(tempObject, "哈哈");
    }

    @Test
    public void compilerTest() throws IOException {
        String sourceCode = getSourceCode("Sin");
        String javaPath = "/Users/sin/Downloads/Temp.java";
        FileUtils.writeByteArrayToFile(new File(javaPath), sourceCode.getBytes());
        int result = ToolProvider.getSystemJavaCompiler().run(null, null, null, javaPath);
        System.err.println(result == 0 ? "编译成功" : "编译失败");
    }

    private String getSourceCode(String source) {
        StringBuffer sourceCode = new StringBuffer();
        sourceCode.append("public class Temp {").append("\r\n")
                .append("public static String call(String args) {").append("\r\n")
                .append("System.out.println(\""+source+" args\");").append("\r\n")
                .append("return \"Hello, " + source + "\";").append("\r\n")
                .append("}").append("\r\n")
                .append("}");

        return sourceCode.toString();
    }
}
