package java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *     大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 */
public class ConstructorRefTest {
    /**
     * 构造器引用 Supplier中的T get() Employee的空参构造器：Employee()
     */
    @Test
    public void test1(){
        //Supplier 供给型接口
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("*******************");
        //这里没有入参,所以()可以省略,new Employee()属于构造对象,返回值是固定的,所以这里其实只要知道调用的构造方法就行了
        Supplier<Employee>  sup1 = () -> new Employee();
        System.out.println(sup1.get());
        System.out.println("*******************");
        //这是上面优化后的构造器调用(和方法引用确实很相似哈)
        Supplier<Employee>  sup2 = Employee:: new;
        System.out.println(sup2.get());
    }

    /**
     * Function中的R apply(T t) 函数形接口
     */
    @Test
    public void test2(){
        Function<Integer, Employee> func1 = id -> new Employee(id);
        Employee employee = func1.apply(1001);
        System.out.println(employee);
        System.out.println("*******************");
        Function<Integer, Employee> func2 = Employee:: new;
        Employee employee1 = func2.apply(1002);
        System.out.println(employee1);
    }

    /**
     * BiFunction中的R apply(T t,U u)  函数形接口
     */
    @Test
    public void test3(){
        BiFunction<Integer,String, Employee> func1 = (id, name) -> new Employee(id,name);
        System.out.println(func1.apply(1001,"Tom"));
        System.out.println("*******************");
        BiFunction<Integer,String, Employee> func2 = Employee:: new;
        System.out.println(func2.apply(1002,"Tom"));

    }

    /**
     * Function中的R apply(T t) 数组引用
     */
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));
        System.out.println("*******************");
        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));

    }
}
