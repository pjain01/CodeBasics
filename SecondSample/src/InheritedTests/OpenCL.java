package InheritedTests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**What we want is , if OpenCL is disabled then OpenCLDense, OpenCLDense, OpenCLStatic and OpenCLMutable should be diabled by default***/
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OpenCL {
    boolean isEnabled();
} 