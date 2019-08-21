package net.messi.early.websocket;

import com.google.gson.Gson;
import net.messi.early.VO.*;
import net.messi.early.utils.JsonToObject;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebSocketPushHandler implements WebSocketHandler {

    private static final List<WebSocketSession> users = new ArrayList<>();

    // 用户进入系统监听
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("成功进入了...." + session);
        users.add(session);
        //sendMessagesToUsers(new TextMessage("今天晚上服务器维护,请注意"));
    }


    // 将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
    // 我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等
    // TextMessage msg = (TextMessage)message.getPayload();
    // 给所有用户群发消息
    //sendMessagesToUsers(msg);
    // 给指定用户群发消息
    //sendMessageToUser(userId, msg);

    /**
     * 处理前端发送的文本信息 js调用websocket.send时候，会调用该方法
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //根据客户端传来的UserToken和店家的id进行交流
        ChatVO chatMsg = JsonToObject.toChatVo(message.getPayload().toString());
        System.out.println(chatMsg);
        Gson gson = new Gson();
        //判断Toid 是否是店家id  需要返回不同的数据结构
        if (chatMsg.getTo() == 314) {
            //店家 文本还是图片
            if (chatMsg.getType().equals("text")) {
                //接收方是店家
                ServerClient client = new ServerClient();
                StoreDataVO storeDataVO = new StoreDataVO();
                storeDataVO.setId(chatMsg.getFrom() + "");
                storeDataVO.setAvatar(chatMsg.getAvatar());
                storeDataVO.setUsername(chatMsg.getName());
                storeDataVO.setContent(chatMsg.getContent());
                client.setData(storeDataVO);
                //发送
                sendMessageToUser(chatMsg.getTo() + "", new TextMessage(gson.toJson(client)));
            } else if (chatMsg.getType().equals("image")) {
                ServerClient client = new ServerClient();
                StoreDataVO storeDataVO = new StoreDataVO();
                storeDataVO.setId(chatMsg.getFrom() + "");
                storeDataVO.setAvatar(chatMsg.getAvatar());
                storeDataVO.setUsername(chatMsg.getName());
                storeDataVO.setContent("img[" + chatMsg.getContent() + "]");
                client.setData(storeDataVO);
                //发送
                sendMessageToUser(chatMsg.getTo() + "", new TextMessage(gson.toJson(client)));
            } else {
                System.out.println("未发送");
            }
        } else {
            //文字还是图片
            if (chatMsg.getContent().startsWith("img")) {
                WxClient wxClient = new WxClient();
                wxClient.setType("image");
                wxClient.setName(chatMsg.getName());
                wxClient.setAvatar(chatMsg.getAvatar());
                wxClient.setContent(chatMsg.getContent().substring(4, chatMsg.getContent().length() - 1));
                wxClient.setImages(null);
                sendMessageToUser(chatMsg.getTo() + "", new TextMessage(gson.toJson(wxClient)));
            } else {
                //接收方是用户
                if (chatMsg != null) {
                    WxClient wxClient = new WxClient();
                    wxClient.setType("text");
                    wxClient.setName(chatMsg.getName());
                    wxClient.setAvatar(chatMsg.getAvatar());
                    wxClient.setContent(chatMsg.getContent());
                    wxClient.setImages(null);
                    sendMessageToUser(chatMsg.getTo() + "", new TextMessage(gson.toJson(wxClient)));
                }
            }
        }
    }

    // 后台错误信息处理方法
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        users.remove(webSocketSession);
    }

    // 用户退出后的处理，不如退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有的用户发送消息
     */
    public void sendMessagesToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                // isOpen()在线就发送
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息给指定的用户
     */
    public void sendMessageToUser(String toUserId, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("token").equals(toUserId)) {
                try {
                    //isOpen()在线就发送
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    } else {
                        ChatVO vo = new ChatVO();
                        vo.setContent("对方暂时不在线上");
                        Gson gson = new Gson();
                        user.sendMessage(new TextMessage(gson.toJson(vo)));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
