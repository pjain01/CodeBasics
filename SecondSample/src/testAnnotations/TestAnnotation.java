package testAnnotations;

import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main(String[] args) {

        AnnotationRunner runner = new AnnotationRunner();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            RunAnnotation run = method.getAnnotation(RunAnnotation.class);
            if (run != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 