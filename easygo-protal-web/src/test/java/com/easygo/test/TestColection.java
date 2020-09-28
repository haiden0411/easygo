package com.easygo.test;

import com.easygo.pojo.JsonObject;
import com.easygo.pojo.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author：胡灯
 * Date：2020-09-26 20:49
 * Description：<描述>
 */
public class TestColection {

    List<Product> list1 = new ArrayList<>();
    List<Product> list2 = new ArrayList<>();
    @Before
    public void setup(){

        Product aa = new Product(1, "aa", 1L, 3.5, 1 * 3.5);
        Product bb = new Product(2, "bb", 2L, 4.5, 2*4.5);
        Product cc = new Product(3, "cc", 3L, 5.5, 3*5.5);
        Product dd = new Product(4, "dd", 2L, 6.5, 2*6.5);
        Product ee = new Product(5, "ee", 3L, 6.5, 3*6.5);
        Product ff = new Product(6, "ff", 2L, 5.0, 2*5.5);
        Product gg = new Product(7, "gg", 2L, 10.0, 2*10.0);
        Product hh = new Product(8, "hh", 2L, 6.5, 2*6.5);
        Product kk = new Product(2, "bb", 11L, 4.5, 11*4.5);
        Product mm = new Product(4, "dd", 20L, 6.5, 20*6.5);

        list1.add(aa);
        list1.add(bb);
        list1.add(cc);
        list1.add(dd);
        list1.add(ee);

        list2.add(cc);
        list2.add(mm);
        list2.add(ee);
        list2.add(ff);
        list2.add(gg);
        list2.add(hh);
        list2.add(kk);

    }


    @Test
    public void testColection(){

        List<Product> all = new ArrayList<>();
        List<Product> combine = combine(list1, list2);
        System.out.println("combine:");


        all.addAll(combine);
        all.forEach(System.out::println);


    }

    @Test
    public void testpythagoreanTriples(){

        List<double[]> collect = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}))
                .filter(t -> t[2] % 1 == 0).limit(10).collect(Collectors.toList());
        collect.forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));

    }

    @Test
    public void testgroupBy(){
        List<Product> all = new ArrayList<>();
        all.addAll(list1);
        all.addAll(list2);
        List<Product> all_new = new ArrayList<>();
        all.stream().collect(Collectors.groupingBy(Product::getId)).forEach((integer, products) -> {
            products.stream()
                    .reduce((p1, p2) -> new Product(integer,p1.getName(),p1.getSum()+p2.getSum(),p1.getPrice(),p1.getPrice()*(p1.getSum()+p2.getSum()))).ifPresent(all_new::add);
        });

        all_new.forEach(System.out::println);

    }

    private List<Product> combine(List<Product> list1,List<Product> list2){
        List<Product> collect = list1.stream()
                .flatMap(p1 ->
                        list2.stream().filter(p2 -> p1.getId().toString().equals(p2.getId().toString())).map(product -> {
                            product.setSum(p1.getSum() + product.getSum());
                            product.setId(p1.getId());
                            product.setPrice(p1.getPrice());
                            product.setName(p1.getName());
                            product.setTotal_fre(product.getSum() * product.getPrice());
                            return product;
                        })
                ).collect(Collectors.toList());
        return collect;
    }
}
