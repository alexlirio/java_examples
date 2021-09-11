/*
 * # Move this credentials file to (~/.aws/credentials)
 * # after you fill in your access and secret keys in the default profile
 *
 * # WARNING: To avoid accidental leakage of your credentials,
 * #          DO NOT keep this file in your source directory.
 * [default]
 * aws_access_key_id=XXXXX
 * aws_secret_access_key=ZZZZZ
 * 
 */
package br.com.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;

public class AmazonSMSs {
	
	public static void main(String[] args) {
        String message = "My SMS message. SB 003.";
        String[] phoneNumbers = {"+5521988844171","+5521996427971"};
        send(message, phoneNumbers);
	}
	
	public static void send(String message, String[] phoneNumbers) {
		AmazonSNS snsClient = new AmazonSNSClient();
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
        //<set SMS attributes>
        String topicArn = createSNSTopic(snsClient);
        for (int i = 0; i < phoneNumbers.length; i++) {
        	subscribeToTopic(snsClient, topicArn, "sms", phoneNumbers[i]);
		}
        sendSMSMessageToTopic(snsClient, topicArn, message, smsAttributes);
	}
	
	public static String createSNSTopic(AmazonSNS snsClient) {
	    CreateTopicRequest createTopic = new CreateTopicRequest("mySNSTopic");
	    CreateTopicResult result = snsClient.createTopic(createTopic);
	    System.out.println("Create topic request: " + snsClient.getCachedResponseMetadata(createTopic));
	    System.out.println("Create topic result: " + result);
	    return result.getTopicArn();
	}
	
	public static void subscribeToTopic(AmazonSNS snsClient, String topicArn, 
			String protocol, String endpoint) {	
	        SubscribeRequest subscribe = new SubscribeRequest(topicArn, protocol, endpoint);
	        SubscribeResult subscribeResult = snsClient.subscribe(subscribe);
	        System.out.println("Subscribe request: " + snsClient.getCachedResponseMetadata(subscribe));
	        System.out.println("Subscribe result: " + subscribeResult);
	}
	
	public static void sendSMSMessageToTopic(AmazonSNS snsClient, String topicArn, 
			String message, Map<String, MessageAttributeValue> smsAttributes) {
	        PublishResult result = snsClient.publish(new PublishRequest()
	                        .withTopicArn(topicArn)
	                        .withMessage(message)
	                        .withMessageAttributes(smsAttributes));
	        System.out.println(result);
	}
}
