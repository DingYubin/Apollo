package com.apollo.elegant.experiment;

import com.apollo.elegant.experiment.eInterface.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationImpTest {

    @Test
    void testOperate() {
        OperationImp addOperation = new OperationImp();
        int sum = addOperation.operate(1, 2, (a, b) -> a + b);
        System.out.println(sum);
    }
}