package customRunner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class MyCustomTestRunner extends BlockJUnit4ClassRunner {

   public MyCustomTestRunner(final Class<?> klass) throws InitializationError {
      super(klass);
   }


   @Override
   protected List<FrameworkMethod> computeTestMethods() {
      // First, get the base list of tests
       final List<FrameworkMethod> allMethods = getTestClass().getAnnotatedMethods(MyCustomAnnotation.class);
//      final List<FrameworkMethod> allMethods = null; //= getTestClass().getAnnotatedMethods(MyCustomTest.class);
      if (allMethods == null || allMethods.size() == 0)
         return allMethods;

      // Filter the list down
      final List<FrameworkMethod> filteredMethods = new ArrayList<FrameworkMethod>(
            allMethods.size());
      for (final FrameworkMethod method : allMethods) {
         final MyCustomAnnotation customAnnotation = method
               .getAnnotation(MyCustomAnnotation.class);
         if (customAnnotation != null) {
            // Add to accepted test methods, if matching criteria met
            // For example `if(currentOs.equals(customAnnotation.OS()))`
            filteredMethods.add(method);
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