package com.apollo.elegant.experiment;

import com.apollo.elegant.experiment.eInterface.Creater;
import com.apollo.elegant.experiment.eInterface.Operation;
import com.apollo.elegant.experiment.eInterface.OperationInt;

/**
 * 其实上面三种方法引用都好理解，最后类的实例方法引用，有两个条件：
 *
 * 首先要满足实例方法，而不是静态方法
 * Lambda 表达式的第一个参数会成为调用实例方法的对象 根据这两点我们看上面的例子，
 * test 方法接受一个 TestInt 实例，用 Lambda 表达式表示就是 (Test t1, Test t2) -> res，
 * 而我们调用 test 方法时传入的方法引用是 Test::testM，
 * 其参数也是一个 Test 实例，最终 test.test(Test::testM) 的调用效果就是 t1.testM(t2)
 */
public class OperationImp {

    public static OperationImp create(Creater<OperationImp> crater) {
        return crater.get();
    }

    /**
     * Lambda
     */
    public int operate(int a, int b, Operation operation) {
        return operation.operation(a,b);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int operationM(OperationImp operationImp) {
        return 0;
    }

    /**
     * Method Reference ::
     */
    public void operate(OperationInt operationInt) {
        /**
         * 回调 lambda表达式
         */
        OperationImp operation = new OperationImp();
        operation.operate(1, 2, (a, b) -> a + b);

        /**
         * 构造方法引用
         * 使用方式: Class::new
         */
        OperationImp operationA = OperationImp.create(OperationImp::new);
        OperationImp operationB = OperationImp.create(OperationImp::new);
        operationInt.cp(operationA, operationB);

        /**
         * 静态方法引用
         * 使用方式：Class::staticMethod
         */
        operationA.operate(1,2, OperationImp::add);

        /**
         * 对象调实例方法引用
         * 使用方式：instance::method
         */
        operationA.operate(1,2, operationA::sub);

        /**
         * 类的实例方法引用
         * 使用方式：Class::method
         */
        operationA.operate((operationA1, operationB1) -> 0);
        operationA.operate(OperationImp::operationM);
    }

}
