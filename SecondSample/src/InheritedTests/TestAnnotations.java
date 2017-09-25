package InheritedTests;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MesonAggregatorTestRunner.class)
public class TestAnnotations {

    @Test
    public void test1(){
        return;
    }

    @Test
    @OpenCLDense(isEnabled = false , opecnCL =  @OpenCL(isEnabled = true))
    //@SubAnnotation(subValue = "...", superAnnotation = @SuperAnnotation(value = "superValue"))
    public void test2(){
        //how to access annotations values at this point ??
    }

    @Test
    @OpenCLDense(isEnabled = true , opecnCL =  @OpenCL(isEnabled = true))
    //@SubAnnotation(subValue = "...", superAnnotation = @SuperAnnotation(value = "superValue"))
    public void test3(){
        //how to access annotations values at this point ??
    }
}
