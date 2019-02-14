package com.yydone.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class JoinTask extends RecursiveTask<BigDecimal> {

    private BigDecimal x;
    private BigDecimal y;
    private List<Character> operateList;
    public JoinTask(BigDecimal x, BigDecimal y, List<Character> operateList) {
        this.x = x;
        this.y = y;
        this.operateList = operateList;
    }
    @Override
    protected BigDecimal compute() {
        if(operateList.size()<=1) {
            char operator = operateList.get(0);
            BigDecimal result = operate(x, y, operator);
            //System.out.println(x + " " + operator + " " + y + " = " + result);
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            int middle = operateList.size()/2;
            List<Character> leftList = new ArrayList<>();
            List<Character> rightList = new ArrayList<>();
            for(int i=0; i<operateList.size(); i++) {
                if(i<middle) {
                    leftList.add(operateList.get(i));
                } else {
                    rightList.add(operateList.get(i));
                }
            }
            JoinTask leftTask = new JoinTask(x, y, leftList);
            JoinTask rightTask = new JoinTask(x, y ,rightList);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join().add(rightTask.join());
        }
    }

    private BigDecimal operate(BigDecimal x, BigDecimal y, char operator) {
        BigDecimal result;
        switch (operator) {
            case '+':
                result = x.add(y);
                break;
            case '-':
                result = x.subtract(y);
                break;
            case '*':
                result = x.multiply(y);
                break;
            case '/':
                result = x.divide(y, 0, RoundingMode.FLOOR);
                break;
            default:
                result = BigDecimal.ZERO;
        }
        return result;
    }
}
