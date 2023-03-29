package Solutions;

import java.util.ArrayList;
import java.util.List;

public class UnreliableMemoryCleanupExample {
    public static void main(String[] args) {
        List<BigObject> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            BigObject obj = new BigObject();
            obj.setValue(i);
            list.add(obj);
        }

        // 清除对象引用，等待垃圾回收
        list = null;

        // 垃圾回收可能不会立即发生，因此暂停一段时间
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted.");
//            e.printStackTrace();
//        }

        // 创建新的对象，占用之前list中的内存空间
        BigObject newObj = new BigObject();
        newObj.setValue(999);

        // 可能会出现已被回收的内存空间被重新使用，从而导致newObj的值覆盖掉之前list中的某个对象的值
        System.out.println(list.get(5).getValue());
    }

    static class BigObject {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

