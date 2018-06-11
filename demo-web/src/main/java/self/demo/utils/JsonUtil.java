/**
 * 
 */
package self.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;


/**
 * @author liufei45
 *
 */
public class JsonUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonStr = "{ \"analyzeException\": false, \"checkPoint\" : \"cp_pay_quick_result\", \"consultResult\": { \"data\": { }, \"msg\": \"拒绝\", \"status\": 4001 }, \"dataSource\": 2, \"id\": \"ec72b9f4a52b4b1fa4e13c01414972b1\", \"intercept\": true, \"matchRouter\": \"name=router_pay_quick_result,rule=B-CF-105,rule=ZF-SC-002,rule=B-SK-003,rule=B-SK-005,rule=B-CF-104,rule=B-CF-100-1,rule=B-SK-001,rule=B-CF-102,rule=ZF-SC-003,rule=B-CF-103,rule=B-SK-004,rule=B-CF-101,rule=ZF-041,rule=B-SK-002\", \"modelResultList\": { }, \"parameters\": { \"checkpoint\": \"cp_pay_quick_result\", \"messageTime\": 1502268042928, \"idCard\": \"360124198703285167\", \"payInstructId\": \"20170809164042081275939\", \"discountAmount\": 0, \"devInfo\": \"{\\\"IMEI\\\":\\\"863707038144735\\\",\\\"IP\\\":\\\"192.168.1.101\\\",\\\"cell_id\\\":\\\"null\\\",\\\"device_desc\\\":\\\"vivo Y55A\\\",\\\"device_id\\\":\\\"8ede8c7ff6d101d1\\\",\\\"gmtTime\\\":\\\"2017-08-09 16:40:41\\\",\\\"imsi\\\":\\\"460022070401920\\\",\\\"mac\\\":\\\"54:19:c8:32:64:14\\\",\\\"merchantAppId\\\":\\\"feifan001\\\",\\\"network\\\":\\\"Wifi\\\",\\\"os_type\\\":\\\"android\\\",\\\"os_version\\\":\\\"Android6.0.1\\\",\\\"phoneModel\\\":\\\"vivo Y55A\\\",\\\"phone_wifi_mac\\\":\\\"54:19:c8:32:64:14\\\",\\\"size\\\":\\\"720 * 1280\\\",\\\"sourceFrom\\\":\\\"APP\\\",\\\"wifi\\\":\\\"DNF\\\"}\", \"siedc\": \"17cd3e510c9742d8a4841f66a7595f8e\", \"deviceId\": \"8ede8c7ff6d101d1\", \"responseCode\": \"0000\", \"activityId\": 0, \"payPlatformType\": 1001, \"phoneModel\": \"vivo Y55A\", \"tradeScene\": 3, \"eventTime_Date\": \"2017-08-09\", \"gmtTime\": \"2017-08-09 16:40:41\", \"payCreateTime\": 1502268035000, \"siedc64\": \"a0488c4410f06765a27c52915bfc8ce11170c1d530e2571806c595784022d48a\", \"cell_id\": \"null\", \"memberId\": \"15000000155678474\", \"d_uid_isBlack\": false, \"wifi\": \"DNF\", \"orderNo\": \"50542943318474\", \"eventTime_String\": \"2017-08-09 16:40:45\", \"payOrderNo\": \"17080916403519526036\", \"device_id\": \"8ede8c7ff6d101d1\", \"eventIntercept\": true, \"ip\": \"218.95.29.157\", \"IP\": \"192.168.1.101\", \"eventUuid\": \"ec72b9f4a52b4b1fa4e13c01414972b1\", \"size\": \"720 * 1280\", \"os_type\": \"android\", \"status\": 1, \"encryptBankCardNo\": \"622848*********5972\", \"eventTime_Long\": 1502268045435, \"systemTimeInterval\": 4, \"memberName\": \"朱玲玲\", \"imsi\": \"460022070401920\", \"mac\": \"54:19:c8:32:64:14\", \"siedcIsSimulate\": \"0\", \"network\": \"Wifi\", \"uid\": \"15000000155678474\", \"merchantAppId\": \"feifan001\", \"puid\": \"B2CAFA3570C049CDA999C37B25056346\", \"requestRandom\": 6, \"device_desc\": \"vivo Y55A\", \"logId\": 30530032, \"phone_wifi_mac\": \"54:19:c8:32:64:14\", \"siedcParseErrorCode\": \"0\", \"sourceFrom\": \"APP\", \"newBankCardNo\": \"6228485972_360124198703285167\", \"amount\": 100, \"d_uid_isWhite\": false, \"payFinishTime\": 1502268042928, \"os_version\": \"Android6.0.1\", \"cardType\": 2, \"IMEI\": \"863707038144735\", \"payChannelType\": \"2\", \"createTime\": 1502268045433, \"eventStatus\": -1, \"d_common_isPlaceIp\": false, \"orderCode\": 7010, \"partnerId\": 101, \"businessType\": 2, \"activityType\": 1 }, \"returnCode\": { \"code\": 4001, \"msg\": \"拒绝\", \"priority\": 100 }, \"ruleResultList\": { \"ZF-041\": { \"conditionInfos\": [ { \"conditionName\": \"c_scanCode_storeId_2_eventUuid_cnt_curday_up\", \"leftKey\": \"d_scanCode_storeId_2_eventUuid_cnt_curday\", \"leftType\": \"INDICATOR\", \"leftValue\": 0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 5 } ], \"id\": 280, \"isWarning\": false, \"name\": \"ZF-041\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-SK-004\": { \"conditionInfos\": [ { \"conditionName\": \"c_TradeScene_storeId_eventUuid_cnt_lastDay_10_up\", \"leftKey\": \"d_TradeScene_storeId_eventUuid_cnt_lastDay\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 10 } ], \"id\": 271, \"isWarning\": false, \"name\": \"B-SK-004\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-SK-005\": { \"conditionInfos\": [ { \"conditionName\": \"c_TradeScene_storeId_eventUuid_cnt_lastDay_10_up\", \"leftKey\": \"d_TradeScene_storeId_eventUuid_cnt_lastDay\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 10 } ], \"id\": 273, \"isWarning\": false, \"name\": \"B-SK-005\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"ZF-SC-003\": { \"conditionInfos\": [ { \"conditionName\": \"c_common_regDivPayTime_onHour\", \"leftKey\": \"d_common_regDivPayTime\", \"leftType\": \"INDICATOR\", \"leftValue\": 1483507839000, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 3600000 } ], \"id\": 288, \"isWarning\": false, \"name\": \"ZF-SC-003\", \"result\": false, \"ruleCategoryDesc\": \"银行卡盗用\", \"ruleCategoryName\": \"CARD_THEFT\", \"status\": \"ONLINE\" }, \"B-SK-002\": { \"conditionInfos\": [ { \"conditionName\": \"c_TradeScene_storeId_eventUuid_cnt_1d_up\", \"leftKey\": \"d_TradeScene_storeId_eventUuid_cnt_1d\", \"leftType\": \"INDICATOR\", \"leftValue\": 0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 30 } ], \"id\": 256, \"isWarning\": false, \"name\": \"B-SK-002\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"ZF-SC-002\": { \"conditionInfos\": [ { \"conditionName\": \"c_cardPhoneNoMatch_uid_1_eventUuid_cnt_curday_up\", \"leftKey\": \"d_cardPhoneNoMatch_uid_1_eventUuid_cnt_curday\", \"leftType\": \"INDICATOR\", \"leftValue\": 0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 0 } ], \"id\": 286, \"isWarning\": false, \"name\": \"ZF-SC-002\", \"result\": false, \"ruleCategoryDesc\": \"银行卡盗用\", \"ruleCategoryName\": \"CARD_THEFT\", \"status\": \"ONLINE\" }, \"B-SK-003\": { \"conditionInfos\": [ { \"conditionName\": \"c_TradeScene_storeId_eventUuid_cnt_1d_50up\", \"leftKey\": \"d_TradeScene_storeId_eventUuid_cnt_1d\", \"leftType\": \"INDICATOR\", \"leftValue\": 0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 50 } ], \"id\": 266, \"isWarning\": false, \"name\": \"B-SK-003\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-SK-001\": { \"conditionInfos\": [ { \"conditionName\": \"c_TradeScene_storeId_eventUuid_cnt_lastDay_up\", \"leftKey\": \"d_TradeScene_storeId_eventUuid_cnt_lastDay\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 50 } ], \"id\": 272, \"isWarning\": false, \"name\": \"B-SK-001\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-101\": { \"conditionInfos\": [ { \"conditionName\": \"c_BpartRsAll_storeId_1_eventUuid_cnt_1d_100_up\", \"leftKey\": \"d_BpartRsAll_storeId_1_eventUuid_cnt_1d\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 100 } ], \"id\": 278, \"isWarning\": false, \"name\": \"B-CF-101\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-100-1\": { \"conditionInfos\": [ { \"conditionName\": \"c_onePay_storeId_uid_1_eventUuid_cnt_curday_up\", \"leftKey\": \"d_onePay_storeId_uid_1_eventUuid_cnt_curday\", \"leftType\": \"INDICATOR\", \"leftValue\": 28, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 30 } ], \"id\": 308, \"isWarning\": false, \"name\": \"B-CF-100-1\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-104\": { \"conditionInfos\": [ { \"conditionName\": \"c_BpartRsAll_storeId_1_eventUuid_cnt_50_lastDay_up\", \"leftKey\": \"d_BpartRsAll_storeId_1_eventUuid_cnt_lastDay\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 50 } ], \"id\": 279, \"isWarning\": false, \"name\": \"B-CF-104\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-105\": { \"conditionInfos\": [ { \"conditionName\": \"c_BpartRsAbnormalAll_storeId_1_eventUuid_persent_1d_up\", \"leftKey\": \"d_BpartRsAbnormalAll_storeId_1_eventUuid_persent_1d\", \"leftType\": \"INDICATOR\", \"leftValue\": 0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 0.6 } ], \"id\": 277, \"isWarning\": false, \"name\": \"B-CF-105\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-102\": { \"conditionInfos\": [ { \"conditionName\": \"c_BpartRsAll_storeId_uid_amount_amt_600s_up\", \"leftKey\": \"d_BpartRsAll_storeId_uid_amount_amt_600s\", \"leftType\": \"INDICATOR\", \"leftValue\": 920.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 2000000 }, { \"conditionName\": \"c_BpartRsAll_storeId_uid_times_cnt_600s_up\", \"leftKey\": \"d_BpartRsAll_storeId_uid_times_cnt_600s\", \"leftType\": \"INDICATOR\", \"leftValue\": 12.0, \"result\": true, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 10 } ], \"id\": 274, \"isWarning\": false, \"name\": \"B-CF-102\", \"result\": true, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" }, \"B-CF-103\": { \"conditionInfos\": [ { \"conditionName\": \"c_BpartRs_storeId_1_eventUuid_cnt_300s_up\", \"leftKey\": \"d_BpartRs_storeId_1_eventUuid_cnt_300s\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 20 }, { \"conditionName\": \"c_BpartRs_storeId_1_amount_sum_300s_up\", \"leftKey\": \"d_BpartRs_storeId_1_amount_sum_300s\", \"leftType\": \"INDICATOR\", \"leftValue\": 0.0, \"result\": false, \"rightKey\": \"\", \"rightType\": \"MANU\", \"rightValue\": 3000000 } ], \"id\": 275, \"isWarning\": false, \"name\": \"B-CF-103\", \"result\": false, \"ruleCategoryDesc\": \"其他\", \"ruleCategoryName\": \"OTHER\", \"status\": \"ONLINE\" } } } ";
;
        jsonStr ="{\"page_size\":0,\"checkPoint1\": \" :cp_pay_quick_result2: \",\"page_index\" : 0 "
        		+ ",\"page_count\":0,\"has_next\":false,\"datas\":null,\"code\":0,\"issuccess\":true,"
        		+ "\"checkPoint\" : \"cp_ pay_quick_result \"}";
		long startTime = System.currentTimeMillis(); // 获取开始时间
		String rv = getValue2(jsonStr, "checkPoint");
		System.out.println("***/ methodName：getValue 程序运行时间： " + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("returnValue:"+rv);
		rv = getValue2(jsonStr, "checkPoint1");
		System.out.println("returnValue2:"+rv);
		rv = getValue2(jsonStr, "page_index");
		System.out.println("returnValue3:"+rv);
		startTime = System.currentTimeMillis(); // 获取开始时间
		JSONObject jsonOb= JSONObject.parseObject(jsonStr);
		rv = jsonOb.getString("checkPoint");
		System.out.println("***/ methodName：JSONObject.parseObject 程序运行时间： " + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("returnValue:"+rv);
		
	}
	
	public static String getValue(String jsonStr,String key){
		String returnValue  ="";
		String regex = "(?<=\"" + key + "\":)(.*?),";
		Matcher matcher=Pattern.compile(regex).matcher(jsonStr);  
		if(matcher.find()){
			String ret=matcher.group(1);    
		    if(!StringUtils.isEmpty(ret)){  
		    	returnValue = ret.replaceAll("\"", "");
		    }else{  
		    }  
		}
//		System.out.println("returnValue:"+returnValue);
		return returnValue;
	}
	
	public static String getValue2(String jsonStr,String key){
		String returnValue  ="";
		String regex = "\""+key+"\"";
		int p = jsonStr.indexOf(regex);
		if(p>=0){
			p = p+regex.length();
			int endPost = jsonStr.indexOf(",", p);
			if(endPost>=0){
				returnValue =jsonStr.substring(p, endPost);
			}else{
				endPost = jsonStr.indexOf("}", p);
				if(endPost>=0){
					returnValue =jsonStr.substring(p, endPost);
				}
			}
			
			returnValue = returnValue.replaceAll("[\"| ]", "").replaceFirst(":", "");
		}
		return returnValue;
	}

}
