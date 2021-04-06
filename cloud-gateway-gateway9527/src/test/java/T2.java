import java.time.ZonedDateTime;

/**
 * @author egbz
 * @date 2021/4/6
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();  // 默认时区
        System.out.println(time);

//        2021-04-06T23:01:07.609807+08:00[Asia/Shanghai]
    }
}
