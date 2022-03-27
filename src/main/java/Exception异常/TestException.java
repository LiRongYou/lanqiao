package Exception异常;

public class TestException {
        /**
         * 获取数组元素数据
         * @param arrays int类型数组
         * @param index 数组下标
         * @throws ArrayIsNullException 数组为空的异常
         */
        public void method1(int[] arrays, int index) throws ArrayIsNullException {
            if (arrays.length == 0) {
                //throw new ArrayIsNullException();
                throw new ArrayIsNullException("数组为空，提取不到下标 " + index + " 的数组元素。");
            }
            System.out.println(arrays[index]);
        }

        public static void main(String[] args) {
            TestException te = new TestException();
            try {
                te.method1(new int[] {}, 2);
            } catch (ArrayIsNullException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 自定义异常类
    class ArrayIsNullException extends Exception{

        /**
         * 无参构造器，传递默认异常信息
         */
        public ArrayIsNullException(){
            super("ArrayIsNullException: 数组长度为 0");
        }

        /**
         * 带异常信息的构造器
         * @param message 异常信息
         */
        public ArrayIsNullException(String message){
            super(message);
        }
    }

