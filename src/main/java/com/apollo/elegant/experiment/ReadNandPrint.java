package com.apollo.elegant.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 某些数据库读写框架，为了提升性能，会控制每次读取的数据量，并支持从指定的位置开始读。
 *
 * 请写代码，从标准输入获得全量数据，并从标准输入获取读取指令，包括开始读取的位置(从1开始)，读取
 * 的数据量，并返回读取到的数据。
 *
 * 每次返回数据不超过20个，如果读取指令中要求的数据量超过20个则分多次返回。
 * 如果读取指令中要求的数据量超过实际数据量，则按实际数据量处理。
 * 输入描述
 * 第一行：构造全量数据，空格分隔，数据是字符串形式
 * 第二行：读取指令，包括开始读取的位置，读取的数据量，空格分隔
 * 输出描述:
 * 返回读取到的数据，分号分隔，超过20个则换行
 *
 * 输入
 * 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3
 * 2 22
 * 输出
 * 2;3;4;5;6;7;8;9;0;1;2;3;4;5;6;7;8;9;0;1
 * 2;3
 */
public class ReadNandPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println();
            }else {
                Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt);
                int[] nums = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                String[] params = sc.nextLine().split("");
                int start = Integer.parseInt(params[0]);
                int size = Integer.parseInt(params[1]);
                solution(nums, start, size);
            }
        }
        sc.close();
    }

    private static void solution(int[] nums, int start, int size) {
        if (start > nums.length) return;
        ArrayList<Integer> readnums = new ArrayList<>();
        int count = 0;
        for (int i = start - 1; i < nums.length; i++) {
            if (count < size) {
                readnums.add(nums[i]);
                count += 1;
            }
        }
        int temp = 0;
        while (temp < readnums.size()) {
            System.out.print(readnums.get(temp));
            temp++;
            if (temp % 20 != 0 && temp != readnums.size()) {
                System.out.print(";");
            } else {
                System.out.println();
            }
        }
    }
}
