package com.zjjz.ucenter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZjUcenterApplicationTests {

    @Test
    public void contextLoads() {
        String s = DigestUtils.md5DigestAsHex("021033".getBytes());
        System.out.println(s);
        String s2 = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s2);
    }

}
