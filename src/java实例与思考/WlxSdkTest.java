package java实例与思考;

import java.util.ArrayList;
import java.util.Date;

import com.tencent.wlxsdk.logic.SDKContext;
import com.tencent.wlxsdk.logic.constant.Constant;
import com.tencent.wlxsdk.logic.entity.OrderInfo;
import com.tencent.wlxsdk.logic.model.BillListModel.BillResult;
import com.tencent.wlxsdk.logic.model.BlackListModel.BlackListResult;
import com.tencent.wlxsdk.logic.model.MacRootKeyModel.MacRootKeyResult;
import com.tencent.wlxsdk.logic.model.PubKeyModel.PubKeyResult;
import com.tencent.wlxsdk.logic.model.ReportOrderModel.ReportOrderResult;

public class WlxSdkTest {
	public static void main(String[] args) {
		
		Constant.DEBUG_TAG = 1;
		//初始化
		String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/yZX6DqUjPUvTptbeqsptfhQIw/qBKoxFFbd9y9g0nmI3ARKcPTpdoC3oDNeqDMd17fkcG1Vph6b6fdQAGQcyMPZbt/C8MRMF/PfY/xGHmO48A4HlYCQY+e2RGqtM91961UrWORvQg5+/h5lfEMVgQkbGxm+qznZXBewUMgUdxQIDAQAB";
		//String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrnFUPueWNY3HLcVf55kXzJDb+ftYINmhde+4EMbKjPY38xaZQk+OjeXykbo8XgIi/xBpRvogWyOwZKOr4kdnV/PdLSoXCrr3DoTRU9INFiOKZPxFY8nYmH6KI4c/z5ooeats8+1bwN5lZdXwXWL/MJA7JrSSSUt0qCwy9MI7+OQIDAQAB";
		String pri_key = "MIICXAIBAAKBgQCrnFUPueWNY3HLcVf55kXzJDb+ftYINmhde+4EMbKjPY38xaZQk+OjeXykbo8XgIi/xBpRvogWyOwZKOr4kdnV/PdLSoXCrr3DoTRU9INFiOKZPxFY8nYmH6KI4c/z5ooeats8+1bwN5lZdXwXWL/MJA7JrSSSUt0qCwy9MI7+OQIDAQABAoGAIL37HL0DJy7KD17Ywj1FK1bFh1j7zSVUVEHI79PrmWmtJYUwbj9JN29+cIEHnBxR+wSXYPFRVceQBFziN/rb7MAS0qNmBxcSzJfqjenoHPZa9smZXpX6W1zHuFTdIloV8juM7ssQyRNRNLSIDs2zZBNXHV6eDqW0cdIJuWaKyYECQQDTkZpgv6531pbytrtWrdgIIjC55YsLZKWv3VqCfvHbhodETA+1EL9y/BV0F0yXE8oDlMbIR99uuU4X24/q93mlAkEAz6Z+1KGqy2twmQ1JRO/8B4zfqgUlitYu41dWu+iHDfTC2ex84BRQdXVND2HGiz/fRB3yubc/WAnToLv/kdTGBQJAcDQnQKpH2CyJj52Ty0uVZ/LiDqULUfaF3LgzWUQD9t3o/TKtneSM9Gl240O8Dd+j4rRTnEJp3+oM3aBHOmEXNQJBAJR5K/7FieXhcKU/BsCwB7kuVU6wV2OqOeR8Mpwxaz/jXt+LZM6kN9OEiBETjG9MwEtoToHUMQq2HAe15MtVJDECQF7lh83AMlL31AtdmFkaHvqu8vrwYiDwqlam+dGADWPG+Cpn7fcXw0wBqRLLMLymz6IAp2mJCN+N7W76j8GP08E=";
		String appid = "20000007";
		SDKContext sdkContext = new SDKContext(appid, pub_key, pri_key);
		//Test DEMO
		//公钥下载
		PubKeyResult pubKeyResult = sdkContext.downloadPubKey();
		if (pubKeyResult.retcode == 0) {
			//表示公钥下载并解析成功
			//TODO 
			System.out.print("公钥解析成功!\n\n");
		}else {
			System.out.format("公钥解析失败-------retcode: %d\nretmsg: %s\n\n", pubKeyResult.retcode, pubKeyResult.retmsg);
		}
		
		//Mackey下载
		
		MacRootKeyResult macKeyResult = sdkContext.downloadMacRootKey();
		if (macKeyResult.retcode == 0) {
			//表示公钥下载并解析成功
			//TODO 
			System.out.print("mac密钥解析成功!\n\n");
		}else {
			System.out.format("mac密钥解析失败-------retcode: %d\nretmsg: %s\n\n", macKeyResult.retcode, macKeyResult.retmsg);
		}
		
		//黑名单下载
		Date start = new Date();
		start.setTime(System.currentTimeMillis()-86400000);
		Date end = new Date();
		end.setTime(System.currentTimeMillis()+86400000);
		BlackListResult blackListResult = sdkContext.downloadBlackList(0, 20, start, end);
		if (blackListResult.retcode == 0) {
			//表示黑名单下载成功
			//TODO
			System.out.print("黑名单解析成功!\n\n");
		}else {
			System.out.format("黑名单解析失败-------retcode: %d\n retmsg: %s\n\n", blackListResult.retcode, blackListResult.retmsg);
		}
		
		//订单上报
		//这里是测试数据造单，开发者需自行拼装订单数据上报，这里演示公交记录单
		ArrayList<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.city_code = "440100"; //城市编号
		orderInfo.in_station_id = 1; //入站站点ID
		orderInfo.in_station_name = "A站点"; //入站站点名称
		orderInfo.mch_trx_id = "780669B272D812C9"; //商户订单流水号
		orderInfo.open_id = "2030B09539E98643"; //由Pos扫码通过底层SDK获取
		orderInfo.order_desc = "订单描述"; //订单描述
		orderInfo.order_time = System.currentTimeMillis()/1000; //订单生成时间
		orderInfo.out_station_id = 2; //出站站点ID
		orderInfo.out_station_name = "B站点"; //出站站点名称
		orderInfo.pay_fee = 1; //实际支付金额
		orderInfo.total_fee = 1; //总金额
		orderInfo.charge_type = 0; //计费类型：0：单次计费；1：分段计费
		orderInfo.exp_type = 0; //订单类型：0：正常单；1：入站单边账；2：出站单边账
		orderInfo.record.add("AAEBAVVUtqoDvDZS7qvffGtp7J0XBnGGGFr5m/GGqoj0ddS1uHc/x4R+y44gq+Mn8rRUOENEmCndgA3+kvL9BUwpM/RlVjV1O03rDxBlBn48EdB6zu0e1vS0mIAwJoKPV0OPE3zxG2yFxolJb9cGQLQMUVhO8/Vs3mv0NcA=");
		orderInfos.add(orderInfo);
		ReportOrderResult reportOrderResult = sdkContext.reportOrder(orderInfos);
		if (reportOrderResult.retcode == 0) {
			//订单上报成功
			//TODO
			System.out.print("订单上报解析成功！\n\n");
		}else {
			System.out.format("订单上报解析失败-------retcode: %d\nretmsg: %s\n\n", reportOrderResult.retcode, reportOrderResult.retmsg);
		}
		
		//对账单下载
		Date tt = new Date();
		tt.setTime(System.currentTimeMillis() - 24*3600*1000);
		BillResult billResult = sdkContext.downloadBills(tt, 0, 20);
		if (billResult.retcode == 0) {
			//对账单下载成功
			//TODO
			System.out.print("对账单解析成功!\n\n");
		}else {
			System.out.format("对账单解析失败--------retcode: %d\nretmsg: %s\n\n", billResult.retcode, billResult.retmsg);
		}
	}
}
