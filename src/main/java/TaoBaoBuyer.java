import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 用Java实现淘宝秒杀自动化
 *
 * @author BeamStark
 * @date 2022-10-08-08:58
 */
@Slf4j
public class TaoBaoBuyer {
    //抢购时间
    private static final String ShoppingTime = "2023-10-09 18:01:00";

    //预期价格
    static final Integer price = 23;

    public static void main(String[] args) throws InterruptedException {
        log.info("开始时间：" + LocalDateTime.now());
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait15s = new WebDriverWait(chromeDriver, 15000);
//        先登录
        chromeDriver.get("https://login.taobao.com/member/login" +
                ".jhtml?f=top&redirectURL=http%3A%2F%2Fwww.taobao.com%2F/");
        chromeDriver.findElementByXPath("/html/body/div/div[2]/div[3]/div/div/div/div[1]/i").click();
        log.info("等待登录...");
//        进入购物车
        wait15s.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div" +
                "[1" +
                "]/div/ul[2]/li[3]/div[1]/a/span[2]"))).click();
//        选中购物车的第一个
        wait15s.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div" +
                "[3]/div/div/div[2]/div[2]/div[1" +
                "]/div/div[1]/div/div/label"))).click();

        log.info("购买 {}...",
                chromeDriver.findElements(By.className("item-basic-info")).get(0).getText());
        log.info("选中，等待下单...");
//        等待下单
        while (true) {
            if (LocalDateTime.now().isAfter(LocalDateTime.parse(ShoppingTime,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))) {

                double num = Double.parseDouble(chromeDriver.findElement(By.className("realpay--price")).getText());
                int realPrice = (int) Math.round(num);
                if (realPrice <= price) {
                    // 结算！
                    chromeDriver.findElementByClassName("btn-area").click();
                    log.info("结算");
//              锁单
//                滚动到最下
                    chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                    wait15s.until(ExpectedConditions.presenceOfElementLocated(By.className("go-btn"))).click();
                    log.info("锁单");
                    System.out.println("下单成功，去支付吧! 完成时间：" + LocalDateTime.now());
                    break;
                }
            }
        }
//      5秒后关闭
        Thread.sleep(5000);
        chromeDriver.quit();
    }
}
