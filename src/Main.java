import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<?> cl = SumTest.class;
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test tA = method.getAnnotation(Test.class);
                try {
                    int result = (int) method.invoke(null, tA.a(), tA.b());
                    System.out.println(result);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}