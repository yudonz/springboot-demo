package com.example.demo.牛客;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class test333 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if (n == 0) {
            return;
        }
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int abc = in.nextInt();
            Product product = new Product();
            product.setP(abc);
            product.setIndex(i);
            list.add(product);
        }
        for (int i = 0; i < n; i++) {
            int abc = in.nextInt();
            if (abc == 1) {
                list.get(i).setA(1);
            } else if (abc == 2) {
                list.get(i).setB(2);
            } else if (abc == 3) {
                list.get(i).setC(3);
            }
        }
        for (int i = 0; i < n; i++) {
            int abc = in.nextInt();
            if (abc == 1) {
                list.get(i).setA(1);
            } else if (abc == 2) {
                list.get(i).setB(2);
            } else if (abc == 3) {
                list.get(i).setC(3);
            }
        }
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int abc = in.nextInt();
            arr[i] = abc;
        }

        //打印数组
        for (int i = 0; i < m; i++) {
            System.out.println(arr[i]);
        }
        //打印产品
        for (Product p : list) {
            System.out.println(p);
        }
        String str = null;
        //开始执行
        for (int i = 0; i < m; i++) {
            if (arr[i] == 1) {
                Integer price = null;
                List<Product> temp = list.stream().filter(p -> p.getA() != null).collect(Collectors.toList());
                if (temp != null && temp.size() > 0) {
                    price = temp.stream().map(p -> p.getP()).min(Integer::compareTo).get();
                    for (Product product : list) {
                        if (product.getP() == price && product.getA() != null) {
                            product.setA(null);
                            product.setB(null);
                            product.setC(null);
                            break;
                        }
                    }
                } else {
                    price = -1;
                }
                str = str == null ? price.toString() : str + " " + price;
            } else if (arr[i] == 2) {
                Integer price = null;
                List<Product> temp = list.stream().filter(p -> p.getB() != null).collect(Collectors.toList());
                if (temp != null && temp.size() > 0) {
                    price = temp.stream().map(p -> p.getP()).min(Integer::compareTo).get();
                    for (Product product : list) {
                        if (product.getP() == price && product.getB() != null) {
                            product.setA(null);
                            product.setB(null);
                            product.setC(null);
                            break;
                        }
                    }
                } else {
                    price = -1;
                }
                str = str == null ? price.toString() : str + " " + price;
            } else if (arr[i] == 3) {
                Integer price = null;
                List<Product> temp = list.stream().filter(p -> p.getC() != null).collect(Collectors.toList());
                if (temp != null && temp.size() > 0) {
                    price = temp.stream().map(p -> p.getP()).min(Integer::compareTo).get();
                    for (Product product : list) {
                        if (product.getP() == price && product.getC() != null) {
                            product.setA(null);
                            product.setB(null);
                            product.setC(null);
                            break;
                        }
                    }
                } else {
                    price = -1;
                }
                str = str == null ? price.toString() : str + " " + price;
            }

        }
        System.out.println(str);

    }
}

class Product {
    private Integer index;
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer p;

    public Product() {
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Product{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", p=" + p +
                '}';
    }
}
