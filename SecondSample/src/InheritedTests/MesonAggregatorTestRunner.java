package InheritedTests;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class MesonAggregatorTestRunner extends BlockJUnit4ClassRunner {

   public MesonAggregatorTestRunner(final Class<?> klass) throws InitializationError {
      super(klass);
   }
    private FrameworkMethod checkForOpenCLAnnotation(FrameworkMethod method){

    }

   @Override
   protected List<FrameworkMethod> computeTestMethods() {
      // First, get the base list of tests
       final List<FrameworkMethod> allMethods = getTestClass().getAnnotatedMethods(OpenCL.class);
//      final List<FrameworkMethod> allMethods = null; //= getTestClass().getAnnotatedMethods(MyCustomTest.class);
      if (allMethods == null || allMethods.size() == 0)
         return allMethods;

      // Filter the list down
      final List<FrameworkMethod> filteredMethods = new ArrayList<FrameworkMethod>(
            allMethods.size());
      for (final FrameworkMethod method : allMethods) {
         final OpenCLDense customAnnotation = method
               .getAnnotation(OpenCLDense.class);
         if (customAnnotation != null) {
            // Add to accepted test methods, if matching criteria met
            // For example `if(currentOs.equals(customAnnotation.OS()))`
            if(customAnnotation.opecnCL().isEnabled() && customAnnotation.isEnabled()){
               filteredMethods.add(method);
            }
         } else {
            // If test method doesnt have the custom annotation, either add it to
            // the accepted methods, or not, depending on what the 'default' behavior
            // should be
            filteredMethods.add(method);
         }
      }

      return filteredMethods;
   }
}