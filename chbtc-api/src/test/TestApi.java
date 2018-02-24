import com.licc.btc.chbtcapi.ChbtcApi;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import org.junit.Test;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2018/2/24 14:26
 * @see
 */
public class TestApi {

  /**
   * 测试行情交易接口
   */
 @Test
 public  void testDataTicker(){
   TickerApiRes tickerApiRes = ChbtcApi.ticker(ETradeCurrency.ZB_QC);
   System.out.println(tickerApiRes);

 }

}
