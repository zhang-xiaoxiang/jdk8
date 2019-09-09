package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * LambdaTest2 :内置函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author zhangxiaoxiang
 * @date 2019/9/8
 */
public class LambdaTest2 {
    /**
     * 消费型接口 输入参数有因无果,被消费了你说气了不气人
     *
     * @param money
     * @param con
     */
    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * 测试消费型
     */
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费输出:您老消费的价格是" + aDouble);
            }
        });
        System.out.println("********************");
        happyTime(400, money -> System.out.println("消费输出:您老消费的价格是：" + money));
    }

    /**
     * 断定型接口
     * <p>
     * 根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
     *
     * @param list 给定基础数据数据
     * @param pre  断定规则
     * @return
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    /**
     * 测试断定型接口
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrS = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrS);
        List<String> filterStrS1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrS1);
    }
}