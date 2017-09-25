package customRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyCustomTestRunner.class)

public class MyCustomTest {
   public MyCustomTest() {
      super();
   }

   @Test
   @MyCustomAnnotation(OS = "Mac")
   public void testCustomViaAnnotation() {
      return;
   }

}