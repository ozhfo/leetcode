package util;


import java.util.List;

public class PrintUtil {

    public static void println() {
        System.out.println("----------");
    }

    public static void println(String remark)
    {
        System.out.println("------"+remark+"------");

    }

    public static void bigPrintln(String remark){
        System.out.println("\n---->> "+ remark + " <<----");
    }

    public static void bigPrintln(){
        System.out.println("\n---->> 分割线 <<-----\n");
    }


    /**
     * 类名调用
     * @param a
     */
    public static <T> void println(String remark, T a){
        System.out.println(remark + a);
    }


    public static <T> void printList(List<T> list, String remark) {
        System.out.println("输出：" + remark);
        list.forEach(System.out::println);
    }


    /**
     * 对象调用
     * @param a
     */
    public <T> void  printTWithBlank(T a){
        System.out.print(a + " ");

    }

    /**
     * 类名调用
     * @param a
     */
    public static <T> void staticPrintTWithBlank(T a){
        System.out.print(a + " ");
    }
}
