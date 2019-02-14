package com.yydone.demo.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttServer {

    public static final String HOST = "tcp://10.6.124.16:1883";
    public static final String TOPIC = "mtopic";
    private static final String clientid = "server11";

    private MqttClient client;
    private MqttTopic topic11;
    private String userName = "stonegeek";
    private String passWord = "123456";

    private MqttMessage message;


    public MqttServer() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    /**
     *  用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        //options.setUserName(userName);
        //options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);

            topic11 = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    /**
     *  启动入口
     * @param args
     * @throws MqttException
     */
    public static void main(String[] args) throws MqttException {
        MqttServer server = new MqttServer();

        server.message = new MqttMessage();
        server.message.setQos(1);
        server.message.setRetained(true);
        server.message.setPayload("hello,topic11".getBytes());
        server.publish(server.topic11 , server.message);
        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}
