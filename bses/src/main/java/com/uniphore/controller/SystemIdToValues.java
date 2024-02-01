package com.uniphore.controller;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uniphore.dto.AgentTransferDto;
import com.uniphore.entity.ReportEntity;
import com.uniphore.repository.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin
public class SystemIdToValues {

	@Value("${RDS_url}")
	private String RDS_url;
	
	@Value("${variables}")
	private String variables;
	
	@Value("${Application-Key}")
	private String Application_Key;
	
	@Value("${Env}")
	private String Env;
	
	@Value("${Tenant-Id}")
	private String Tenant_Id;
	
	@Autowired
	Report report;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemIdToValues.class);
	
	@PostMapping("/SystemIdToValues")
	public String getData(@RequestParam("externalSystemId") String externalSystemId) throws JSONException 
	{
		Date date = new Date();
		LOGGER.info(" request externalSystemId : "+externalSystemId +".  Time : " +date);
				System.out.println("SystemIdToValues"+RDS_url );
				JSONObject res = new JSONObject();
				StringBuilder BSES_Address_UserInput =new StringBuilder();
				HashMap<String, String> hm = new HashMap<String, String>();
				RestTemplate restTemplate = new RestTemplate();
				String RDS_api = new StringBuilder(RDS_url).append("variables=").append(variables).append("&externalSystemId=").append(externalSystemId).toString();
				System.out.println("RDS_api: " + RDS_api);

				HttpHeaders headers = new HttpHeaders();
				headers.add("Env", Env);
				headers.add("Application-Key", Application_Key);
				headers.add("Tenant-Id", Tenant_Id);
			    HttpEntity<String> entity = new HttpEntity<>("authentication", headers);

				ResponseEntity<String> response = restTemplate.exchange	(RDS_api, HttpMethod.POST, entity, String.class);
				LOGGER.info(" RDS api response  : "+ response.getBody() +"  Id : " + externalSystemId);
				
				System.out.println("response.getBody(): " + response.getBody().length());
				
				if(response.getBody().length() > 3) {
					JSONArray jsonArr = new JSONArray(response.getBody());
					JSONObject jsonObj = jsonArr.getJSONObject(0);
					JSONArray jsonArr_var = jsonObj.getJSONArray("variables");
				
				for(int i =0 ; i<jsonArr_var.length(); i++) {
					JSONObject jsonObj_var = jsonArr_var.getJSONObject(i);
					String jsonArr_key = jsonObj_var.getString("name");
					String jsonArr_value = jsonObj_var.getString("lastValue");
//					System.out.println("jsonArr_key: " + jsonArr_key);
//					JSONArray jsonArr_values= jsonObj_var.getJSONArray("values");
//					JSONObject jsonObj_values = jsonArr_values.getJSONObject(0);
					System.out.println("jsonArr_value: " + jsonArr_value);
					
					
					if(jsonArr_key.equalsIgnoreCase("BSES_CANumber")) {
						res.put("BSES_CANumber_UserInput", jsonArr_value);
					}else if(jsonArr_key.equalsIgnoreCase("Last_Intent")) {
						res.put("Last_Intent", jsonArr_value);
					}else if(jsonArr_key.equalsIgnoreCase("BSES_Customer_name")) {
						res.put("BSES_Customer_name", jsonArr_value);
					}else {
//						if(jsonArr_value.equalsIgnoreCase("") && jsonArr_value != null && jsonArr_value != "") {
							BSES_Address_UserInput.append(" ").append(jsonArr_value);
//							System.out.println("value: " + jsonArr_value);
//						}
					}
					
//					res.put(jsonArr_key, jsonObj_values.getString("value"));
					
				}
				res.put("BSES_Address_UserInput", BSES_Address_UserInput);
	            }else {
	            	res.put("BSES_CANumber_UserInput", "");
	            	res.put("Last_Intent", "");
	            	res.put("BSES_Customer_name", "");
	            	res.put("BSES_Address_UserInput", "");
	            	
	            }
				LOGGER.info(" final response  : "+ res.toString() +"  Id : " + externalSystemId);
				System.out.println("res: " + res.toString());
				return res.toString();
	}
	
	@PostMapping("/agentTransferData")
	public String agentTransferData(@RequestBody ReportEntity dto)  throws JSONException {
		
//		System.out.println("req: " + dto.getCall_id());
//		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
//	     String pattern = "yyyy-MM-dd HH-mm";
//	     Date dateInString =new SimpleDateFormat(pattern).format(new Date());
//				    System.out.println("date : "+dateInString );
		
		Date date = new Date();
		LOGGER.info(" request instance_id : "+dto.getInstance_id()+".  Time : " +date);
		LOGGER.info("request mobile_number : "+dto.getMobile_number());
		LOGGER.info(" request agent_transferlevel : "+dto.getAgent_transferlevel());
		LOGGER.info(" request call_id : "+dto.getCall_id());
		
		
		
		    //System.out.println("ran: " + ran);
		
		if(dto.getInstance_id() == null || dto.getInstance_id().equals("")) {
			
			 Random r = new Random(System.currentTimeMillis());
			    int ran =  1000000000 + r.nextInt(2000000000);
			
			dto.setInstance_id("bot_unreached_"+ String.valueOf(ran));
		}
		
		dto.setCall_date(date);
		dto.setComplaintregisteredin_bot("");
		dto.setDisconnect_bot("");
		dto.setLast_intent("");
		dto.setBses_call_status("");
		dto.setCisco_agent_transfer(dto.getAgent_transferlevel());
		
		
		System.out.println("req: " + dto.getInstance_id());
		report.save(dto);
		LOGGER.info(" response  : "+"success."+" Time :" + date);
		return "Success";
	}
}
